/**
 * Created by Lx on 2016/3/23.
 */

/*
*
* 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。*/
public class VerifySquenceOfBST {
    public static class Solution {
        /*
        * BST的后序序列的合法序列是，对于一个序列S，
        * 最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
        * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
        * 且这两段（子树）都是合法的后序序列。完美的递归定义 : ) 。
        * */
        public boolean VerifySquenceOfBST(int[] sequence) {
//            System.out.println("length:" + sequence.length);
//            for(int a : sequence){
//                System.out.print(a + "  ");
//            }
            System.out.print("\n");
            if (sequence.length == 0) {
                return false;
            }
            if (sequence.length == 1) {
                return true;
            }
            int root = sequence[sequence.length - 1];
            int[] leftSeq;
            int[] rightSeq;
            if (sequence[0] > root) {
                for (int i = 1; i < sequence.length - 1; i++) {
                    if (sequence[i] < root) {
                        return false;
                    }
                }
                leftSeq = new int[1];
                rightSeq = new int[sequence.length - 1];
                for (int i = 0; i < rightSeq.length; i++) {
                    rightSeq[i] = sequence[i];
                }
            } else if (sequence[sequence.length - 2] < root) {
                for (int i = sequence.length - 2; i >= 0; i--) {
                    if (sequence[i] > root) {
                        return false;
                    }
                }
                rightSeq = new int[1];
                leftSeq = new int[sequence.length - 1];
                for (int i = 0; i < leftSeq.length; i++) {
                    leftSeq[i] = sequence[i];
                }
            } else {
                int leftRoot = 0;
                for (int i = 0; i < sequence.length - 1; i++) {
                    if (sequence[i] > root) {
                        leftRoot = i - 1;
                        break;
                    }
                }
                for (int i = leftRoot + 1; i < sequence.length - 1; i++) {
                    if (sequence[i] < root) {
                        return false;
                    }
                }
                leftSeq = new int[leftRoot + 1];
                rightSeq = new int[sequence.length - leftRoot - 2];
                for (int i = 0; i < leftSeq.length; i++) {
                    leftSeq[i] = sequence[i];
                }

                for (int i = 0; i < rightSeq.length; i++) {
                    rightSeq[i] = sequence[leftRoot + 1 + i];
                }
//                System.out.println("left root:" + leftRoot);
            }

            return VerifySquenceOfBST(leftSeq) && VerifySquenceOfBST(rightSeq);
        }
    }

    public static void main(String[] args){
        Solution solution = new VerifySquenceOfBST.Solution();
        System.out.println(solution.VerifySquenceOfBST(new int[]{4,6,7,5}));
    }
}
