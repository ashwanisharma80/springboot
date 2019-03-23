package com.droidinfotech.packages.repository;

import com.droidinfotech.packages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String username);
}
