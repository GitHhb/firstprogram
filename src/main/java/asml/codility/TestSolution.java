package asml.codility;

public class TestSolution {
    public static void main(String[] args) {
        int[] planets = {9, 1, 4, 9, 0, 4, 8, 1, 0, 7};
        boolean[] plutonium = {false, false, false, false, false, false, false, true, false, false};
        System.out.println(new Solution().solution(planets, plutonium));
    }
}
