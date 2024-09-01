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
        System.out.println(addBinary("110010", "10111")); // 1001001
        System.out.println(addBinary("100", "110010")); // 110110
        System.out.println(addBinary("0", "0")); // 0
        System.out.println(addBinary("0", "1")); // 1
        System.out.println(addBinary("1", "111")); // 1000
        System.out.println(addBinary("11", "1")); // 100
        System.out.println(addBinary("11", "11")); // 110
        System.out.println(addBinary("111", "11")); // 1010
        System.out.println(addBinary("1010", "1011")); // 10101
    }

    /*
        Runtime
        2ms
        Beats 47.47%

        Memory
        42.08MB
        Beats 71.93%
     */
    public static String addBinary1(String a, String b) {
        StringBuilder sum = new StringBuilder();
        char ten = '0';

        int minLength = Math.min(a.length(), b.length());
        for(int i = 0; i < minLength; i++){
            char aChar = a.charAt(a.length() - i - 1);
            char bChar = b.charAt(b.length() - i - 1);

            if (aChar == bChar) {
                sum.append(ten == '1' ? '1' : '0');
                ten = aChar == '1' ? '1' : '0';
            } else {
                sum.append(ten == '1' ? '0' : '1');
            }
        }

        if (a.length() == b.length()){
            if (ten == '1') {
                sum.append(ten);
            }
        } else {
            String maxStr = a.length() > b.length() ? a : b;
            int length = maxStr.length();
            for(int i = minLength; i < length; i++){
                char mChar = maxStr.charAt(length - i - 1);
                if (mChar == '1') {
                    sum.append(ten == '1' ? '0' : '1');
                } else {
                    sum.append(ten == '1' ? '1' : '0');
                    ten = '0';
                }
            }

            if (ten == '1') {
                sum.append(ten);
            }
        }

        return sum.reverse().toString();
    }
}