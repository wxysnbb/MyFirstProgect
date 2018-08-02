package cn.wd;


import java.io.*;

public class Demo02 {
    public static void main(String[] args) throws IOException {
        Reader reader=null;
        BufferedReader br=null;
        try {
            //读取
            reader=new FileReader("src/main/pktest/cn/wd/stu.txt");
            br=new BufferedReader(reader);//封装
            String line=null;
            StringBuffer sb=new StringBuffer();
            while ((line=br.readLine())!=null){
                sb.append(line);
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
