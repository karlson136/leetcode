/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;

/*
    You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].

    For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).

    Return an array answer where answer[i] is the answer to the ith query.

    Example 1:

    Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
    Output: [2,7,14,8]
    Explanation:
    The binary representation of the elements in the array are:
    1 = 0001
    3 = 0011
    4 = 0100
    8 = 1000
    The XOR values for queries are:
    [0,1] = 1 xor 3 = 2
    [1,2] = 3 xor 4 = 7
    [0,3] = 1 xor 3 xor 4 xor 8 = 14
    [3,3] = 8

    Example 2:

    Input: arr = [4,8,2,10], queries = [[2,3],[1,3],[0,0],[0,3]]
    Output: [8,0,4,4]

 */
public class XORQueriesOfASubarray_1310 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(xorQueries(new int[]{1, 3, 4, 8}, new int[][]{{0, 1}, {1, 2}, {0, 3}, {3, 3}})));
        System.out.println(Arrays.toString(xorQueries(new int[]{4, 8, 2, 10}, new int[][]{{2,3}, {1,3}, {0,0}, {0,3}})));

    }

    /*
        Runtime
        2ms
        Beats 100.00% of users with Java

        Memory
        57.52MB
        Beats 61.95% of users with Java
     */
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefixXors = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefixXors[i + 1] = prefixXors[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 0) {
                res[i] = prefixXors[query[1] + 1];
            } else {
                res[i] = prefixXors[query[1] + 1] ^ prefixXors[query[0]];
            }
        }
        return res;
    }
}