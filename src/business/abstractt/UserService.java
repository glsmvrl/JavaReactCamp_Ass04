package business.abstractt;
import entities.concretes.User;

import java.util.List;

public interface UserService {

     void register(User user);
     void userLogin(String email, String password);
     void loginWithGoogle(String mail, String password);

    List<User> getAllUser();

    String getEmail(String mail);


}
