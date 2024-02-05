package com.stephenhanna.trebleapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {
    private String tagline;
    private String bio;
    private String locationTitle;
    private double locationLatitude;
    private double locationLongitude;
    private double averageReviewScore;
}
