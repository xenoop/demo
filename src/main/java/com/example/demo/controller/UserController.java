package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.entities.User;
import com.example.demo.payload.*;
import com.example.demo.repositories.UserRepository;
//import com.example.demo.security.UserPrincipal;
//import com.example.demo.security.CurrentUser;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt());

        return userProfile;
    }
    @GetMapping("/users/role")
    public List<Object> getauthorities(@CurrentUser UserPrincipal currentUser){
        List<Object> role = new ArrayList<Object>();
        role= Arrays.asList(currentUser.getAuthorities().toArray());
        return role;
    }
    @PostMapping(value = "/test")
    public String testauth(@RequestBody LoginRequest user){
        if (user.getUsernameOrEmail().equals("test") && user.getPassword().equals("test")){
            return "success";
        }
        else return "failed";

    }
    @Autowired
    UserRepository ur;
    @PostMapping(value="/testmock")
    public String testmock(@RequestBody LoginRequest user) {
        if (ur.existsByPassword(user.getPassword()) && ur.existsByUsername(user.getUsernameOrEmail())) {
            return "success";
        }
        else return "failed";
    }}