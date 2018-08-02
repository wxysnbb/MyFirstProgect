package cn.wd;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBuffer {
    public static void main(String[] args) throws IOException {
        //找到指定的文件并且设置读写模式
        RandomAccessFile file=new RandomAccessFile("d:/wxy.txt","rw");
        //创建管道
        FileChannel channel=file.getChannel();
        //创建内存映射
        java.nio.MappedByteBuffer buffer=channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
        //创建缓存区
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        //创建一个byte数组 便于我们后续获取数据
        byte []bytes=new byte[1024];
        //获取文件大小
        long length=file.length();
        //设置开始时间
        long beginTime=System.currentTimeMillis();
        for (int i=0;i<length;i+=1024){
            if(length-i>1024){
                buffer.get(bytes);
            }else{
                buffer.get(new byte[(int) (length-i)]);
            }
        }
        long endTime=System.currentTimeMillis();//设置开始时间
        System.out.println("使用内存时间："+(endTime-beginTime));
        System.out.println("**************************************");
        beginTime=System.currentTimeMillis();
        while(channel.read(byteBuffer)>0){
            byteBuffer.flip();//设置缓冲区
            byteBuffer.clear();//清空缓存区
        }
        endTime=System.currentTimeMillis();//获取结束时间
        System.out.println("使用普通io的时间"+(endTime-beginTime));
    }
}
