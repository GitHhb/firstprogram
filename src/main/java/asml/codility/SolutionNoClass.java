package asml.codility;

public class SolutionNoClass {
    public int solution(int[] T, boolean[] B) {
        int[] countOccur = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            countOccur[T[i]]++;
        }
        printit(T);
        printit(countOccur);

        int[] index = new int[T.length];
        for (int i = 1; i < T.length; i++) {
            index[i] = index[i - 1] + countOccur[i - 1];
            countOccur[i - 1] = index[i - 1];
        }
        if (T.length > 0) {
            countOccur[T.length - 1] = index[T.length - 1];
        }

        int[] nodes = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            nodes[countOccur[T[i]]++] = i;
        }

        printit(countOccur);
        printit(index);
        printit(nodes);
        return 0;

    }

    void printit(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%2d ", x[i]);
        }
        System.out.println();
    }
}
