/*
 * Copyright
 * Andrei Razhkou
 */

package prefixsum;

import java.util.HashMap;
import java.util.Map;

/*
    Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

    A subarray is a contiguous part of the array.



    Example 1:

    Input: nums = [1,0,1,0,1], goal = 2
    Output: 4
    Explanation: The 4 subarrays are bolded and underlined below:
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]
    [1,0,1,0,1]

    Example 2:

    Input: nums = [0,0,0,0,0], goal = 0
    Output: 15

    Constraints:

    1 <= nums.length <= 3 * 10^4
    nums[i] is either 0 or 1.
    0 <= goal <= nums.length

 */
public class BinarySubarraysWithSum_930 {

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }

    /*
        Runtime
        21ms
        Beats 52.82% of users with Java

        Memory
        49.31MB
        Beats 25.12% of users with Java
     */
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);

        int curSum = 0;
        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int sumToFind = curSum - goal;
            count += sums.getOrDefault(sumToFind,0);
            sums.put(curSum, sums.getOrDefault(curSum, 0) + 1);
        }

        return count;
    }
}