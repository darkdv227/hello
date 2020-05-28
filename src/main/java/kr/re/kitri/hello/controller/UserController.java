package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.User;
import kr.re.kitri.hello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/users")
    public List<User> viewAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public User viewUserDetails(@PathVariable String userId) {
        logger.debug("잘 조회 되었습니다. " + userId);
        return userService.getUserDetails(userId);
    }

}
