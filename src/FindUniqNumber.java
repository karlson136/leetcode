/*
 * Copyright
 * Andrei Razhkou
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindUniqNumber {

    public static void main(String[] args) {
        System.out.println(find(new int[]{1,2,3,2,1,3,4}));
        reverseMap();
    }

    public static int find(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void reverseMap() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(0, 1, 2));
        map.put(2, Arrays.asList(3, 4));
        Map<Integer, Integer> newMap =
        map.entrySet().stream().flatMap(e ->
            e.getValue().stream().map(v -> Map.entry(v, e.getKey()))
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println();
    }

}