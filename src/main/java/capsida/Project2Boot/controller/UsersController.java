package capsida.Project2Boot.controller;

import capsida.Project2Boot.model.User;
import capsida.Project2Boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.listUsers());
        return "users/users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        model.addAttribute("newUser", new User());
        return "users/new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user) {

        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String del(@PathVariable("id") Long id) {
        userService.del(userService.getUserById(id));
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getOneUser(Model model, @PathVariable("id") Long id ){
        model.addAttribute("userOne", userService.getUserById(id));
        return "users/user";
    }

}
