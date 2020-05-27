package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.User;
import kr.re.kitri.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}
