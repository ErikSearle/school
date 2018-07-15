package com.company;

import java.io.*;
import java.util.Arrays;

public class FileSorter {

    private File file;
    private RandomAccessFile fileEditor;

    public FileSorter(File file) throws IOException{
        this.file = file;
        try {
            fileEditor = new RandomAccessFile(this.file, "rw");
        } catch(IOException e){
            System.out.println(e);
            throw e;
        }
    }

    public FileSorter sort() throws IOException{
        /*
            while not sorted
                read a line
                while there are still bytes to read
                    read another line
                    compare the lines
                    if the lines are in the wrong order
                        swap them
                        trigger a boolean that it is not sorted
                    make first line = second line
         */
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            byte[] firstLine = new byte[36];
            byte[] secondLine = new byte[36];
            fileEditor.readFully(firstLine);

            boolean endOfFile = false;
            while(!endOfFile){
                try{
                    fileEditor.readFully(secondLine);
                } catch( EOFException e ){
                    endOfFile = true;
                    continue;
                }
                catch (IOException e){
                    System.out.println(e);
                    throw e;
                }

                if(ByteConverter.bytesToInt(Arrays.copyOfRange(firstLine,0,4)) > ByteConverter.bytesToInt(Arrays.copyOfRange(secondLine,0,4))){
                    fileEditor.seek(fileEditor.getFilePointer()-72);
                    fileEditor.write(secondLine);
                    fileEditor.write(firstLine);
                    sorted = false;
                }
                else{
                    firstLine = Arrays.copyOfRange(secondLine, 0, 36);
                }
            }
            fileEditor.seek(0);
        }
        return this;
    }

    public File getFile(){
        return file;
    }
}
