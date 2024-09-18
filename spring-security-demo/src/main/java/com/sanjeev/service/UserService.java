package com.sanjeev.service;

import com.sanjeev.repo.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;



    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User savedUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepo.save(user);

    }

    @PostMapping("login")
    public String login(@RequestBody User user) {
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());


        if (auth.isAuthenticated())
            return auth.getName();
        else
            return "Login Failed";


    }
}
