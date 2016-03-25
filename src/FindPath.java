import java.util.ArrayList;

/**
 * Created by Lx on 2016/3/23.
 */

/*
* 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
* 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
* */
public class FindPath {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public class Solution {
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            if(root != null && target > 0){
                findPath(list,new ArrayList<Integer>(),root,target);
            }
            return list;
        }

        public void findPath(ArrayList<ArrayList<Integer>> list,ArrayList<Integer> subList,TreeNode root,int targetRemain){
            if(targetRemain - root.val == 0 && root.left == null && root.right == null){
                subList.add(root.val);
                list.add(subList);
            }else{
                if(root.left != null && targetRemain - root.val > 0){
                    ArrayList<Integer> subL = (ArrayList<Integer>) subList.clone();
                    subL.add(root.val);
                    findPath(list,subL,root.left,targetRemain - root.val);
                }

                if(root.right != null && targetRemain - root.val > 0){
                    ArrayList<Integer> subR = (ArrayList<Integer>) subList.clone();
                    subR.add(root.val);
                    findPath(list,subR,root.right,targetRemain - root.val);
                }
            }
        }
    }
}
