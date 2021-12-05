package com.vuespringboot.business.user.repository;

import com.vuespringboot.business.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByName(String name);
}
