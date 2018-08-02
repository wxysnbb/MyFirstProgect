package cn.wd;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class channelBuffer {
    //安全的复制粘贴方法
    public static void main(String[]args) throws IOException {
        //创建复制和复制到的文件地址
        File filea=new File("d:/wxy.txt");
        File fileb=new File("d:/wxys.txt");
        //创建输入流和输出流
        FileInputStream input=null;
        FileOutputStream output=null;
        //创建输入流和输出流管道
        FileChannel inChannel=null;
        FileChannel outChannel=null;
        //创建缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //实例化输入流和输出流
        input=new FileInputStream(filea);
        output=new FileOutputStream(fileb);

        //为输入流和输出流绑定管道(实例化管道)
        inChannel=input.getChannel();
        outChannel=output.getChannel();

        //把数据放到缓冲区
        int num=0;
        while ((num=inChannel.read(buffer))!=-1){
            //每读取一次就把内容写到内存一次
            buffer.flip();
            //把内存中的东西放到缓冲区
            outChannel.write(buffer);
            //清空缓冲区
            buffer.clear();
        }
        outChannel.close();
        inChannel.close();
        output.close();
        input.close();

    }
}
