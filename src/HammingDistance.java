/*
 * Copyright
 * Andrei Razhkou
 */

/*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, return the Hamming distance between them.



    Example 1:

    Input: x = 1, y = 4
    Output: 2
    Explanation:
    1   (0 0 0 1)
    4   (0 1 0 0)
           ↑   ↑
    The above arrows point to positions where the corresponding bits are different.

    Example 2:

    Input: x = 3, y = 1
    Output: 1
 */
public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,3));
    }

    public static int hammingDistance(int x, int y) {
        String xStr = new StringBuilder(Integer.toBinaryString(x)).reverse().toString();
        String yStr = new StringBuilder(Integer.toBinaryString(y)).reverse().toString();
        int count = 0;
        for (int i = 0; i < Math.max(xStr.length(),yStr.length()); i++) {
            char xChar = i >= xStr.length() ? '0': xStr.charAt(i);
            char yChar = i >= yStr.length() ? '0': yStr.charAt(i);

            if (xChar != yChar) {
                count++;
            }
        }
        return count;
    }
}