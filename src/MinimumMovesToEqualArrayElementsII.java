/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.Arrays;

/*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
    In one move, you can increment or decrement an element of the array by 1.
    Test cases are designed so that the answer will fit in a 32-bit integer.

    Example 1:
    Input: nums = [1,2,3]
    Output: 2
    Explanation:
    Only two moves are needed (remember each move increments or decrements one element):
    [1,2,3]  =>  [2,2,3]  =>  [2,2,2]

    Example 2:
    Input: nums = [1,10,2,9]
    Output: 16
 */
public class MinimumMovesToEqualArrayElementsII {

    public static void main(String[] args) {
        int[] data = new int[]{1,0,0,8,6};
//        int[] data = new int[]{1,2,3};
        System.out.println(minMoves(data));
    }

    /*
        Runtime
        6ms
        Beats 78.10% of users with Java
        Memory
        44.38MB
        Beats 75.81% of users with Java
     */
    public static int minMoves(int[] nums) {
        int moves = 0;

        Arrays.sort(nums);
        int median;
        int length = nums.length;
        if (length % 2 == 0) {
            median = (nums[(length -1)/2] + nums[length /2]) / 2;
        } else {
            median = nums[length /2];
        }

        for(int i: nums) {
            moves += Math.abs(median - i);
        }

        return moves;
    }
}