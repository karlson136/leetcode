/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.Arrays;

/*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]

 */
public class SortColors_75 {

    public static void main(String[] args) {
        int[] testArr = new int[]{2,0,2,1,1,0};
        sortColors(testArr);
        System.out.println(Arrays.toString(testArr));

        testArr = new int[]{2,0,1};
        sortColors(testArr);
        System.out.println(Arrays.toString(testArr));

        testArr = new int[]{1,2,0};
        sortColors(testArr);
        System.out.println(Arrays.toString(testArr));
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        41.96MB
        Beats 23.91% of users with Java
     */
    public static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        for(int i = 0; i <= right;){
            if (nums[i] == 0) {
                swap(nums, i++, left++);
            } else if (nums[i] == 2) {
                swap(nums, i, right--);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        var thirdGlass = 0;
        thirdGlass = arr[i];
        arr[i] = arr[j];
        arr[j] = thirdGlass;
    }
}