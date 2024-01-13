package com.example.SpringDemoStudent.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int studentRollNumber;
    private String studentName;
    private String studentContactNumber;
    private String studentAddress;
    private int studentTotalMarks;
    private int studentObtainMarks;

}
