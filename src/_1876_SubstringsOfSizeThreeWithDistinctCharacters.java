/*
 * Copyright
 * Andrei Razhkou
 */

/*
    A string is good if there are no repeated characters.

    Given a string s, return the number of good substrings of length three in s.

    Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

    A substring is a contiguous sequence of characters in a string.



    Example 1:

    Input: s = "xyzzaz"
    Output: 1
    Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
    The only good substring of length 3 is "xyz".

    Example 2:

    Input: s = "aababcabc"
    Output: 4
    Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
    The good substrings are "abc", "bca", "cab", and "abc".



    Constraints:

        1 <= s.length <= 100
        s consists of lowercase English letters.
 */
public class _1876_SubstringsOfSizeThreeWithDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));
        System.out.println(countGoodSubstrings("aababcabc"));
    }

    /*
        Runtime
        1ms
        Beats 90.23%

        Memory
        41.88MB
        Beats 50.18%
     */
    public static int countGoodSubstrings(String s) {
        int cnt = 0;

        if (s == null || s.length() < 3) {
            return cnt;
        }

        for (int i = 0; i < s.length() - 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);
            if (c1 != c2 && c1 != c3 && c2 != c3) {
                cnt++;
            }
        }
        return cnt;
    }

}