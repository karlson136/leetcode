/*
 * Copyright
 * Andrei Razhkou
 */

/*
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.



    Example 1:

    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:

    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:

    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class _125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindromeV2("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeV2("race a car"));
        System.out.println(isPalindromeV2(" "));
    }

    /*
        Runtime
        13ms
        Beats 43.60% of users with Java

        Memory
        44.63MB
        Beats 40.73% of users with Java
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*
        Runtime
        1ms
        Beats 100.00%
     */
    public static boolean isPalindromeV2(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        int diff = 'A' - 'a';
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (leftChar >= 'A' && leftChar <= 'Z') {
                leftChar -= diff;
            }

            if (rightChar >= 'A' && rightChar <= 'Z') {
                rightChar -= diff;
            }

            if ((leftChar < 'a' || leftChar > 'z') && (leftChar < '0' || leftChar > '9')) {
                left++;
                continue;
            }

            if ((rightChar < 'a' || rightChar > 'z') && (rightChar < '0' || rightChar > '9')) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}