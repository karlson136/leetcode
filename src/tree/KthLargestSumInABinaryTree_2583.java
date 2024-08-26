/*
 * Copyright
 * Andrei Razhkou
 */

package tree;

import java.util.*;

/*
    You are given the root of a binary tree and a positive integer k.

    The level sum in the tree is the sum of the values of the nodes that are on the same level.

    Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

    Note that two nodes are on the same level if they have the same distance from the root.

    Example 1:

    Input: root = [5,8,9,2,1,3,7,4,6], k = 2
    Output: 13
    Explanation: The level sums are the following:
    - Level 1: 5.
    - Level 2: 8 + 9 = 17.
    - Level 3: 2 + 1 + 3 + 7 = 13.
    - Level 4: 4 + 6 = 10.
    The 2nd largest level sum is 13.

    Example 2:

    Input: root = [1,2,null,3], k = 1
    Output: 3
    Explanation: The largest level sum is 3.

 */
public class KthLargestSumInABinaryTree_2583 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3, null, null),
                        null),
                null);

        kthLargestLevelSum(root, 2);
    }

    /*
        Runtime
        37ms
        Beats 52.92% of users with Java

        Memory
        62.16MB
        Beats 90.38% of users with Java
     */
    public static long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        List<Long> sums = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentLevelNodeCount = queue.size();

            long currentSum = 0;
            for (int i = 0; i < currentLevelNodeCount; i++) {
                TreeNode node = queue.poll();
                currentSum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            sums.add(currentSum);
        }

        if (sums.size() < k) {
            return -1;
        }

        Collections.sort(sums);
        return sums.get(sums.size() - k);
    }
}