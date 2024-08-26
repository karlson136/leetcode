/*
 * Copyright
 * Andrei Razhkou
 */

/*
    Given an integer x, return true if x is a
    palindrome
    , and false otherwise.

    Example 1:
    Input: x = 121
    Output: true
    Explanation: 121 reads as 121 from left to right and from right to left.

    Example 2:
    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

    Example 3:
    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */
public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12));
    }

    /*
        Runtime
        6ms
        Beats37.37%of users with Java

        Memory
        43.67MB
        Beats88.57%of users with Java
     */
    public static boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        char[] c = String.valueOf(x).toCharArray();
        int left = 0; int right = c.length - 1;
        while (left < right) {
            if (c[left] != c[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    /*
        Runtime
        4ms
        Beats 100.00% of users with Java

        Memory
    43.78MB
    Beats 79.30% of users with Java
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int q = x;
        int newX = 0;
        while (q >0) {
            newX = newX*10 + q % 10;
            q /=10;
        }

        return x == newX;
    }
}