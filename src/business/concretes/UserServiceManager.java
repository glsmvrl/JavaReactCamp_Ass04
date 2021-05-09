package business.concretes;
import java.util.List;
import java.util.regex.Pattern;
import business.abstractt.UserService;
import dataAccess.abstractt.UserDao;
import dataAccess.concretes.ActivityUserDao;
import entities.concretes.User;
import core.abstractt.GoogleService;
import core.abstractt.VerifyingCodeService;

public class UserServiceManager implements UserService {

    private UserDao userDao;
    private VerifyingCodeService codeService;
    private GoogleService googleService;

    public UserServiceManager(UserDao userDao, VerifyingCodeService codeService, GoogleService googleService) {
        super();
        this.userDao = userDao;
        this.codeService = codeService;
        this.googleService = googleService;
    }

    public static boolean isEmailValid(String emailInput) {
        final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        return pattern.matcher(emailInput).find();
    }

    @Override
    public void register(User user) {
        if(user.getPassword().length() < 6) {
            System.out.println("Password must be at least 6 characters.");
        }
        else if(isEmailValid(user.getEmail()) == false) {
            System.out.println("Mail is wrong.");
        }
        else if(user.getName().length() < 2 && user.getLastName().length() < 2) {
            System.out.println("Small number characters.");
        }
        else if(getEmail(user.getEmail()) != null) {
            System.out.println("This e-mail can not use.");
        }
        else {
            System.out.println("Email registration successful.");
            this.userDao.addUser(user);
            this.codeService.verifyingcode();
        }
    }


    @Override
    public void userLogin(String email, String password) {
        for(User user : this.userDao.getAll()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                System.out.println("Successful login.");
                break;
            }
        }
    }

    @Override
    public void loginWithGoogle(String mail, String password) {
        for (User user : this.userDao.getAll()) {


            if(user.getEmail().equals(mail) && user.getPassword().equals(password)) {

                System.out.println("Successful login.");
                googleService.loginWithGoogle(mail, password);
                this.codeService.verifyingcode();

                break;
            }

        }

    }


    @Override
    public List<User> getAllUser() {
        return this.userDao.getAll();
    }

    @Override
    public String getEmail(String mail) {
        return this.userDao.getAllEmail(mail);
    }
}
