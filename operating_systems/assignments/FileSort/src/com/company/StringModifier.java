package com.company;

public class StringModifier {

    public static char[] to32BitCharArray(String string){
        char[] returnable = new char[32];
        char[] charArray = string.toCharArray();

        for(int i=0; i<charArray.length && i<32; i++){
            returnable[i] = charArray[i];
        }
         return returnable;
    }
}
