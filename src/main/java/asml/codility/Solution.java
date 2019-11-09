package asml.codility;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] T, boolean[] B) {
        // write your code in Java SE 8

        // amount of plutonium the ship can hold at maximum
        final int MAX_PLUTONIUM = 3;

        // Init
        int sp;
        int count = 0;

        // get starting point
        for (int i = 0; i < T.length; i++) {
            if (i == T[i]) {
                sp = i;
                count = 1;
                break;
            }
        }

        // if there is no starting point, STOP
        if (count == 0) {
            return count;
        }

        // search reachable paths



        return 100;


    }
}

