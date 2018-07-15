package com.company;

public class MatrixTransposer {

    public static Matrix transpose(Matrix matrix){
        Matrix returnable = new Matrix(matrix.getNumColumns(), matrix.getNumRows());
        for(int i=0; i<returnable.getNumRows(); i++){
            for(int j=0; j<returnable.getNumColumns(); j++){
                returnable.setItemAt(matrix.getItemAt(j, i), i, j);
            }
        }
        return returnable;
    }
}
