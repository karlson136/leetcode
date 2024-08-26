/*
 * Copyright
 * Andrei Razhkou
 */

package binarysearch;

/*
    Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4

 */
public class SearchInsertPosition_35 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7)); // 4
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        43.05MB
        Beats 28.99% of users with Java
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] > target) {
            return 0;
        }
        if (nums[right] < target) {
            return right + 1;
        }
        while (left <= right) {
            int med = left + ((right - left) / 2);
            if (nums[med] == target) {
                return med;
            } else if (nums[med] < target) {
                left = med + 1;
            } else {
                right = med - 1;
            }
        }

        return left;
    }
}