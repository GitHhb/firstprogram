package asml.codility;

public class SolutionNoClass {
    public int solution(int[] T, boolean[] B) {
        int[] countOccur = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            countOccur[i]++;
        }

        int[] index = new int[T.length];
        for (int i = 1; i < T.length; i++) {
            index[i] = index[i - 1] + countOccur[i - 1];
        }

        int[] nodes = new int[T.length];
        for (int i = 1; i < T.length; i++) {
//            nodes[index[T[i]]]
        }

        return 0;

    }
}
