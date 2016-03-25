import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Lx on 2016/3/23.
 */

/*
* 题目描述

从上往下打印出二叉树的每个节点，同层节点从左至右打印。
* */
public class PrintFromTopToBottom {
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
        * 思想：使用队列，当队列不为空时取出队列的头结点，然后将其值存入输出结果数组，并将其左右子女结点依次加入队列
        * */
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            if(root != null){
                queue.addLast(root);
            }
            while (!queue.isEmpty()){
                TreeNode node = queue.getFirst();
                queue.removeFirst();
                result.add(node.val);
                if(node.left != null){
                    queue.addLast(node.left);
                }

                if(node.right != null){
                    queue.addLast(node.right);
                }
            }
            return result;
        }
    }
}
