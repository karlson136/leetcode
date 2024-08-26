/*
 * Copyright
 * Andrei Razhkou
 */

package binarysearch;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 3)); // 2
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 6)); // -1
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 4)); // 3
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 7)); // -1
        System.out.println();

        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 1)); // 0
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 1)); // 0
        System.out.println(search(new int[]{1, 2, 3, 4, 5}, 5)); // 4
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6}, 6)); // 5
        System.out.println();

        System.out.println(search(new int[]{1}, 1)); // 0
        System.out.println(search(new int[]{1}, 2)); // -1
        System.out.println();

        System.out.println(search(new int[]{1, 2}, 2)); // 1
        System.out.println(search(new int[]{1, 2}, 3)); // -1
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0: -1;
        }

        int left = 0;
        int right = nums.length - 1;
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

        return -1;
    }
}