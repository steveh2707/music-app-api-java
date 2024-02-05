package com.stephenhanna.trebleapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teacher_instrument")
public class TeacherInstrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_instrument_id")
    private int teacherInstrumentId;
    private int lessonCost;
//    private int gradeId;
//    private int instrumentId;

//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

}
