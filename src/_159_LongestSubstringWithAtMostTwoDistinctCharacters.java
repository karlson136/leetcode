/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.HashMap;
import java.util.Map;

public class _159_LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(longestSubstr("eceba"));
        System.out.println(longestSubstr("ccaabbb"));
        System.out.println(longestSubstr("cab"));
    }

    public static int longestSubstr(String s) {
        int maxLength = 0;

        int left = 0;
        int right = 0;
        Map<Character, Integer> chars = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (!chars.containsKey(rightChar)) {
                while (chars.size() > 1) {
                    if (chars.get(s.charAt(left)) == 1) {
                        chars.remove(s.charAt(left));
                    } else {
                        chars.put(s.charAt(left), chars.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
            }
            chars.put(rightChar, chars.computeIfAbsent(rightChar, k -> 0) + 1);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}