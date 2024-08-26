/*
 * Copyright
 * Andrei Razhkou
 */

package prefixsum;

/*
    Given an array of integers nums, you start with an initial positive value startValue.

    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

    Return the minimum positive value of startValue such that the step by step sum is never less than 1.



    Example 1:

    Input: nums = [-3,2,-3,4,2]
    Output: 5
    Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
    step by step sum
    startValue = 4 | startValue = 5 | nums
      (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
      (1 +2 ) = 3  | (2 +2 ) = 4    |   2
      (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
      (0 +4 ) = 4  | (1 +4 ) = 5    |   4
      (4 +2 ) = 6  | (5 +2 ) = 7    |   2

    Example 2:

    Input: nums = [1,2]
    Output: 1
    Explanation: Minimum start value should be positive.

    Example 3:

    Input: nums = [1,-2,-3]
    Output: 5

 */
public class MinimumValueToGetPositiveStepByStepSum_1413 {

    public static void main(String[] args) {
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println(minStartValue(new int[]{1,2}));
        System.out.println(minStartValue(new int[]{1,-2,-3}));
    }

    /*
        Runtime
        0ms
        Beats100.00%of users with Java

        Memory
        40.66MB
        Beats 88.27% of users with Java
     */
    public static int minStartValue(int[] nums) {
        int[] prefixSums = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefixSums[i+1] = prefixSums[i] + nums[i];
        }

        int min = prefixSums[0];
        for (int prefixSum: prefixSums) {
            min = Math.min(min, prefixSum);
        }

        return 1 - min;
    }
}