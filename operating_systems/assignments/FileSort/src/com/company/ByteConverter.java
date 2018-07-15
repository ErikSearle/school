package com.company;

import java.nio.ByteBuffer;

public class ByteConverter {

    public static byte[] stringTo32Bytes(String string){
        byte[] returnable = new byte[32];
        char[] charArray = string.toCharArray();

        for(int i=0; i<charArray.length && i<32; i++){
            returnable[i] = (byte) charArray[i];
        }
         return returnable;
    }

    public static byte[] intTo4Bytes(int num){
        ByteBuffer buff = ByteBuffer.allocate(4);
        buff.putInt(num);
        return buff.array();
    }

    public static int bytesToInt(byte[] bytes){
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        return bb.getInt();
    }
}
