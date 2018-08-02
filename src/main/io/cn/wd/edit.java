package cn.wd;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class edit {
    static Scanner input=new Scanner(System.in);
    public static void main(String[]args) throws IOException {
        System.out.println("请在此编辑文件：");
        System.out.println("1.查询所有文件夹");
        System.out.println("2.创建文件");
        System.out.println("3.创建文件夹");
        System.out.println("4.删除文件夹");
        System.out.println("5.修改文件夹名称");
        int choose=input.nextInt();
        switch (choose){
            case 1:
                showFile();
                break;
            case 2:
                createFile();
                break;
            case 3:
                createMkdirs();
                break;
            case 4:
                deleteFile();
                break;
            case 5:
                updataFile();
                break;
        }


    }
    //创建文件夹
    private static void createMkdirs() {
        File file=new File("d:/wxy");
        if(file.mkdirs()){
            System.out.println("创建成功");
        }else{
            System.out.println("创建失败");
        }

    }

    //修改
    private static void updataFile() {
        File oldFile=new File("d:/wxy.txt");
        File newFile=new File("d:/wxys.txt");
        if(oldFile.renameTo(newFile)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }
    //删除
    private static void deleteFile() {
        File file=new File("d:/wxy.txt");
        if(file.exists()){
            if(file.delete()){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }else{
            System.out.println("该文件不存在");
        }

    }
    //创建文件
    private static void createFile() throws IOException {
        File file=new File("d:/wxy.txt");
        if(file.exists()){
            System.out.println("该文件已存在");
        }else{
            if(file.createNewFile()){
                System.out.println("创建成功");
            }else{
                System.out.println("创建失败");
            }
        }
    }
    //查看
    private static void showFile() {
        File file=new File("e:/Game");
        File[] files=file.listFiles();
        int dirNum=0,fileNum=0;
        for(File f:files){
            if(f.isDirectory()){
                dirNum++;
            }
            if(f.isFile()){
                fileNum++;
                System.out.println(f.getName());
            }
        }
        System.out.println("文件夹总数为"+dirNum);
        System.out.println("文件总数为"+fileNum);
    }
}
