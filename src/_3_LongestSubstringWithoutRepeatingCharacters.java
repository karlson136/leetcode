/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.HashSet;
import java.util.Set;

/*
    Given a string s, find the length of the longest

    without duplicate characters.


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

    Constraints:

        0 <= s.length <= 5 * 10^4
        s consists of English letters, digits, symbols and spaces.

 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /*
        Runtime
        6ms
        Beats 70.66%

        Memory
        45.00MB
        Beats 31.60%
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        Set<Character> chars = new HashSet<>();
        int maxLength = 0;
        int curLength = 0;

        int right = 0;
        int left = 0;
        while (right < array.length) {
            if (!chars.contains(array[right])) {
                chars.add(array[right]);
                curLength++;
                right++;
            } else {
                maxLength = Math.max(maxLength, curLength);
                while (chars.contains(array[right])) {
                    chars.remove(array[left]);
                    left++;
                    curLength--;
                }
            }
        }

        return Math.max(maxLength, curLength);
    }
}