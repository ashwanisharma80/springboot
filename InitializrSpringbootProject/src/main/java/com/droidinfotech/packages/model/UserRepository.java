package com.droidinfotech.packages.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String username);

    @Query(value = "SELECT * FROM user a WHERE a.name=:username and a.password=:password", nativeQuery = true)
    public List checkLogin(@Param("username") String username, @Param("password") String password);
}
