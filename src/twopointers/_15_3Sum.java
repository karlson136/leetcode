/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.*;

/*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
    and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

    Example 2:

    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

    Example 3:

    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.

    Constraints:

        3 <= nums.length <= 3000
        -105 <= nums[i] <= 105
 */
public class _15_3Sum {

    public static void main(String[] args) {
        System.out.println(threeSum4(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum4(new int[]{0, 1, 1}));
        System.out.println(threeSum4(new int[]{0, 0, 0}));
        System.out.println(threeSum4(new int[]{-100, -70, -60, 110, 120, 130, 160}));
        System.out.println(threeSum4(new int[]{-2, 0, 1, 1, 2}));
    }

    /*
        Runtime
        926ms
        Beats 6.96%

        Memory
        59.80MB
        Beats 11.28%
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int start = 0;
        while (start < nums.length - 2) {
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[start], nums[left], nums[right]));
                    left++;
                }
            }
            start++;
        }

        return new ArrayList<>(result);
    }

    /*
        Runtime
        36ms
        Beats 29.26%

        Memory
        59.11MB
        Beats 27.26%
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int start = 0;

        while (start < nums.length - 2) {
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[start], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            start++;
            while (start < nums.length - 2 && nums[start] == nums[start - 1]) {
                start++;
            }
        }

        return new ArrayList<>(result);
    }

    /*
        Runtime
        31ms
        Beats 66.20%

        Memory
        59.24MB
        Beats 20.36%
     */
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int start = 0;

        while (start < nums.length - 2) {
            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[start], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
            start++;
            while (start < nums.length - 2 && nums[start] == nums[start - 1]) {
                start++;
            }
        }

        return result;
    }

    /*
        Runtime
        31ms
        Beats 66.20%

        Memory
        58.94MB
        Beats 40.24%
     */
    public static List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int start = 0; start < nums.length - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }

            int left = start + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(List.of(nums[start], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}