/*
 * Copyright
 * Andrei Razhkou
 */

package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    You are given a 0-indexed array of integers nums.

    A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1.
    In particular, the prefix consisting only of nums[0] is sequential.

    Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.



    Example 1:

    Input: nums = [1,2,3,2,5]
    Output: 6
    Explanation: The longest sequential prefix of nums is [1,2,3] with a sum of 6. 6 is not in the array,
    therefore 6 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.

    Example 2:

    Input: nums = [3,4,5,1,12,14,13]
    Output: 15
    Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12.
    12, 13, and 14 belong to the array while 15 does not.
    Therefore 15 is the smallest missing integer greater than or equal to the sum of the longest sequential prefix.


 */
public class SmallestMissingIntegerGreaterThanSequentialPrefixSum_2996 {

    public static void main(String[] args) {
        System.out.println(missingInteger(new int[]{1,2,3,2,5}));
        System.out.println(missingInteger(new int[]{3,4,5,1,12,14,13}));
        System.out.println(missingInteger(new int[]{46,8,2,4,1,4,10,2,4,10,2,5,7,3,1}));

    }

    public static int missingInteger(int[] nums) {
        if (nums.length == 1) {
            return nums[0] + 1;
        }

        int i;
        int sum = nums[0];
        for(i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                sum +=nums[i];
            } else {
                break;
            }
        }

        if (i == nums.length) {
            return sum;
        }

        Set<Integer> rest_nums = new HashSet<>(nums.length - i);
        for(; i < nums.length; i++) {
            rest_nums.add(nums[i]);
        }
        if (!rest_nums.contains(sum)) {
            return sum;
        } else {
            while(true) {
                sum++;
                if (!rest_nums.contains(sum)) {
                    return sum;
                }
            }
        }
    }
}