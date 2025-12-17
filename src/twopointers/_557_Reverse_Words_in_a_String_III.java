/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

    Example 1:

    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Example 2:

    Input: s = "Mr Ding"
    Output: "rM gniD"

    Constraints:

        1 <= s.length <= 5 * 104
        s contains printable ASCII characters.
        s does not contain any leading or trailing spaces.
        There is at least one word in s.
        All the words in s are separated by a single space.


 */
public class _557_Reverse_Words_in_a_String_III {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords("Mr Ding"));
        System.out.println("[" + reverseWords("   ") + "]");
        System.out.println("[" + reverseWords("1") + "]");
    }

    /*
        Runtime
        4ms
        Beats 87.79%

        Memory
        46.45MB
        Beats 63.58%
     */
    public static String reverseWords(String s) {

        int start = 0;
        int end = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == ' ') {
                end = i - 1;
                while (start < end) {
                    char thirdGlass = arr[end];
                    arr[end] = arr[start];
                    arr[start] = thirdGlass;
                    start++;
                    end--;
                }
                start = i + 1;
            }
        }

        if (start < arr.length) {
            end = arr.length - 1;
            while (start < end) {
                char thirdGlass = arr[end];
                arr[end] = arr[start];
                arr[start] = thirdGlass;
                start++;
                end--;
            }
        }

        return new String(arr);
    }
}