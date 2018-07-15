package com.company;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Student {

    private byte[] studentRecord;

    public Student(int studentNumber, String studentName) {
        studentRecord = new byte[36];

        byte[] numBytes = ByteConverter.intTo4Bytes(studentNumber);
        byte[] nameBytes = ByteConverter.stringTo32Bytes(studentName);
        for(int i=0; i<4; i++){
            studentRecord[i] = numBytes[i];
        }
        for(int i=0; i<32; i++){
            studentRecord[i+4] = nameBytes[i];
        }

    }

    public byte[] getStudentRecord(){
        return studentRecord;
    }

}
