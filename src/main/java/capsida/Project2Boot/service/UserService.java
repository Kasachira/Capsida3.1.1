package capsida.Project2Boot.service;



import capsida.Project2Boot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void del(User user);
    void update(User user);
    User getUserById(Long id);
}
