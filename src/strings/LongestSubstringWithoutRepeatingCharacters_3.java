package strings;/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.*;

/*
Given a string s, find the length of the longest
substring
without repeating characters.

    Example 1:

    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:

    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public static void main(String[] args) {
        System.out.println(longesString("dvdf"));
    }

    /*
        Runtime
        7ms
        Beats 43.82% of users with Java

        Memory
        44.55MB
        Beats 56.21% of users with Java
     */
    public static int longesString(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            char curChar = s.charAt(right);
            if (!charSet.contains(curChar)) {
                charSet.add(curChar);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(curChar)) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(curChar);
            }
        }

        return maxLength;
    }
}