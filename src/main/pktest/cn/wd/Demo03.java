package cn.wd;

import java.util.Arrays;

public class Demo03 {
    public static void main(String[] args) {

        int[] num=new int[]{1,7,2,3,8,9,5};
        int[] num2=new int[num.length];
        Arrays.sort(num);
        for (int i = num.length-1,j=0; i >=0 ; i--,j++) {
            num2[j]=num[i];
        }
        System.out.println(num2[1]);
    }
}
