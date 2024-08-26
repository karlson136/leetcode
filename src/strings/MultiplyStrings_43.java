/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

/*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

    Example 1:

    Input: num1 = "2", num2 = "3"
    Output: "6"

    Example 2:

    Input: num1 = "123", num2 = "456"
    Output: "56088"



    Constraints:

        1 <= num1.length, num2.length <= 200
        num1 and num2 consist of digits only.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings_43 {

    public static void main(String[] args) {
//        System.out.println(multiply("2", "3"));
//        System.out.println(multiply("123", "456"));
        System.out.println(multiply("123456789", "987654321"));
    }

    public static String multiply(String num1, String num2) {
        double multiplier = 1;
        double num1D = 0;
        for(int i = num1.length() - 1; i>= 0; i--) {
            num1D += (num1.charAt(i) - '0') * multiplier;
            multiplier *= 10;
        }

        multiplier = 1;
        double num2D = 0;
        for(int i = num2.length() - 1; i>= 0; i--) {
            num2D += (num2.charAt(i) - '0') * multiplier;
            multiplier *= 10;
        }

        return String.format("%.0f", num1D * num2D);
    }
}