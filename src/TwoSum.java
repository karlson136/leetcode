/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(ints));
    }

    // first try
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i ,j};
                }
            }
        }
        return new int[] {-1, -1};
    }

    //second try
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>(nums.length -1);
        visited.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int key = target - nums[i];
            if (visited.containsKey(key)) {
                return new int[] {visited.get(key) ,i};
            } else {
                visited.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}