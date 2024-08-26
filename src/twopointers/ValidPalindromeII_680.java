/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.

    Example 1:

    Input: s = "aba"
    Output: true

    Example 2:

    Input: s = "abca"
    Output: true
    Explanation: You could delete the character 'c'.

    Example 3:

    Input: s = "abc"
    Output: false

 */
public class ValidPalindromeII_680 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abc"));
        System.out.println(validPalindrome("deeee"));
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    /*
        Runtime
        4ms
        Beats 99.72% of users with Java

        Memory
        45.17MB
        Beats 77.25% of users with Java
     */
    public static boolean validPalindrome(String s) {
        return helper(s, 0, s.length() - 1, false);
    }

    public static boolean helper(String s, int left, int right, boolean badCasesExist) {
        if (s == null) {
            return false;
        } else if (s.length() == 1) {
            return true;
        }

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (badCasesExist) {
                    return false;
                }
                return helper(s, left + 1, right, true) || helper(s, left, right - 1, true);
            }
            left++;
            right--;
        }

        return true;
    }
}