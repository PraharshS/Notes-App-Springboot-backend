package net.project.springboot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.project.springboot.models.User;
import net.project.springboot.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(String username) {
        // username is username= when sent from node
        List<User> userList = userRepository.findByUsername(username);
        if (userList.isEmpty()) {
            return new User();
        }
        return userList.get(0);
    }
}
