/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.Arrays;

/*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
    In one move, you can increment n - 1 elements of the array by 1.

    Example 1:
    Input: nums = [1,2,3]
    Output: 3
    Explanation: Only three moves are needed (remember each move increments two elements):
    [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

    Example 2:
    Input: nums = [1,1,1]
    Output: 0

 */
public class MinimumMovesToEqualArrayElements {

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4};
        System.out.println(minMoves(data));
    }

    /*
        Runtime
        12ms
        Beats 27.45% of users with Java

        45.64MB
        Beats 55.25% of users with Java
     */
    public static int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int sum = 0;
        for (int i: nums) {
            sum +=i;
        }
        int moves = sum - min * nums.length;

        return moves;
    }
}