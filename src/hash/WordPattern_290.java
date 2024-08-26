/*
 * Copyright
 * Andrei Razhkou
 */

package hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
    Given a pattern and a string s, find if s follows the same pattern.

    Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

    Example 1:

    Input: pattern = "abba", s = "dog cat cat dog"
    Output: true

    Example 2:

    Input: pattern = "abba", s = "dog cat cat fish"
    Output: false

    Example 3:

    Input: pattern = "aaaa", s = "dog cat cat dog"
    Output: false

    Constraints:

        1 <= pattern.length <= 300
        pattern contains only lower-case English letters.
        1 <= s.length <= 3000
        s contains only lowercase English letters and spaces ' '.
        s does not contain any leading or trailing spaces.
        All the words in s are separated by a single space.
 */
public class WordPattern_290 {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("aaaa", "dog cat cat fish"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    /*
        Runtime
        0ms
        Beats 100.00% of users with Java

        Memory
        41.19MB
        Beats 76.01% of users with Java
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] charArray = pattern.toCharArray();
        if (charArray.length != words.length) {
            return false;
        }

        Map<Character, String> wordPattern = new HashMap<>();
        Set<String> visitedWords = new HashSet<>();

        for (int i = 0; i < charArray.length; i++) {
            if (!wordPattern.containsKey(charArray[i])) {
                if (visitedWords.contains(words[i])) {
                    return false;
                }
                wordPattern.put(charArray[i], words[i]);
                visitedWords.add(words[i]);
            } else {
                if (!wordPattern.get(charArray[i]).equals(words[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}