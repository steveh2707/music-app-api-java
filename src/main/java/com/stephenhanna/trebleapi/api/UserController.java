package com.stephenhanna.trebleapi.api;

import com.stephenhanna.trebleapi.entity.User;
import com.stephenhanna.trebleapi.model.exception.ApiExceptionModel;
import com.stephenhanna.trebleapi.model.request.UserRequest;
import com.stephenhanna.trebleapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User", description = "User management APIs")
@RestController
@RequestMapping(path = "api/v1/user")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get users", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class)))
    })
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    @Operation(summary = "Get user by id", responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class)))
    })
    public User getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    @Operation(summary = "Create new user", responses = {
            @ApiResponse(responseCode = "201", description = "Created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class))),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content(schema = @Schema(implementation = ApiExceptionModel.class)))
    })
    public void registerNewUser(@RequestBody UserRequest user) {
        userService.addNewUser(user);
    }

}
