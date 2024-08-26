/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.



    Example 1:

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    Example 2:

    Input: height = [1,1]
    Output: 1
 */
public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
        System.out.println(maxArea(new int[]{1,1})); // 1
        System.out.println(maxArea(new int[]{5,8,7,1,1,1,1,1,5})); // 40
        System.out.println(maxArea(new int[]{1,2,4,3})); // 4
    }

    /*
        Runtime
        5ms
        Beats 71.30% of users with Java

        Memory
        57.18MB
        Beats 85.95% of users with Java
     */
    public static int maxArea(int[] height) {
        int V = 0;
        int left = 0;
        int right = height.length - 1;

        int currentV;
        while (left < right) {
            currentV = Math.min(height[left], height[right]) * (right - left);
            V = Math.max(V, currentV);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return V;
    }
}