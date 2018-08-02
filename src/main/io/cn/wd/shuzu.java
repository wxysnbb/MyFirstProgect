package cn.wd;

public class shuzu {
    public static void main(String[] args) {
        int [][] grade=new int[2][3];
        grade[0][0]=5;
        grade[0][1]=5;
        grade[0][2]=5;

        grade[1][0]=4;
        grade[1][1]=4;
        grade[1][2]=4;



        for (int i=0;i<grade.length;i++){
            for (int j=0;j<grade[i].length;j++){
                System.out.println(grade[i][j]);
            }

        }
    }



}
