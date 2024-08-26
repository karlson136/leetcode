/*
 * Copyright
 * Andrei Razhkou
 */

package tree;

/*
    You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.

        For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

    For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

    The test cases are generated so that the answer fits in a 32-bits integer.
 */
public class SumOfRootToLeafBinaryNumbers_1022 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(0,
                        new TreeNode(0, null, null),
                        new TreeNode(1, null, null)),
                new TreeNode(1,
                        new TreeNode(0, null, null),
                        new TreeNode(1, null, null)));
        
        System.out.println(sumRootToLeaf(root));
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        41.41MB
        Beats 94.46% of users with Java
     */
    public static int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum*2 + node.val;
        if (node.left == null && node.right == null ) {
            return sum;
        }
        return helper(node.left, sum) + helper(node.right, sum);
    }
}