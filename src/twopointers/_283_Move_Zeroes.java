/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.Arrays;

/*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.

    Example 1:

    Input: nums = [0,1,0,3,12]
    Output: [1,3,12,0,0]

    Example 2:

    Input: nums = [0]
    Output: [0]

    Constraints:

        1 <= nums.length <= 104
        -231 <= nums[i] <= 231 - 1

    Follow up: Could you minimize the total number of operations done?
 */
public class _283_Move_Zeroes {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    Runtime
    2ms
    Beats 84.31%

    Memory
    47.76MB
    Beats 22.61%
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    /*
    Runtime
    2ms
    Beats 84.44%

    Memory
    47.97MB
    Beats 5.64%
     */
    public static void moveZeroes2(int[] nums) {
        int slow = 0;
        int fast = 0;

        int glass;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                glass = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = glass;
                slow++;
            }
            fast++;
        }
    }
}