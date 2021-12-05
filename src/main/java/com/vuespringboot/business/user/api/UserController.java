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
    public User save(@RequestBody User user){
        return userService.save(new User(user.getName(), true));
    }

    @GetMapping("/users")
    public List<Find> findAll(){
        return userService.findAll();
    }

    @GetMapping("/users/fetch")
    public List<User> findAllJoinFetch(){
        return userService.findAllJoinFetch();
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestBody User user){
        final User findUser = userService.findByName(user.getName());
        userService.delete(findUser);
        return findUser.getName()+"이 삭제되었습니다.";
    }
}
