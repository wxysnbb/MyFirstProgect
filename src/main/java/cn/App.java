package cn;

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

public class App {

    static Document document=null;
    static Element rootNode=null;
    static Scanner input=new Scanner(System.in);


    public static void main(String[]args){
        String yn=null;
        System.out.println("*************欢迎您操作节点,请您选择您要操作的节点：***********");
        do{
            System.out.println("*************1.查看所有***********");
            System.out.println("*************2.增加***********");
            System.out.println("*************3.修改***********");
            System.out.println("*************4.删除***********");
            getElement();
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    getAll();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delet();
                    break;
            }
            System.out.println("请问还要继续吗？y/n");
            yn=input.next();
            if(yn.equals("y")){
                continue;
            }else {
                break;
            }
        }while(yn.equals("y"));
    }
    //获取xml文件
    private static void getElement() {
        SAXReader reader=new SAXReader();//创建解析器
        try {
            document=reader.read("src/resources/bookStore.xml");//读取xml文件
            rootNode=document.getRootElement();//获取根节点
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    //获取xml文档
    private static void asdf() {
       SAXReader reader=new SAXReader();
        try {
            document=reader.read("");
            rootNode=document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
    //把内存中的保存到xml文档中
    private static void saveXml() {
        //创建出输出流对象
        XMLWriter writer=null;
        //设置各式(格式化)
        OutputFormat format=null;
        format=OutputFormat.createPrettyPrint();
        try {
            writer=new XMLWriter(new FileWriter("src/resources/bookStore.xml"),format);
            writer.write(document);//真正的写入
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //把内存中的保存到xml文档中
    private static void wer() throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();//格式化文档
        XMLWriter writer=new XMLWriter(new FileWriter(""),format);//创建解析对象
        writer.write(document);//真正的写入
        writer.close();
    }
    //查看全部
    private static void getAll() {
        //遍历整个dom
        Iterator<Element> books = rootNode.elementIterator();
        //遍历
        while(books.hasNext()){
            Element book = books.next();//获取单个节点
            System.out.println("图书编号是："+book.attributeValue("id"));
            //通过图书编号获取图书名称
            Iterator<Element> bookName = book.elementIterator();
            //遍历图书信息
            while(bookName.hasNext()){
                Element bookz = bookName.next();
                System.out.println("图书id------>"+bookz.attributeValue("id"));
                System.out.println("图书型号------>"+bookz.attributeValue("name"));
                if(!bookz.getTextTrim().equals("")){
                    System.out.println("图书名称是:"+bookz.getTextTrim());
                }
            }
        }
    }
    //查看全部
    private static void zzz() {
        Iterator<Element> book=rootNode.elementIterator();//用迭代器来遍历根节点下的所有元素
        while(book.hasNext()){
            Element books = book.next();//获取单个节点
            System.out.println("图书编号信息"+books.attributeValue("id"));//输出节点的属性值
            Iterator<Element> bookz = books.elementIterator();
            while(bookz.hasNext()){
                Element bookv = bookz.next();
                System.out.println(""+bookv.attributeValue("id"));
                System.out.println(""+bookv.attributeValue("name"));
                if(!bookv.equals("")){
                    System.out.println(bookv.getTextTrim());
                }
            }
        }
    }
    private static void delet() {
        //遍历整个dom 找到需要删除的节点
        Iterator<Element> books = rootNode.elementIterator();
        System.out.println("请输入要删除的bookId");
        String id=input.next();
        while(books.hasNext()){
            Element bookName = books.next();
            if(bookName.attributeValue("id").equals(id)){
                rootNode.remove(bookName);
            }
        }
        saveXml();
        getAll();
    }
    //修改
    private static void update() {
        //遍历整个dom 找到需要修改的节点
        Iterator<Element> books = rootNode.elementIterator();
        System.out.println("请输入要修改的图书id：");
        String id=input.next();
        System.out.println("请输入修改后的id：");
        String ids=input.next();
        while(books.hasNext()){
            Element bookName = books.next();
            if(bookName.attributeValue("id").equals(id)){
                bookName.setAttributeValue("id",ids);
            }
        }
        saveXml();
        getAll();
    }


    private static void add() {
        System.out.println("请输入bookId的id：");
        String bid=input.next();

        Element bookId=rootNode.addElement("bookId");//先从book根节点创建子节点
        bookId.addAttribute("id",bid);

        System.out.println("请输入bookName的id：");
        String id=input.next();
        System.out.println("请输入bookName的name：");
        String name=input.next();
        System.out.println("请输入bookName的值：");
        String values=input.next();

        Element bookName=bookId.addElement("bookName");//创建子节点下的子节点
        bookName.addAttribute("id",id);
        bookName.addAttribute("name",name);
        bookName.addText(values);
        saveXml();
        getAll();
    }
    private static void ghf() {
        Element bookId = rootNode.addElement("bookId");
        bookId.addAttribute("id","hy");
        Element bookName = bookId.addElement("bookName");
        bookName.addAttribute("id","name");
        bookName.addAttribute("name","ll");
    }
    }
