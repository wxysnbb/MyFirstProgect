package cn;

import java.util.Scanner;

public class trycatch {

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个数：");
        int a= input.nextInt();
        System.out.println("请输入第二个数：");
        int b= input.nextInt();
        try {
            int c=a/b;

            System.out.println(c);
        }catch (ArithmeticException e){
            System.out.println("算数异常");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("顶级异常");
            e.printStackTrace();
        }


    }
}
