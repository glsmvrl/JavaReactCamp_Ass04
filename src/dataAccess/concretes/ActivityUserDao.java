package dataAccess.concretes;
import dataAccess.abstractt.UserDao;
import entities.concretes.User;
import core.abstractt.VerifyingCodeService;

import java.util.ArrayList;
import java.util.List;

public class ActivityUserDao implements UserDao {

    List<User> userList = new ArrayList<>();

    @Override
    public void addUser(User user) {
        System.out.println(user.getName() + " " + user.getLastName() + " user successfully added.");
        userList.add(user);
    }

    @Override
    public void updateUser(User user) {
        System.out.println(user.getName() + " " + user.getLastName() + " user successfully updated.");

    }

    @Override
    public void deletedUser(User user) {
        System.out.println(user.getName() + " " + user.getLastName() + " user successfully deleted.");

    }

    @Override
    public User get(int id) {
        return this.userList.get(id);
    }

    @Override
    public List<User> getAll() {
        return userList;
    }

    @Override
    public String getAllEmail(String mail) {
        String mailReturn = null;
        for(User user : userList){
            if(user.getEmail().equals(mail)){
                mailReturn = mail;
                break;
            }
        }
        return mailReturn;
    }
}
