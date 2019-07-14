package com.monkeyc.binarytree.testBinaryTree;

import java.util.Stack;

/**
 * 链式二叉树
 */

public class TestBinaryTree {

    class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val){
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

    //二叉树的前序遍历
    void binaryTreePrevOrder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);
    }

    //二叉树的中序遍历
    void binaryTreeInOrder(TreeNode root) {
        if(root == null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val + " ");
        binaryTreeInOrder(root.right);

    }

    //二叉树的后序遍历
    void binaryTreePostOrder(TreeNode root){
        if(root == null){
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val +" ");
    }
    public int i = 0;

    //根据字符串创建二叉树    递归  先序遍历的方式解答
    TreeNode createTestTree(String s){

        TreeNode root = null;
        //1.如果对应字符不是#，那么创建一个节点

            if(s.charAt(i) != '#'){

                root = new TreeNode(s.charAt(i));
                i++;
                root.left = createTestTree(s);
                root.right = createTestTree(s);

            }else{
                //2.如果是#，直接下标++
                    i++;
            }

        return root;
    }

    //节点个数
    int getSize(TreeNode root){

        if(root == null){
            return 0;
        }
        return getSize(root.left) + getSize(root.right) + 1;
    }
    //叶子节点树
    int getLeafSize(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else{
            return getLeafSize(root.right) + getLeafSize(root.left);
        }
    }

    // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
       if(root == null){
           return 0;
       }
       if(k == 1){
           return 1;
       }else{
           return getKLevelSize(root.left,k-1) + getKLevelSize(root.right,k-1);
       }
    }

    // 查找，依次在二叉树的 根、左子树、右子树 中查找 value，如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, char value){
        if(root == null){
            return null;
        }
        if(value == root.val){
            return root;
        }
        TreeNode node = find(root.left,value);

        if(node == null){
            find(root.right,value);
        }
        return node;
    }
    //二叉树的高度
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int righhtHeight = height(root.right);
        return leftHeight > righhtHeight ? height(root.left) + 1 : height(root.right) + 1;
    }

    //二叉树的非递归先序遍历
    void binaryTreePrevOrderNonR(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            cur = top.right;

        }
    }
    //二叉树的非递归中序遍历
    void binaryTreeInOrderNonR(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            top = stack.pop();
            System.out.print(top.val+" ");
            cur = top.right;
        }

    }
    //
    void binaryTreePostOrderNonR(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode pre = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == pre){
                System.out.print(cur.val+ " ");
                stack.pop();
                pre = cur;//代表cur已经打印
                cur = null;
            }else{
                cur = cur.right;
            }

        }
    }
}
