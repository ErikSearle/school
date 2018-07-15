package com.company;

public class Main {

    public static void main(String[] args) {
        Matrix a = new Matrix(4,4).randomFill(1,3);
        Matrix b = new Matrix(4,4).randomFill(1,3);
        MatrixMultiplier multi = new MatrixMultiplier();
        Matrix result = multi.multiply(a,b);
        System.out.println(a + "\n\n" + b + "\n\n" + result);
    }
}
