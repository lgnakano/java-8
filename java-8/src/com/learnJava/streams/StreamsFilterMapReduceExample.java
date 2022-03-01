package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.function.Predicate;

public class StreamsFilterMapReduceExample {

    static Predicate<Student> genderPredicte =(student -> student.getGender().equals("female"));

    static Predicate<Student> gradeLevel =(student -> student.getGradeLevel() >= 3);

    private static int noOfNoteBooks(){

        return StudentDataBase.getAllStudents()
                .stream()
//                .filter(genderPredicte)
                .filter(gradeLevel)
                .peek(System.out::println)
              /*  .peek(s->{
                    System.out.println("s : "+ s);
                })*/
                .map((Student::getNoteBooks))
                .peek(System.out::println)
               // .reduce(0,(a,b)->a+b); //summing the notebooks.
                .reduce(0,Integer::sum);

    }
    public static void main(String[] args) {

        System.out.println("Total No of NoteBooks are : " + noOfNoteBooks());
    }
}
