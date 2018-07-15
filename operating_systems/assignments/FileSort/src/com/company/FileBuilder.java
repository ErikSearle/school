package com.company;

import java.io.*;

public class FileBuilder {

    private String fileName;
    private File file;
    private DataOutputStream writer;

    public FileBuilder(String fileName) throws IOException {
        // TODO: ensure fileName is proper file name with .*** at the end somehow
        // TODO: figure out what to do in case of IOException
        this.fileName = fileName;
        file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch(IOException e){
                System.out.println(e);
                throw e;
            }
        }
        writer = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
    }

    public String getFileName() {
        return fileName;
    }

    public File getFile() {
        return file;
    }

    public FileBuilder writeLine(Object o) throws IOException {
        try {
            writer.writeBytes(o.toString());
            System.out.println(writer.size());
        } catch(IOException e){
            System.out.println(e);
            throw e;
        }
        return this;
    }

    public FileBuilder close() throws IOException{
        try {
            writer.close();
        } catch(IOException e){
            System.out.println(e);
            throw e;
        }
        return this;
    }
}
