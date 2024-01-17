package com.stephenhanna.trebleapi.entity;

import com.stephenhanna.trebleapi.model.request.UserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private LocalDate dob;
    private LocalDateTime registeredTimestamp;
    private LocalDateTime lastLoginTimestamp;
    @Column(name = "s3_image_name")
    private String s3ImageName;

    public User(UserRequest userRequest) {
        this.firstName = userRequest.getFirstName();
        this.lastName = userRequest.getLastName();
        this.email = userRequest.getEmail();
        this.passwordHash = userRequest.getPasswordHash();
        this.dob = userRequest.getDob();
        this.registeredTimestamp = userRequest.getRegisteredTimestamp();
        this.lastLoginTimestamp = userRequest.getLastLoginTimestamp();
        this.s3ImageName = userRequest.getS3ImageName();
    }

}
