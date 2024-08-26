/*
 * Copyright
 * Andrei Razhkou
 */

package tree;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
    Return the smallest level x such that the sum of all the values of nodes at level x is maximal.


    Example 1:

    Input: root = [1,7,0,7,-8,null,null]
    Output: 2
    Explanation:
    Level 1 sum = 1.
    Level 2 sum = 7 + 0 = 7.
    Level 3 sum = 7 + -8 = -1.
    So we return the level with the maximum sum which is level 2.

    Example 2:

    Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
    Output: 2

 */
public class MaximumLevelSumOfABinaryTree_1161 {

    public static void main(String[] args) {
        maxLevelSum(null);
    }

    /*
        Runtime
        8ms
        Beats 90.86% of users with Java

        Memory
        47.51MB
        Beats 29.09% of users with Java
     */
    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int minLevel = -1;
        int maxSum = Integer.MIN_VALUE;

        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int currentLevelNodeCount = queue.size();

            currentLevel++;
            int currentSum = 0;
            for (int i = 0; i< currentLevelNodeCount; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
                minLevel = currentLevel;
            }
        }

        return minLevel;
    }
}