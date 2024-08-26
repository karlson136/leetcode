/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;
import java.util.Comparator;

public class ForSomeTest {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{2, 6}, {1, 3}, {9, 18}, {6, 10}};

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr));

        int[][] combinedArr = new int[arr.length][];
        combinedArr[0] = arr[0];
        int currentCell = 0;
        for(int i = 1; i < arr.length; i++) {
            if(combinedArr[currentCell][1] >= arr[i][0]) {
                combinedArr[currentCell][1] = Math.max(combinedArr[currentCell][1], arr[i][1]);
            } else {
                currentCell++;
                combinedArr[currentCell] = arr[i];
            }
        }
        combinedArr = Arrays.copyOfRange(combinedArr, 0, currentCell + 1);
        System.out.println(Arrays.deepToString(combinedArr));
    }
}