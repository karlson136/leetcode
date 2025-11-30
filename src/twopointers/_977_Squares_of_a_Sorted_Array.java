/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.Arrays;

/*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    Example 1:

    Input: nums = [-4,-1,0,3,10]
    Output: [0,1,9,16,100]
    Explanation: After squaring, the array becomes [16,1,0,9,100].
    After sorting, it becomes [0,1,9,16,100].

    Example 2:

    Input: nums = [-7,-3,2,3,11]
    Output: [4,9,9,49,121]

    Constraints:

        1 <= nums.length <= 104
        -104 <= nums[i] <= 104
        nums is sorted in non-decreasing order.


    Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
 */
public class _977_Squares_of_a_Sorted_Array {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    /*
    Runtime
    1ms
    Beats100.00%

    Memory
    47.23MB
    Beats55.53%
     */
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int left2 = nums[left] * nums[left];
            int right2 = nums[right] * nums[right];

            if (left2 > right2) {
                res[index] = left2;
                left++;
            } else {
                res[index] = right2;
                right--;
            }
            index--;
        }

        return res;
    }
}