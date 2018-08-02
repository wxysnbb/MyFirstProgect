package cn.wd;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo04 {
    public static void main(String[] args) throws IOException {
//创建复制和复制到的文件地址
        File file1=new File("d:/wxy1.txt");
        File file2=new File("d:/wxy2.txt");
        File file=new File("d:/wxy.txt");
        //创建输入流和输出流
        FileInputStream input1=null;
        FileInputStream input2=null;
        FileOutputStream output1=null;
        FileOutputStream output2=null;
        //创建输入流和输出流管道
        FileChannel inChannel1=null;
        FileChannel inChannel2=null;
        FileChannel outChannel1=null;
        FileChannel outChannel2=null;
        //创建缓冲区
        ByteBuffer buffer1=ByteBuffer.allocate(1024);
        ByteBuffer buffer2=ByteBuffer.allocate(1024);
        //实例化输入流和输出流
        input1=new FileInputStream(file1);
        output1=new FileOutputStream(file);
        input2=new FileInputStream(file2);
        output2=new FileOutputStream(file);
        //为输入流和输出流绑定管道(实例化管道)
        inChannel1=input1.getChannel();
        outChannel1=output1.getChannel();
        inChannel2=input2.getChannel();
        outChannel2=output2.getChannel();

        //把数据放到缓冲区
        int num1=0;
        while ((num1=inChannel1.read(buffer1))!=-1){
            //每读取一次就把内容写到内存一次
            buffer1.flip();

            //把内存中的东西放到缓冲区
            outChannel1.write(buffer1);
            //清空缓冲区
            buffer1.clear();
        }
        int num2=0;
        while ((num2=inChannel2.read(buffer2))!=-1){
            //每读取一次就把内容写到内存一次
            buffer2.flip();
            //把内存中的东西放到缓冲区
            outChannel2.write(buffer2);
            //清空缓冲区
            buffer2.clear();
        }
        outChannel1.close();
        inChannel1.close();
        outChannel2.close();
        inChannel2.close();
        output2.close();
        input2.close();
        output1.close();
        input1.close();

    }
}
