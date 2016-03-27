/**
 * Created by Lx on 2016/3/27.
 */

/*
* 题目描述

输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
最长路径的长度为树的深度。
* */
public class TreeDepth {
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
        * 思想：利用递归的思想。
        * */
        public int TreeDepth(TreeNode root) {
            return treeDepth(root,0);
        }

        public int treeDepth(TreeNode root,int height){
            if(root == null){
                return height;
            }

            height++;
            int leftHeight = treeDepth(root.left,height);
            int rightHeight = treeDepth(root.right,height);
            return leftHeight > rightHeight? leftHeight:rightHeight;
        }
    }
}
