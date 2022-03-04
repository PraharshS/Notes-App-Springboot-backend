package net.project.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.project.springboot.Services.UserService;
import net.project.springboot.models.User;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    // add User
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/findByUsername")
    public User findByUsername(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return userService.findUser(user);
    }

}
