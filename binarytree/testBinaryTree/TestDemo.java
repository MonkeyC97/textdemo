package com.monkeyc.binarytree.testBinaryTree;

import sun.misc.GThreadHelper;

public class TestDemo {
    public static void main(String[] args) {
        TestBinaryTree testBinaryTree = new TestBinaryTree();
        String str = "ABC##DE#G##F###";
        TestBinaryTree.TreeNode root = testBinaryTree.createTestTree(str);
        testBinaryTree.binaryTreePrevOrder(root);
        System.out.println(" ");
        System.out.println("--------------------------");
        testBinaryTree.binaryTreeInOrder(root);
        System.out.println(" ");
        System.out.println("--------------------------");
        testBinaryTree.binaryTreePostOrder(root);
        System.out.println(" ");
        System.out.println("--------------------------");
        System.out.println(testBinaryTree.getSize(root));
        System.out.println(" ");
        System.out.println("--------------------------");
        System.out.println(testBinaryTree.getLeafSize(root));
        System.out.println(testBinaryTree.getKLevelSize(root,1));
        if(testBinaryTree.find(root,'A') == null){
            System.out.println("null");
        }else{
            System.out.println(testBinaryTree.find(root,'A').val);
        }
        TestBinaryTree.TreeNode ret = testBinaryTree.find(root,'A');

        System.out.println(ret);
        System.out.println(testBinaryTree.height(root));

        System.out.println(" ");

        testBinaryTree.binaryTreeInOrderNonR(root);

        testBinaryTree.binaryTreePostOrderNonR(root);


    }
}
