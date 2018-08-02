package cn.wd;

public class phone {
    public static void main(String[] args) {
        //存放的是电话号码包含的数字
        int [] nums={9,8,5,7,1,0,4,3};
        //电话号码出现的下标
        int [] index={4,2,3,2,7,5,6,0,0,0,1};
        // 求电话号码15753049998


        /*int [][]phone=new int[][]{9,8,5,7,1,0,4,3}{4,2,3,2,7,5,6,0,0,0,1};*/
        for (int j=0;j<index.length;j++){
            System.out.print(nums[index[j]]);
        }

    }
}
