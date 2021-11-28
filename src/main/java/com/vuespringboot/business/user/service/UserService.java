package com.vuespringboot.business.user.service;

import com.vuespringboot.business.user.entity.User;
import com.vuespringboot.business.user.form.UserForm;
import com.vuespringboot.business.user.form.UserForm.Response.Find;
import com.vuespringboot.business.user.repository.UserQueryRepository;
import com.vuespringboot.business.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    public List<Find> findAll(){
        return userRepository.findAll().stream()
                             .map(Find::of)
                             .collect(Collectors.toList());
    }
    public List<User> findAllJoinFetch(){
        return userQueryRepository.findAllJoinFetch();
    }
}
