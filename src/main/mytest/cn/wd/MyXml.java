package cn.wd;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class MyXml {

    static Document document=null;
    static Element rootNode=null;
    static Scanner input=new Scanner(System.in);
    static String flag=null;
    public static void main(String[] args) throws Exception {

        System.out.println("*************请操作节点***************");
        do {
            System.out.println("*************1.增加***************");
            System.out.println("*************2.删除***************");
            System.out.println("*************3.修改***************");
            System.out.println("*************4.查看***************");
            int choose=input.nextInt();
            reader();
            switch (choose){
                case 1:
                    add();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    up();
                    break;
                case 4:
                    all();
                    break;
            }
            System.out.println("要继续吗？(y/n)");
            flag=input.next();
        }while (flag.equals("y"));

    }
    //读取器
    private static void reader() throws DocumentException {
        SAXReader reader=new SAXReader();
        document=reader.read("src/resources/grade.xml");
        rootNode=document.getRootElement();
    }
    //把XML操作过后写入xml
    private static void writeXML() throws IOException {
        OutputFormat format=OutputFormat.createPrettyPrint();
        XMLWriter writer=new XMLWriter(new FileWriter("src/resources/grade.xml"),format);
        writer.write(document);
        writer.close();
    }

    private static void all() {
        Iterator<Element> grade=rootNode.elementIterator();
        while (grade.hasNext()){
            Element gradeid=grade.next();
            System.out.println("年级id："+gradeid.attributeValue("name"));
            Iterator<Element> classes = gradeid.elementIterator();
            while (classes.hasNext()){
                Element classess=classes.next();
                System.out.println("班级id："+classess.attributeValue("id")+"***********文本值："+classess.getTextTrim());
            }
        }
    }

    private static void up() throws Exception {
        Iterator<Element>grade=rootNode.elementIterator();
        System.out.println("请输入要修改的班级name：");
        String clas=input.next();
        System.out.println("请输入要修改的学生名称：");
        String oldname=input.next();
        System.out.println("请输入新名称：");
        String newname=input.next();
        while (grade.hasNext()){
            Element gradeid=grade.next();
            if(gradeid.attributeValue("name").equals(clas)){
                Iterator<Element>student=gradeid.elementIterator();
                while (student.hasNext()){
                    Element stu=student.next();
                    if(stu.getTextTrim().equals(oldname)){
                        stu.setText(newname);
                    }
                }
            }
        }
        writeXML();
        all();
    }

    private static void del() throws Exception {
        Iterator<Element>grade=rootNode.elementIterator();
        System.out.println("请输入要删除的年级name");
        String id=input.next();
        while(grade.hasNext()){
            Element gradeid=grade.next();
            if(gradeid.attributeValue("name").equals(id)){
                rootNode.remove(gradeid);
            }
        }
        writeXML();
        all();
    }

    private static void add() throws Exception {
        System.out.println("请输入年级的name：");
        String bid=input.next();

        Element gradeId=rootNode.addElement("class");//先从年级根节点创建子节点
        gradeId.addAttribute("name",bid);

        System.out.println("请输入学生的id：");
        String id=input.next();
        System.out.println("请输入学生的值：");
        String values=input.next();

        Element stuName=gradeId.addElement("student");//创建子节点下的子节点
        stuName.addAttribute("id",id);
        stuName.addText(values);
        writeXML();
        all();
    }

}
