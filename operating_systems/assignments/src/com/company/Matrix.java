package com.company;

import java.util.Random;

public class Matrix {

    private int[][] matrix;
    private final int numRows;
    private final int numColumns;

    public Matrix(int numRows, int numColumns){
        this.numRows = numRows;
        this.numColumns = numColumns;
        matrix = new int[this.numRows][this.numColumns];
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumColumns() {
        return numColumns;
    }

    public int getItemAt(int row, int column){
        if(row > numRows || column > numColumns){
            throw new NullPointerException("Row or column exceeds size of matrix");
        }
        return matrix[row][column];
    }

    public void setItemAt(int value, int row, int column){
        if(row > numRows || column > numColumns){
            throw new NullPointerException("Row or column exceeds size of matrix");
        }
        matrix[row][column] = value;
    }

    public int[] getRowAt(int row){
        return matrix[row];
    }

    public Matrix randomFill(){
        return randomFill(0, int.MAX_VALUE);
    }

    public Matrix randomFill(int max){
        return randomFill(0, max);
    }

    public Matrix randomFill(int min, int max){
        if(max < min){
            throw new IllegalArgumentException("Min cannot exceed max");
        }
        Random rand = new Random();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = rand.nextInt(max - min) + min;
            }
        }
        return this;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            if(i != matrix.length-1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
