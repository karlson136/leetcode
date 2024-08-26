/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.*;

/*
    given arrays of nums. and k -- window size (count of element). It needs to find max element for every window

    example:
    [1, 7, 5, 0, 4, 2]
    answer
    [7, 7, 5, 4]

    explanation:
    [1, 7, 5] -> 7
    [7, 5, 0] -> 7
    [5, 0, 4] -> 5
    [0, 4, 2] -> 4

 */
public class FindMaxInWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxInSums(new int[]{1, 7, 5, 0, 4, 2}, 4)));
    }

    public static int[] findMaxInSums(int[] nums, int k) {
        if (nums.length < k) {
            return new int[0];
        }

        int[] res = new int[nums.length - k + 1];

        LinkedList<Integer> list = new LinkedList<>();

        int i;
        for(i = 0; i < k; i++) {
            list.add(nums[i]);
        }

        int j = 0;
        res[j] = list.stream().max(Comparator.comparingInt(a -> a)).get();

        for(; i < nums.length; i++) {
            list.pop();
            list.add(nums[i]);
            j++;
            res[j] = list.stream().max(Comparator.comparingInt(a -> a)).get();
        }

        return res;
    }
}