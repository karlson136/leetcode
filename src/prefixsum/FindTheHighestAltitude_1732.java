/*
 * Copyright
 * Andrei Razhkou
 */

package prefixsum;

/*
    There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes.
    The biker starts his trip on point 0 with altitude equal 0.

    You are given an integer array gain of length n where gain[i] is the net gain in altitude between
    points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

    Example 1:

    Input: gain = [-5,1,5,0,-7]
    Output: 1
    Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

    Example 2:

    Input: gain = [-4,-3,-2,-1,4,3,2]
    Output: 0
    Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 */
public class FindTheHighestAltitude_1732 {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5,1,5,0,-7}));
        System.out.println(largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));
        System.out.println(largestAltitude(new int[]{28,0,-8,-99,11,62,-35,68,2,12,-71,13,66,-28}));
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        41.47MB
        Beats 23.64% of users with Java
     */
    public static int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length + 1];
        int max = 0;
        for (int i = 0; i < gain.length ; i++) {
            int altitude = gain[i] + altitudes[i];
            altitudes[i + 1] = altitude;
            max = Math.max(max, altitude);
        }
        return max;
    }
}