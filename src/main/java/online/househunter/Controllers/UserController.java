package online.househunter.Controllers;

import online.househunter.Models.User;
import online.househunter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired private UserService userService;
    @GetMapping("/users")
    public String goUsers(Model model){
        List<User> userList = userService.getUsers();

        model.addAttribute("users",userList);
        return "user";
    }

    //Modified method to Add a new user User
    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);
        RedirectView  redirectView= new RedirectView("/login",true);
        redir.addFlashAttribute("message",
                "You successfully registered! You can now login");
        return redirectView;
    }

    @PostMapping(value="users/addNewAsAdmin")
    public String addNewAsAdmin(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping("users/findById")
    @ResponseBody
    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
