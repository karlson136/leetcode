/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.HashSet;
import java.util.Set;

/*
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3}));
    }

    /*
        Runtime
        7ms
        Beats 98.63% of users with Java

        Memory
        60.37MB
        Beats 31.14% of users with Java
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> digits = new HashSet<>();
        for (int num: nums) {
            if (!digits.add(num)) {
                return true;
            }
        }
        return false;
    }
}