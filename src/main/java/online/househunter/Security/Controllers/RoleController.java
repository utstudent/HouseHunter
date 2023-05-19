package online.househunter.Security.Controllers;

import online.househunter.Models.User;
import online.househunter.Security.Models.Role;
import online.househunter.Security.Services.RoleService;
import online.househunter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired private UserService userService;

    @GetMapping("/security/user/Edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model){
        User user = userService.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("User with id " + id + " not found"));

        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "userEdit";
    }

    @GetMapping("/roles")
    public String goRoles(Model model){
        List<Role> roleList = roleService.getRoles();

        model.addAttribute("roles",roleList);
        return "role";
    }
    @PostMapping("/roles/addNew")
    public String addNew(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }
    @RequestMapping("roles/findById")
    @ResponseBody
    public Optional<Role> findById(Long id) {
        return roleService.findById(id);
    }

    @RequestMapping(value = "/roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }

    @RequestMapping(value = "/roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Long id) {
        roleService.delete(id);
        return "redirect:/roles";
    }

    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Long userId,
                             @PathVariable Long roleId){
        roleService.assignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }

    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Long userId,
                               @PathVariable Long roleId){
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/"+userId;
    }
}
