package tree;/*
  Copyright
  Andrei Razhkou
 */

public class SameTree_100 {
    public static void main(String[] args) {
        isSameTree(null, null);
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        40.87MB
        Beats 61.07% of users with Java
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || ((p != null && q == null))) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}