/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.HashSet;
import java.util.Set;

/*
    You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
    Return the maximum score you can get by erasing exactly one subarray.
    An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

    Example 1:
    Input: nums = [4,2,4,5,6]
    Output: 17
    Explanation: The optimal subarray here is [2,4,5,6].

    Example 2:
    Input: nums = [5,2,1,2,5,2,1,2,5]
    Output: 8
    Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 */
public class MaximumErasureValue {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[] {5,2,1,2,5,2,1,2,5}));
    }

    /*
    Runtime
    53ms
    Beats 44.22% of users with Java

    Memory
    59.80MB
    Beats 38.56% of users with Java
     */
    public static int maxSum1(int[] nums) {
        int maxSum = 0;
        int tempSum = 0;
        Set<Integer> numSet = new HashSet<>();

        int right;
        int left = 0;
        for (right = 0; right < nums.length; right++) {
            if (!numSet.contains(nums[right])) {
                numSet.add(nums[right]);
                tempSum += nums[right];
                maxSum = Math.max(maxSum, tempSum);
            } else {
                while (numSet.contains(nums[right])) {
                    numSet.remove(nums[left]);
                    tempSum -=nums[left];
                    left++;
                }
                numSet.add(nums[right]);
                tempSum += nums[right];
                maxSum = Math.max(maxSum, tempSum);
            }
        }

        return maxSum;
    }

    /*
    Runtime
    53ms
    Beats 44.22% of users with Java

    Memory
    59.80MB
    Beats 38.56% of users with Java
     */
    public static int maxSum(int[] nums) {
        int maxSum = 0;
        int tempSum = 0;
        Set<Integer> numSet = new HashSet<>();

        int right;
        int left = 0;
        for (right = 0; right < nums.length; right++) {
            if (numSet.contains(nums[right])) {
                while (numSet.contains(nums[right])) {
                    numSet.remove(nums[left]);
                    tempSum -=nums[left];
                    left++;
                }
            }
            numSet.add(nums[right]);
            tempSum += nums[right];
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }
}