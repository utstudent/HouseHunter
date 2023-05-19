package online.househunter.Services;

import online.househunter.Models.User;
import online.househunter.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired private BCryptPasswordEncoder encoder;

    @Autowired private UserRepository userRepository;

    // save new user
    public void save(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User edit(User user) {
        userRepository.save(user);
        return user;
    }
    // get by id
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findByKeyword(String keyword){
        return userRepository.findByKeyword(keyword);
    }
}
