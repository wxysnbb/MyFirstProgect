package cn.wd;


import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Demo01 {

    @Test
    public void test01() {
        try {
            System.out.println(Class.forName("cn.wd.Student"));
            System.out.println(Student.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test02() {
        try {
            Class myMain = Class.forName("cn.wd.Student");
            System.out.println("包名" + myMain.getPackage().getName());
            System.out.println("全类名"+myMain.getName());
            System.out.println("简写类名"+myMain.getSimpleName());
            Field[] declaredFields = myMain.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println("访问修饰符对应的数字" + declaredFields[i].getModifiers());

                System.out.println("访问修饰符值" + Modifier.toString(declaredFields[i].getModifiers()));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test03() {
        try {
            //加载
            Class calzz = Class.forName("cn.wd.Student");
            //获取所有字段
            Field[] declaredFields = calzz.getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println(declaredFields[i]);
            }
            //获取所有字段的访问修饰符
            for (int i = 0; i < declaredFields.length; i++) {
                System.out.println(Modifier.toString(declaredFields[i].getModifiers()));
                System.out.println(declaredFields[i].getModifiers());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void test04() {
        try {
            //加载
            Class calzz = Class.forName("cn.wd.Student");
            Method[] declaredMethods = calzz.getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                System.out.println("方法的名字是" + declaredMethods[i].getName());
                System.out.println("方法的修饰符值是" + declaredMethods[i].getModifiers());
                System.out.println("方法的修饰符是" + Modifier.toString(declaredMethods[i].getModifiers()));
                System.out.println("方法的返回值类类型是" + declaredMethods[i].getReturnType());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test05() {

        try {
            Class calzz = Class.forName("cn.wd.Student");
            Constructor[] declaredConstructors = calzz.getDeclaredConstructors();
            for (int i = 0; i <declaredConstructors.length; i++) {

                System.out.println("构造方法的名字"+declaredConstructors[i].getName());
                System.out.println("构造方法修饰符值是"+declaredConstructors[i].getModifiers());
                System.out.println("构造方法修饰符是"+Modifier.toString(declaredConstructors[i].getModifiers()));

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public  void  test06(){
        try {
            Class c=Class.forName("cn.wd.Student");
            Student student=(Student) c.newInstance();
            Field file=c.getDeclaredField("userName");
            String name=file.getName();
            System.out.println("字段的名称是："+name);
            //打开字段开关
            file.setAccessible(true);
            System.out.println("字段值是："+file.get(student));
            //获取私有方法
            Method method=c.getDeclaredMethod("getSum",double.class);
            method.setAccessible(true);//谨慎使用
            double result=(Double) method.invoke(student,50.5);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
