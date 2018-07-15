package com.company;

public class MatrixMultiplier {

    public Matrix multiply(Matrix a, Matrix b) {
        if (a.getNumRows() != b.getNumColumns()) {
            throw new IllegalArgumentException("Matrices not compatible for multiplication. Number of rows in first matrix must equal number of columns in second matrix");
        }

        Matrix returnable = new Matrix(b.getNumRows(), a.getNumColumns());
        Matrix bTranspose = MatrixTransposer.transpose(b);
        IndexCalculator[][] indexCalcs = new IndexCalculator[b.getNumRows()][a.getNumColumns()];

        for(int i=0; i<b.getNumRows(); i++){
            for( int j=0; j<a.getNumColumns(); j++){
                indexCalcs[i][j] = new IndexCalculator(a.getRowAt(i), bTranspose.getRowAt(j));
                indexCalcs[i][j].start();
            }
        }

        for(int i=0; i<b.getNumRows(); i++) {
            for (int j = 0; j < a.getNumColumns(); j++) {
                try {
                    indexCalcs[i][j].join();
                } catch(InterruptedException e){
                    System.out.println("Exception caught");
                }
                returnable.setItemAt(indexCalcs[i][j].getResult(), i, j);
            }
        }
        return returnable;
    }

    private class IndexCalculator extends Thread {

        private int result;
        private int[] row;
        private int[] column;

        public IndexCalculator(int[] row, int[] column){
            this.row = row;
            this.column = column;
        }

        public int getResult() { return result; }

        public void run(){
            result = 0;
            for(int i=0; i<row.length; i++){
                result += row[i]*column[i];
            }
        }
    }
}
