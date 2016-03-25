/**
 * Created by Lx on 2016/3/21.
 */

/*
* 题目描述

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。
* */
public class ReConstructBinaryTree {
     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static class Solution {
        /*
        * 思想：找到先序遍历的第一个数，在中序遍历中找该点的下标，该点左边的所有数为其左子树中的点，该点右边的点为其右子树中的点，
        * 并在先序遍历数组中找到对应的左子树先序遍历的子数组和右子树的子数组并递归的进行求解
        * */
        public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
            if(pre.length == 0){
                return null;
            }

            TreeNode root = new TreeNode(pre[0]);
            if(pre.length == 1){
                return root;
            }

            int index = 0;//pre[0]在中序遍历数组中对应的点的下标
            for(int i = 0;i < in.length;i++){
                if(pre[0] == in[i]){
                    index = i;
                    break;
                }
            }
            int[] leftPre = new int[index];
            int[] leftIn = new int[index];
            int[] rightPre = new int[in.length - index - 1];
            int[] rightIn = new int[in.length - index - 1];
            for(int i = 0;i < leftPre.length;i++){
                leftIn[i] = in[i];
                leftPre[i] = pre[i + 1];
            }

            for(int i = 0;i < rightPre.length;i++){
                rightIn[i] = in[index + 1 + i];
                rightPre[i] = pre[index + 1 + i];
            }

            root.left = reConstructBinaryTree(leftPre,leftIn);
            root.right = reConstructBinaryTree(rightPre,rightIn);

            return root;
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {3,2,4,1,6,5,7};
        ReConstructBinaryTree.Solution.reConstructBinaryTree(a,b);
    }
}
