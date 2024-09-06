/*
 * Copyright
 * Andrei Razhkou
 */

package strings;

/*
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

    For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:

    Input: columnNumber = 1
    Output: "A"

    Example 2:

    Input: columnNumber = 28
    Output: "AB"

    Example 3:

    Input: columnNumber = 701
    Output: "ZY"

    Constraints:

        1 <= columnNumber <= 231 - 1
 */
public class ExcelSheetColumnTitle_168 {

    public static void main(String[] args) {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println(convertToTitle(1)); // A
        System.out.println(convertToTitle(28)); // AB
        System.out.println(convertToTitle(701)); // ZY
    }

    /*
        Runtime
        0ms
        Beats 100.00%

        Memory
        40.35MB
        Beats 94.69%
     */
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int div = (columnNumber - 1) % 26;
            sb.append((char)('A' + div));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}