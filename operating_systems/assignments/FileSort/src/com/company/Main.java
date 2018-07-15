package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    /*
        Take inputs form the user for 5 student names and numbers.
        Write the student entries to a file
        Open the file and sort it
        Close the file
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(72, "James"));
        students.add(new Student(56, "Mark"));
        students.add(new Student(87, "John"));
        students.add(new Student(30, "Phillip"));
        students.add(new Student(44, "Andrew"));

        FileBuilder fb = new FileBuilder("student_record");
        for(int i=0; i<5; i++){
            fb.writeLine(students.get(i));
        }
        fb.close();

//        File file = fb.getFile();
//
//        file = new FileSorter(file).sort().getFile();
    }
}
