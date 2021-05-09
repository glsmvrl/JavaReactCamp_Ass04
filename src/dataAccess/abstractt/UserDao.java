package dataAccess.abstractt;
import entities.concretes.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public void deletedUser(User user);

    User get(int id);
    List<User> getAll();
    String getAllEmail(String mail);


}
