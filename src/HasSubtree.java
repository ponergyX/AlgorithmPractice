/**
 * Created by Lx on 2016/3/21.
 */

/*
* 题目描述

输入两颗二叉树A，B，判断B是不是A的子结构。
* */
public class HasSubtree {
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
        * 思想：isSubtree方法使用来判断这个b是不是a的子数，hasSubTree从根节点开始调用issubtree方法，若返回为false说明以该节点
        * 为根节点的树不与b树的结构相同，所以去递归左子树和右子树
        * */
        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            if(root1 == null || root2 == null){
                return false;
            }

            if(isSubtree(root1,root2)){
                return true;
            }else{
                return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
            }
        }

        public boolean isSubtree(TreeNode root1,TreeNode root2){
            if(root2 == null){
                return true;
            }

            if(root1 == null){
                return false;
            }

            if(root1.val == root2.val){
                return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
            }else{
                return false;
            }
        }
    }
}
