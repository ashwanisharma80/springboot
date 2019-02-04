package com.droidinfotech.packages.model;

import org.springframework.data.repository.CrudRepository;

import com.droidinfotech.packages.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value="SELECT * FROM user a WHERE a.username=:username and a.password=:password",nativeQuery = true)
    public List checkLogin(@Param("username") String username,@Param("password") String password);
}
