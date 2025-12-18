/*
 * Copyright
 * Andrei Razhkou
 */

package twopointers;

/*
    Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

    Example 1:

    Input: c = 5
    Output: true
    Explanation: 1 * 1 + 2 * 2 = 5

    Example 2:

    Input: c = 3
    Output: false

    Constraints:

        0 <= c <= 2^31 - 1
 */
public class _633_Sum_of_Square_Numbers {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(1000000));
        System.out.println(judgeSquareSum(2147482647));
    }

    /*
        Runtime
        4ms
        Beats 73.15%

        Memory
        42.26MB
        Beats 19.59%
     */
    public static boolean judgeSquareSum(int c) {
        int first = 0;
        int second = (int) Math.sqrt(c);

        while (first <= second) {
            int sqrtSum = first * first + second * second;
            if (sqrtSum == c) {
                return true;
            } else if (sqrtSum > c) {
                second--;
            } else {
                first++;
            }
        }
        return false;
    }
}