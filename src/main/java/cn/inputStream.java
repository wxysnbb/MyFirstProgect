package cn;

import java.io.*;
import java.util.Scanner;

public class inputStream {

    static InputStream inputStream=null;
    static OutputStream outputStream=null;
    static ObjectInputStream objectInputStream=null;
    static ObjectOutputStream objectOutputStream=null;
    static Scanner input=new Scanner(System.in);

    public static void main(String[]args) throws Exception {
        //注册
        regiest();
        //登录
        login();
    }
    //登录
    private static void login() throws Exception {
        inputStream=new FileInputStream("d:/wxy.txt");
        objectInputStream=new ObjectInputStream(inputStream);
        User user=(User)objectInputStream.readObject();
        System.out.println(user);
        objectInputStream.close();
        inputStream.close();
    }
    //注册
    private static void regiest()  throws Exception{
        User user=new User();
        System.out.println("请输入账号：");
        user.setUserName(input.next());
        System.out.println("请输入密码：");
        user.setPassWord(input.next());

        outputStream=new FileOutputStream("d:/wxys.txt");
        objectOutputStream=new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();
        outputStream.close();
    }

}
