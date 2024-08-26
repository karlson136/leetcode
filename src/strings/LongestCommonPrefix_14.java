/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

import java.util.Arrays;
import java.util.Comparator;

/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".



    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"

    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix_14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[] {"ab", "a"}));
    }

    /*
        Runtime
        1ms
        Beats 77.90% of users with Java

        Memory
        41.24MB
        Beats 77.34% of users with Java
     */
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        StringBuilder prefix = new StringBuilder();

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                break;
            } else {
                prefix.append(first.charAt(i));
            }
        }

        return prefix.toString();
    }
}