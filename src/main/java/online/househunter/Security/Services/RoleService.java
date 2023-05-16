package online.househunter.Security.Services;

import online.househunter.Models.User;
import online.househunter.Repositories.UserRepository;
import online.househunter.Security.Models.Role;
import online.househunter.Security.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    // Return all roles
    public List<Role> getRoles(){
        return roleRepository.findAll();
    }

    // save new role
    public void save(Role role) {
        roleRepository.save(role);
    }

    public Role edit(Role role) {
        roleRepository.save(role);
        return role;
    }

    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    // get by id
    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public void assignUserRole(Long userId, Long roleId){
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);

        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    public void unassignUserRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Set<Role> userRoles = user.getRoles();

        userRoles.removeIf(x -> x.getId() == roleId);
        userRepository.save(user);
    }

    public Set<Role> getUserRoles(User user){
        return user.getRoles();
    }

    public Set<Role> getUserNotRoles(User user){
        return roleRepository.getUserNotRoles(user.getId());
    }
}
