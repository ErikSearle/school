package com.company;

public class Student {

    private int studentNumber;
    private char[] studentName;

    public Student(int studentNumber, String studentName){
        this.studentNumber = studentNumber;
        this.studentName = StringModifier.to32BitCharArray(studentName);
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public char[] getStudentName() {
        return studentName;
    }

    public String toString(){
        return studentNumber + new String(studentName);
    }
}
