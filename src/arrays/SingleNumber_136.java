/*
 * Copyright
 * Andrei Razhkou
 */

package arrays;

/*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber_136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumber(new int[]{0}));
    }

    /*
        Runtime
        1ms
        Beats 99.85% of users with Java

        Memory
        45.98MB
        Beats 58.75% of users with Java
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}