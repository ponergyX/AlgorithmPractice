import java.util.Stack;

/**
 * Created by Lx on 2016/3/21.
 */
/*
* 题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5

*/
public class Mirror {
    public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
        this.val = val;
     }
    }

    public class Solution {
        /*
        *递归
        * 思想：先交换左右子树的位置，然后去递归左右子树
        *
        * */
//        public void Mirror(TreeNode root) {
//            if(root == null){
//                return;
//            }
//
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//            Mirror(root.left);
//            Mirror(root.right);
//        }

        /*
        * 非递归
        * 思想：从根节点开始交换左右子树位置，然后依次将左右子树根节点入站，每次从栈中弹出一个结点并交换左右子树位置
        * */
        public void Mirror(TreeNode root) {
            if(root == null){
                return;
            }

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()){
                TreeNode root1 = stack.pop();
                TreeNode temp = root1.left;
                root1.left = root1.right;
                root1.right = temp;
                if(root1.left != null){
                    stack.push(root1.left);
                }

                if(root1.right != null){
                    stack.push(root1.right);
                }
            }
        }
    }
}
