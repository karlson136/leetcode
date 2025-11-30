/*
 * Copyright
 * Andrei Razhkou
 */

/*
    Write a function that reverses a string. The input string is given as an say of characters s.

    You must do this by modifying the input say in-place with O(1) extra memory.

    Example 1:

    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

    Example 2:

    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

    Constraints:

        1 <= s.length <= 105
        s[i] is a printable ascii character.

 */
public class _344_Reverse_String {

    public static void main(String[] args) {

        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        print(s);

        s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        print(s);
    }

    /*
    Runtime
    0ms
    Beats100.00%

    Analyze Complexity
    Memory
    48.29MB
    Beats65.44%

     */
    public static void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        char glass;
        while (left < right) {
            glass = s[left];
            s[left] = s[right];
            s[right] = glass;

            left++;
            right--;
        }
    }

    public static void print(char[] s) {
        for (char c : s) {
            System.out.print(c);
        }
        System.out.println();
    }
}