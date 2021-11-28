package com.vuespringboot.business.user.api;

import com.vuespringboot.business.user.entity.User;
import com.vuespringboot.business.user.form.UserForm;
import com.vuespringboot.business.user.form.UserForm.Response.Find;
import com.vuespringboot.business.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public String save(@RequestBody User user){
        final User savedUser = userService.save(user);
        return savedUser.getName() + " 저장";
    }

    @GetMapping("/users")
    public List<Find> findAll(){
        return userService.findAll();
    }
    @GetMapping("/users/fetch")
    public List<User> findAllJoinFetch(){
        return userService.findAllJoinFetch();
    }
}
