package com.stephenhanna.trebleapi.repository;

import com.stephenhanna.trebleapi.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
