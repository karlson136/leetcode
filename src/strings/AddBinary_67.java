/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

/*
    Given two binary strings a and b, return their sum as a binary string.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"

    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:

        1 <= a.length, b.length <= 104
        a and b consist only of '0' or '1' characters.
        Each string does not contain leading zeros except for the zero itself.


 */
public class AddBinary_67 {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("1010", "1011")); // 10101
    }

    public static String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        char ten = '0';

        for(int i = 0; i < Math.max(a.length(), b.length()); i++){
            char aChar;
            if (i < a.length()) {
                aChar = a.charAt(i);
            } else {
                aChar = '0';
            }

            char bChar;
            if (i < b.length()) {
                bChar = b.charAt(i);
            } else {
                bChar = '0';
            }

            if (aChar == '1' && bChar == '1') {

            }
        }

        if (ten == '1'){
            sum.append(ten);
        }

        return sum.reverse().toString();
    }
}