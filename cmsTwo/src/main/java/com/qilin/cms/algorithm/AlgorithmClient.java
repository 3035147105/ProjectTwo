package com.qilin.cms.algorithm;

import com.qilin.cms.algorithm.BinaryTreeNodePac.BinaryTreeNode;
import com.qilin.cms.algorithm.BinaryTreeNodePac.BinaryTreeTest;
import com.qilin.cms.algorithm.MoneyTreeNodePac.MoneyTreeNode;
import com.qilin.cms.algorithm.MoneyTreeNodePac.MoneyTreeTest;

/**
 * Created by gaohaiqing on 17-1-12.
 *
 * 与算法相关的一些记录
 */
public class AlgorithmClient {

    public static void main(String[] args){
        AlgorithmClient alg = new AlgorithmClient();

        BinaryTreeTest treeTest = new BinaryTreeTest();
        BinaryTreeNode orign1 = treeTest.produceData1();//拿到一个二叉树对象
        BinaryTreeNode orign2 = treeTest.produceData2();//拿到一个二叉树对象
//        int nodeNum = treeTest.getNodeNum(orign);
//        int nodeDepth = treeTest.getDepth(orign);
//        System.out.print("--------前序遍历:");
//        treeTest.preVisit(orign);
//
//        System.out.println();
//        System.out.print("--------中序遍历:");
//        treeTest.middleVisit(orign);
//
//        System.out.println();
//        System.out.print("--------后序遍历:");
//        treeTest.postVisit(orign);

//        System.out.println();
//        System.out.print("--------分层遍历:");
//        treeTest.levelVisit(orign1);

        System.out.println();
        System.out.print("--------是否相同:");
//        boolean flag = treeTest.isSame(orign1, orign2);
//        System.out.println(flag);

//        System.out.println();
//        System.out.println("二叉树的节点个数："+ nodeNum);
//        System.out.println("二叉树的深度："+ nodeDepth);
//        BinaryTreeNode mirrorNode = treeTest.mirror(orign);
//        System.out.println();
//        System.out.println("------原二叉树镜像：");
//        treeTest.levelVisit(mirrorNode);

//        MoneyTreeTest moneyTreeTest = new MoneyTreeTest();
//        MoneyTreeNode moneyTreeOrign = moneyTreeTest.produceMoneyTreeData();
//        System.out.println();
//        System.out.println("------三叉树分层遍历：");
//        moneyTreeTest.levelMoneyTreeNode(moneyTreeOrign);
//        //三叉树镜像
//        MoneyTreeNode mirrorNode = moneyTreeTest.mirror(moneyTreeOrign);
//        System.out.println();
//        System.out.println("--------三叉树镜像：");
//        moneyTreeTest.levelMoneyTreeNode(mirrorNode);
    }

    /**
     * 简单的取一个数字的个、十、百位
     * @param number  正整数(三位)
     *                输出 百位数、十位数、个位数
     */
    public void hundred(int number){
        if(number>999 || number<100){
            System.out.println("请输入一个三位数");
            return;
        }
        int baiwei = number/100;
        int shiwei = number%100/10;
        int gewei = number%100%10;
        System.out.println("个位："+gewei+"十位："+shiwei+"百位："+baiwei);
    }

    public void suanfa1(){
        int result = 0;
        int i = 10000;
        while (i<100000){
            if((i%3==0) && (i%10==6)) {
                result += 1;
            }
            i+=1;
        }
        System.out.println("个位数为6,且能被3整除的5位整数共有" + result + "个");
    }

    /**
     * 1~100之间的所有质数
     */
    public void suanfa2(){
        for(int i=1; i<=100; i++){
            boolean a  = true;
            if(i != 1){
                for(int n=2;n<i;n++){
                    if(i%n == 0){
                        a = false;
                        break;
                    }
                }
            }
            if (a){
                System.out.println(i+"是质数");
            }
        }
    }

}
