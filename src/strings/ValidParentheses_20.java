/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

import java.util.Stack;

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.



    Example 1:

    Input: s = "()"
    Output: true

    Example 2:

    Input: s = "()[]{}"
    Output: true

    Example 3:

    Input: s = "(]"
    Output: false
 */
public class ValidParentheses_20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    /*
        Runtime
        2ms
        Beats 54.10% of users with Java

        Memory
        41.34MB
        Beats 64.23% of users with Java
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char lastBracket = stack.pop();
                if (
                        (c == ')' && lastBracket != '(') ||
                        (c == ']' && lastBracket != '[') ||
                        (c == '}' && lastBracket != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}