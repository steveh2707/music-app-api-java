package com.stephenhanna.trebleapi.repository;

import com.stephenhanna.trebleapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<User, Integer> {
}
