package cn.wd;

import java.io.*;

public class inputStream {
    public static void main(String[]args) throws IOException {
        InputStream inputStream=new FileInputStream("d:/wxy.txt");
        OutputStream outputStream=new FileOutputStream("d:/wxy.txt",true);
        outputStream.write("wsnbb".getBytes());
        int nums=0;
        //read 方法返回0~255之间的数，如果流读到了最后将返回-1
        while((nums=inputStream.read())!=-1){
            System.out.println((char) nums);
        }
        outputStream.close();
        inputStream.close();
    }
}
