package com.stephenhanna.trebleapi.service;

import com.stephenhanna.trebleapi.entity.Teacher;
import com.stephenhanna.trebleapi.entity.User;
import com.stephenhanna.trebleapi.repository.TeacherRepository;
import com.stephenhanna.trebleapi.service.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);

        if (teacher == null) {
            throw new ResourceNotFoundException("Teacher not found.");
        }

        return teacher;
    }
}
