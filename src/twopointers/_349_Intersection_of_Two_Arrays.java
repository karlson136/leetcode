/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    Given two integer arrays nums1 and nums2, return an array of their

    . Each element in the result must be unique and you may return the result in any order.

    Example 1:

    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]

    Example 2:

    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.

    Constraints:

        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000

 */
public class _349_Intersection_of_Two_Arrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection3(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersection3(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
        System.out.println(Arrays.toString(intersection3(new int[]{4, 9, 5}, new int[]{1, 2, 3})));
    }

    /*
    Runtime
    9ms
    Beats 6.98%

    Memory
    45.47MB
    Beats 8.92%

     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) {
                res.add(nums1[first]);

                if (first + 1 == nums1.length && second + 1 == nums2.length) {
                    first++;
                    second++;
                } else {
                    if (first < nums1.length - 1) {
                        first++;
                    }
                    if (second < nums2.length - 1) {
                        second++;
                    }
                }

            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }

        return res.stream().mapToInt(Number::intValue).toArray();
    }

    /*
    Runtime
    6ms
    Beats 18.17%

    Memory
    45.08MB
    Beats 15.47%

     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) {
                if (index == 0 || res[index - 1] != nums1[first]) {
                    res[index] = nums1[first];
                    index++;
                }

                if (first + 1 == nums1.length && second + 1 == nums2.length) {
                    first++;
                    second++;
                } else {
                    if (first < nums1.length - 1) {
                        first++;
                    }
                    if (second < nums2.length - 1) {
                        second++;
                    }
                }

            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }

        return index == 0 ? new int[]{} : Arrays.copyOfRange(res, 0, index);
    }

    /*


     */
    public static int[] intersection3(int[] nums1, int[] nums2) {
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        int index = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first = 0;
        int second = 0;

        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] == nums2[second]) {
                if (index == 0 || res[index - 1] != nums1[first]) {
                    res[index] = nums1[first];
                    index++;
                }

                if (first + 1 == nums1.length && second + 1 == nums2.length) {
                    first++;
                    second++;
                } else {
                    if (first < nums1.length - 1) {
                        first++;
                    }
                    if (second < nums2.length - 1) {
                        second++;
                    }
                }

            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
                first++;
            }
        }

        return index == 0 ? new int[]{} : Arrays.copyOfRange(res, 0, index);
    }
}