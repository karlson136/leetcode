/*
 * Copyright
 * Andrei Razhkou
 */

/*
    Given a 2D matrix matrix, handle multiple queries of the following type:

        Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Implement the NumMatrix class:

        NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
        int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    You must design an algorithm where sumRegion works on O(1) time complexity.

    Input
    ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    Output
    [null, 8, 11, 12]

    Explanation
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
 */
public class RangeSumQuery2DImmutable_304 {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)


        numMatrix = new NumMatrix(new int[][]{{-4, -5}});
        System.out.println(numMatrix.sumRegion(0, 0, 0, 0)); // return 8 (i.e sum of the red rectangle)
        System.out.println(numMatrix.sumRegion(0, 0, 0, 1)); // return 11 (i.e sum of the green rectangle)
        System.out.println(numMatrix.sumRegion(0, 1, 0, 1)); // return 12 (i.e sum of the blue rectangle)
    }

    /*
        Runtime
        120ms
        Beats 15.59% of users with Java

        Memory
        71.74MB
        Beats 6.52% of users with Java
     */
     static class NumMatrix1 {

        private int[][] prefixSum;

        public NumMatrix1(int[][] matrix) {
            prefixSum = new int[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                prefixSum[i] = new int[matrix[i].length + 1];
                prefixSum[i][0] = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    prefixSum[i][j + 1] = prefixSum[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += col1 == 0 ? prefixSum[i][col2 + 1] : prefixSum[i][col2 + 1] - prefixSum[i][col1];
            }
            return sum;
        }
    }

    /*
        Runtime
        100ms
        Beats 71.45% of users with Java

        Memory
        70.80MB
        Beats 41.96% of users with Java
     */
    static class NumMatrix {

        private int[][] sums;

        public NumMatrix(int[][] matrix) {
            sums = new int[matrix.length + 1][];
            sums[0] = new int[matrix[0].length + 1];

            for (int i = 1; i <= matrix.length; i++) {
                sums[i] = new int[matrix[i - 1].length + 1];
                for (int j = 1; j <= matrix[i - 1].length; j++) {
                    sums[i][j] = sums[i -1][j] + sums[i][j - 1] + matrix[i - 1][j - 1] - sums[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];
        }
    }
}