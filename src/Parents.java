/*
 * Copyright
 * © 2023 The Mom Project. ALL RIGHTS RESERVED.
 */

import java.util.HashSet;
import java.util.Set;

public class Parents {
    public static void main(String[] args) {
        Set<Integer> s  = new HashSet<>();
        s.add(1);
        s.add(5);
        s.add(2);
        s.stream().forEach(System.out::println);
        generate("", 0,0,3);
    }

    public static void generate(String s, int open, int closed, int n) {
        if (s.length() == 2*n) {
            System.out.println(s);
            return;
        }
        if (open < n) {
            generate(s + "(", open + 1, closed, n);
        }
        if (closed < open) {
            generate(s + ")", open, closed + 1, n);
        }
    }
}