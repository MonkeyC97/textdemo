package com.monkeyc.binarytree.testBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
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
    //非递归后序遍历二叉树
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
    //二叉树的层序遍历
    void binaryTreeLevelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);//add 和 offer的区别
        }

        while(!queue.isEmpty()){

            TreeNode cur = queue.peek();
            System.out.print(cur.val + " ");
            queue.poll();

            if(cur.left != null){
                queue.offer(cur.left);
            }

            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }
    //判断一棵树是否是完全二叉树 返回0代表是完全二叉树
    int binaryTreeComplete(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        if(root != null){
            queue.offer(root);
        }

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();//A这个节点
            if(cur != null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll != null){
                return -1;
            }
        }
        return 0;
    }

    //检查两棵树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q == null){
            return false;
        }
        if(p == null && q != null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    /**
     *给定两个非空二叉树 s 和 t，
     * 检验 s 中是否包含和 t 具有相同结构和节点值的子树。
     * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。
     * s 也可以看做它自身的一棵子树
     */
    //前序遍历方式
    public static boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p != null && q == null){
            return false;
        }
        if(p == null && q != null){
            return false;
        }
        if(p == null && q == null){
            return true;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree1(p.left,q.left) && isSameTree1(p.right,q.right);
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        else{
            return isSubtree(s.left,t) || isSubtree(s.right,t);
        }
    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     *
     * 本题中，一棵高度平衡二叉树定义为：
     *
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     */
    //求一个树的最大深度
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight >  rightHeight ?
                leftHeight +1 :  rightHeight +1;
    }
    //判断是否为平衡树
    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        int a = Math.abs(leftHeight - rightHeight);
        if(a < 2 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }else{
            return false;
        }
    }
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if(leftTree== null && rightTree == null){
            return true;
        }
        if(leftTree == null && rightTree != null || leftTree != null && rightTree == null){
            return false;
        }
        return leftTree.val== rightTree.val
                &&isSymmetricChild(leftTree.left,rightTree.right)
                &&isSymmetricChild(leftTree.right,rightTree.left);

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);

    }

    public  void tree2strChild(TreeNode root,StringBuilder sb){
        if(root == null){
            return;
        }
        if(root != null){
            sb.append(root.val);
        }
        if(root.left != null){
            sb.append("(");
            tree2strChild(root.left,sb);
            sb.append(")");
        }
        if(root.left == null && root.right == null){
            return;
        }
        if(root.left == null && root.right != null){
            sb.append("()");
        }
        if(root.right == null){
            return;
        }
        if(root.right != null){
            sb.append("(");
            tree2strChild(root.right,sb);
            sb.append(")");
        }

    }
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2strChild(root,sb);
        return sb.toString();
    }
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
     * 最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     */
    //LCA   最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            return root;
        }
        if(left == null && right != null){
            return right;
        }
        if(right == null && left != null){
            return left;
        }
        return null;
    }

    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     *
     */
    TreeNode prev = null;
    public void ConvertChild(TreeNode pCur) {

        if(pCur == null){
            return;
        }
        ConvertChild(pCur.left);
        pCur.left = prev;
        if(prev != null)
            prev.right = pCur;
        prev = pCur;
        ConvertChild(pCur.right);
    }

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertChild(pRootOfTree);
        TreeNode head = pRootOfTree;
        while(head != null && head.left != null){
            head = head.left;
        }
        return head;
    }

}
