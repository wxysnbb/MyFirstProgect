package cn.wd;

import java.nio.IntBuffer;

public class Nio {
    public static void main(String[]args){
        IntBuffer intBuffer = IntBuffer.allocate(5);
        System.out.println("capacity===========>"+intBuffer.capacity());
        System.out.println("limit===========>"+intBuffer.limit());
        System.out.println("position===========>"+intBuffer.position());
        int []num ={1,1,1,1,1};
        intBuffer.put(num);
        System.out.println("capacity===========>"+intBuffer.capacity());
        System.out.println("limit===========>"+intBuffer.limit());
        System.out.println("position===========>"+intBuffer.position());
    }
}
