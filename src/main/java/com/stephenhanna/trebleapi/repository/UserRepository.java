package com.stephenhanna.trebleapi.repository;

import com.stephenhanna.trebleapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUserId(int userId);

}
