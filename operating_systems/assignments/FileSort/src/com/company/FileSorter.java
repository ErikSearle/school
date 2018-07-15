package com.company;

import java.io.*;

public class FileSorter {

    private File file;
    private DataOutputStream output;
    private DataInputStream input;

    public FileSorter(File file) throws IOException{
        this.file = file;
        try {
            output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        } catch(IOException e){
            System.out.println(e);
            throw e;
        }
    }

    public FileSorter sort() throws IOException{
        boolean sorted = false;
        while(!sorted){
            byte[] firstLine = new byte[32];
            byte[] secondLine = new byte[32];
            while( input.read(secondLine) != -1 ){
                System.out.println(firstLine[0]);
//                if(firstLine == ""){
//                    firstLine = secondLine;
//                    continue;
//                }
//                else{
//
//                }
            }
        }
        return this;
    }

    public File getFile(){
        return file;
    }
}
