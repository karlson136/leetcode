/*
 * Copyright
 * Andrei Razhkou
 */

package prefixsum;

/*
    You are given a string s of lowercase English letters and an integer array shifts of the same length.

    Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

        For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.

    Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

    Return the final string after all such shifts to s are applied.



    Example 1:

    Input: s = "abc", shifts = [3,5,9]
    Output: "rpl"
    Explanation: We start with "abc".
    After shifting the first 1 letters of s by 3, we have "dbc".
    After shifting the first 2 letters of s by 5, we have "igc".
    After shifting the first 3 letters of s by 9, we have "rpl", the answer.

    Example 2:

    Input: s = "aaa", shifts = [1,2,3]
    Output: "gfd"

 */
public class ShiftingLetters_848 {

    public static void main(String[] args) {
//        System.out.println(shiftingLetters("abc", new int[]{3, 5, 9}));
//        System.out.println(shiftingLetters("aaa", new int[]{1,2,3}));
        System.out.println(shiftingLetters("mkgfzkkuxownxvfvxasy", new int[]{505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
    }

    /*
        Runtime
        9ms
        Beats 63.65% of users with Java

        Memory
        55.68MB
        Beats 80.94% of users with Java
     */
    public static String shiftingLetters(String s, int[] shifts) {
        int[] letterArray = new int[s.length() + 1];
        for (int i = 0; i< s.length(); i++) {
            letterArray[i+1] = (int)s.charAt(i) - (int)'a';
        }

        long[] diffArray = new long[s.length()];
        for (int i = 0; i < letterArray.length - 1; i++) {
            diffArray[i] = letterArray[i+1] - letterArray[i];
        }

        for(int i = 0; i < shifts.length; i++) {
            diffArray[0] += shifts[i];
            if (i + 1 < diffArray.length ) {
                diffArray[i+1] -= shifts[i];
            }
        }

        long[] c = new long[letterArray.length];
        c[0] = 0;
        for(int i = 0; i < diffArray.length; i++) {
            c[i+1] = c[i] + diffArray[i];
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 1; i< c.length; i++) {
            builder.append((char)(c[i] % 26 + (int)'a'));
        }
        return builder.toString();
    }
}