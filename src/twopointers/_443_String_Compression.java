/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

import java.util.Arrays;

/*
    Given an array of characters chars, compress it using the following algorithm:
    Begin with an empty string s. For each group of consecutive repeating characters in chars:

        If the group's length is 1, append the character to s.
        Otherwise, append the character followed by the group's length.

    The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
    After you are done modifying the input array, return the new length of the array.
    You must write an algorithm that uses only constant extra space.
    Note: The characters in the array beyond the returned length do not matter and should be ignored.

    Example 1:

    Input: chars = ["a","a","b","b","c","c","c"]
    Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
    Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".

    Example 2:

    Input: chars = ["a"]
    Output: Return 1, and the first character of the input array should be: ["a"]
    Explanation: The only group is "a", which remains uncompressed since it's a single character.

    Example 3:

    Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
    Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
    Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".


    Constraints:

        1 <= chars.length <= 2000
        chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.
 */
public class _443_String_Compression {

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));

        chars = new char[]{'a'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));

        chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));

        chars = new char[]{'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));

        chars = new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));

        chars = new char[]{'a', 'b', 'c'};
        System.out.println(compress2(chars) + ": " + Arrays.toString(chars));
    }

    /*
    Runtime
    1ms
    Beats 99.64%

    Memory
    45.60MB
    Beats 13.63%
     */
    public static int compress(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }

        int idx = 0;
        int pointer = 1;

        int curentCharCnt = 1;
        while (pointer < chars.length) {
            if (chars[pointer] == chars[pointer - 1]) {
                curentCharCnt++;
            } else {
                chars[idx] = chars[pointer - 1];
                idx++;
                if (curentCharCnt > 1) {
                    for (char c : String.valueOf(curentCharCnt).toCharArray()) {
                        chars[idx] = c;
                        idx++;
                    }
                }
                curentCharCnt = 1;
            }
            pointer++;
        }

        chars[idx] = chars[pointer - 1];
        idx++;
        if (curentCharCnt > 1) {
            for (char c : String.valueOf(curentCharCnt).toCharArray()) {
                chars[idx] = c;
                idx++;
            }
        }

        return idx;
    }

    /*
    Runtime
    1ms
    Beats 99.64%

    Memory
    45.41MB
    Beats 21.38%
     */
    public static int compress2(char[] chars) {
        int idx = 0;
        int pointer = 0;

        while (pointer < chars.length) {
            int curentCharCnt = 1;
            while (pointer + curentCharCnt < chars.length && chars[pointer] == chars[pointer + curentCharCnt]) {
                curentCharCnt++;
            }
            chars[idx] = chars[pointer];
            idx++;

            if (curentCharCnt > 1) {
                for (char c : String.valueOf(curentCharCnt).toCharArray()) {
                    chars[idx] = c;
                    idx++;
                }
            }

            pointer += curentCharCnt;
        }

        return idx;
    }
}