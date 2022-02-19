package com.learnJava.data;

import lombok.*;

//import java.util.ArrayList;
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


//    public Student(String name, int gradeLevel, double gpa, String gender, int noteBooks, List<String> activities) {
//        this.name = name;
//        this.gradeLevel = gradeLevel;
//        this.gpa = gpa;
//        this.gender = gender;
//        this.noteBooks = noteBooks;
//        this.activities = activities;
//    }

//    public Optional<Bike> getBike() {
//        return bike;
//    }
//
//    public void setBike(Optional<Bike> bike) {
//        this.bike = bike;
//    }
//
//    public int getNoteBooks() {
//
//        return noteBooks;
//    }
//
//    public void setNoteBooks(int noteBooks) {
//        this.noteBooks = noteBooks;
//    }
//
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

//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getGradeLevel() {
//        return gradeLevel;
//    }
//
//    public void setGradeLevel(int gradeLevel) {
//        this.gradeLevel = gradeLevel;
//    }
//
//    public double getGpa() {
//        return gpa;
//    }
//
//    public void setGpa(double gpa) {
//        this.gpa = gpa;
//    }



//    public  List<String> getActivities() {
//        return this.activities;
//    }
//
//    public void setActivities(List<String> activities) {
//        this.activities = activities;
//    }

    public void printListOfActivities(){

        System.out.println("List of Activities are : " + this.activities);
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", gradeLevel=" + gradeLevel +
//                ", gpa=" + gpa +
//                ", gender='" + gender + '\'' +
//                ", activities=" + activities +
//                '}';
//    }


}
