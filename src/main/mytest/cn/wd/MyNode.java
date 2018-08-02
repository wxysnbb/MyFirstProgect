package cn.wd;

public class MyNode {

    private int data;//元素ABC的值
    private MyNode next;//下一个元素

    public MyNode(int d) {
        this.data=d;//把过户传递过来的值 给我们节点的元素
    }
    //用户传递来的下一个节点
    private void append(MyNode myNode){
        MyNode node=this;

        while (node.next!=null){
            System.out.println(node.data);
            System.out.println(node.next);
            node=node.next;
        }
        node.next=myNode;//把传递过来的对象作为当前节点的下一个
    }

    //需要增加的节点
    private void add(MyNode myNode){
        myNode.next=next;//把当前的null 给了传递过来的节点的next属性
        next=myNode;
    }
    //显示链表中所有的节点
    private void show(){
        MyNode node=this;
        while (node!=null){
            System.out.println(node.data);
            node=node.next;
        }
    }

    public static void main(String[] args) {
        //创建我们自己的链表
        MyNode node=new MyNode(10);
        node.append(new MyNode(30));
        node.add(new MyNode(20));
        node.show();
    }

}
