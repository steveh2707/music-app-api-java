package com.stephenhanna.trebleapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacherId;
    private String tagline;
    private String bio;
    private String locationTitle;
    private double locationLatitude;
    private double locationLongitude;
    private double averageReviewScore;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

//    @ToString.Exclude
//    @OneToMany(mappedBy = "teacher")
//    private List<TeacherInstrument> playedInstruments;

//    @ManyToMany
//    @JoinTable(
//            name = "teacher_instrument",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "instrument_id"))
//    private List<Instrument> instruments;
}
