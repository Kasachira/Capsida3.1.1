package capsida.Project2Boot.dao;



import capsida.Project2Boot.model.User;

import java.util.List;

public interface UserDao {

    List<User> listUsers();
    void add(User user);
    void del(User user);
    void update(User user);
    User getUserById(Long id);
}
