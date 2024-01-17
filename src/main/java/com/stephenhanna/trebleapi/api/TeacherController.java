package com.stephenhanna.trebleapi.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Teacher", description = "Teacher management APIs")
@RestController
@RequestMapping(path = "api/v1/teacher")
@AllArgsConstructor
@Slf4j
public class TeacherController {

}
