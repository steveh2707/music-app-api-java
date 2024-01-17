package com.stephenhanna.trebleapi.model.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private LocalDate dob;
    private LocalDateTime registeredTimestamp;
    private LocalDateTime lastLoginTimestamp;
    private String s3ImageName;
}
