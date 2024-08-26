/*
 * Copyright
 * Andrei Razhkou
 */

package arrays;

import java.util.HashMap;
import java.util.Map;

/*
    Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

    You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumberII_137 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
    }

    /*
        Runtime
        5ms
        Beats 43.22% of users with Java

        Memory
        45.59MB
        Beats 30.66% of users with Java
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int num: nums) {
            int value = res.getOrDefault(num, 0) + 1;
            if (value == 3) {
                res.remove(num);
            } else {
                res.put(num, value);
            }
        }

        return res.entrySet().iterator().next().getKey();
    }
}