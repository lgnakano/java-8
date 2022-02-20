package com.learnJava.data;

import lombok.*;

import java.util.List;
import java.util.Optional;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Student {

    @NonNull
    @Getter @Setter private String name;
    @NonNull
    @Getter @Setter private int gradeLevel;
    @NonNull
    @Getter @Setter private double gpa;
    @NonNull
    @Getter @Setter private String gender;
    @NonNull
    @Getter @Setter private int noteBooks;
    @NonNull
    @Getter @Setter private List<String> activities;

    @Getter @Setter private Optional<Bike> bike;

    public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities) {
        this.name = name;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
        this.gender = gender;
        this.activities = activities;
    }

    public Student(String s) {
        this.name = s;
    }

    public void printListOfActivities(){

        System.out.println("List of Activities are : " + this.activities);
    }

}
