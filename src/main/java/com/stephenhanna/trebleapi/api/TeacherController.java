package com.stephenhanna.trebleapi.api;

import com.stephenhanna.trebleapi.entity.Teacher;
import com.stephenhanna.trebleapi.entity.User;
import com.stephenhanna.trebleapi.model.exception.ApiExceptionModel;
import com.stephenhanna.trebleapi.service.TeacherService;
import com.stephenhanna.trebleapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Teacher", description = "Teacher management APIs")
@RestController
@RequestMapping(path = "api/v1/teacher")
@AllArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    @Operation(summary = "Get teachers", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class)))
    })
    public List<Teacher> getTeachers() {
        return teacherService.getTeachers();
    }

    @GetMapping("/{teacherId}")
    @Operation(summary = "Get teacher by id", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class)))
    })
    public Teacher getTeacherById(@PathVariable int teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

}
