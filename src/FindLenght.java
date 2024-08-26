/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
f([1,1,0,1,1,0]) = 2
f([1,1,0,1,1,1]) = 3
f([1,1,1,1,1,1]) = 5
f([0,0,0]) = 0
f([]) = 0

 */
public class FindLenght {
    public static void main(String[] args) {
        int maxLenght = maxLenghtFunc(new int[]{});
        System.out.println(maxLenght);
    }

    //second try
    public static int maxLenghtFunc(int[] nums) {
        int maxLenght = 0;
        int curMaxLenght = 0;
        for (int i: nums) {
            if (i == 1) {
                curMaxLenght++;
            } else {
                if(curMaxLenght > maxLenght) {
                    maxLenght = curMaxLenght;
                }
                curMaxLenght = 0;
            }
        }
        if(curMaxLenght > maxLenght) {
            maxLenght = curMaxLenght;
        }
        return maxLenght;
    }
}