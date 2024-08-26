/*
 * Copyright
 * Andrei Razhkou
 */

/*
    Given an array of integers nums, calculate the pivot index of this array.

    The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

    If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

    Return the leftmost pivot index. If no such index exists, return -1.



    Example 1:

    Input: nums = [1,7,3,6,5,6]
    Output: 3
    Explanation:
    The pivot index is 3.
    Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
    Right sum = nums[4] + nums[5] = 5 + 6 = 11

    Example 2:

    Input: nums = [1,2,3]
    Output: -1
    Explanation:
    There is no index that satisfies the conditions in the problem statement.

    Example 3:

    Input: nums = [2,1,-1]
    Output: 0
    Explanation:
    The pivot index is 0.
    Left sum = 0 (no elements to the left of index 0)
    Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */
public class FindPivotIndex_724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex(new int[]{2,1,-1}));
        System.out.println(pivotIndex(new int[]{1,2,3}));
        System.out.println(pivotIndex(new int[]{-1,-1,0,1,1,0}));
    }

    /*
        Runtime
        1ms
        Beats 97.51% of users with Java

        Memory
        46.12MB
        Beats 7.42% of users with Java
     */
    public static int pivotIndex(int[] nums) {
        int[] prefixSumLeft = new int[nums.length + 1];
        int[] prefixSumRight = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSumLeft[i + 1] = prefixSumLeft[i] + nums[i];
            prefixSumRight[i + 1] = prefixSumRight[i] + nums[nums.length - i - 1];
        }

        for(int i = 0; i < prefixSumLeft.length; i++) {
            if (prefixSumRight.length - i - 2 >= 0 && prefixSumLeft[i] == prefixSumRight[prefixSumRight.length - i - 2]) {
                return i;
            }
        }
        return -1;
    }
}