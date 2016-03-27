/**
 * Created by Lx on 2016/3/27.
 */

/*
* 题目描述

输入一棵二叉树，判断该二叉树是否是平衡二叉树。
* */
public class IsBalanced_Solution {
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
        * 思想：利用递归思想，获得根结点左右子树的高度，若左右子树高度差<=1则为平衡二叉树，否则不是平衡二叉树
        * */
        public boolean IsBalanced_Solution(TreeNode root) {
            if(root == null){
                return true;
            }

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            if(Math.abs(leftHeight - rightHeight) <= 1){
                return true;
            }
            return false;
        }

        public int getHeight(TreeNode root){
            if(root == null){
                return 0;
            }

            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);

            return leftHeight > rightHeight? leftHeight + 1:rightHeight + 1;
        }
    }
}
