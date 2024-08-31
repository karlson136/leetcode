/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

/*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal
    substring
    consisting of non-space characters only.

    Example 1:

    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:

    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

    Example 3:

    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.

 */
public class LengthofLastWord_58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
    }

    /*
        Runtime
        1ms
        Beats 34.01%

        Memory
        41.90MB
        Beats 20.51%
     */
    public static int lengthOfLastWord1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] s1 = s.trim().split(" ");
        return s1[s1.length - 1].length();
    }

    /*
        Runtime
        0ms
        Beats 100.00%

        Memory
        41.28MB
        Beats   96.87%
     */
    public static int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = 0;
        boolean findNonSpace = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (findNonSpace) {
                    return length;
                }
            } else {
                if (!findNonSpace) {
                    findNonSpace = true;
                }
                length++;
            }
        }
        return length;
    }
}