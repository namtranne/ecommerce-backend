package com.ecommerce.server.repository;


import com.ecommerce.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select new User(u.id, u.username, u.password) from User u where u.username = :username")
    User findByUsername(@Param(value="username") String username);

    @Query("select new User(u.id, u.username, u.password) from User u where u.id = :id")
    User findByUserId(@Param(value="id") Integer id);
}