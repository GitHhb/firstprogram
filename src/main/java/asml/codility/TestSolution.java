package asml.codility;

public class TestSolution {
    public static void main(String[] args) {
        int[] planets = {9, 1, 4, 9, 0, 4, 8, 1, 0, 7};
        boolean[] plutonium = {false, false, false, false, false, false, false, true, false, false};
        System.out.println(new Solution().solution(planets, plutonium));

        int[] planets2 = new int[]{0, 0, 1, 2, 3};
        boolean[] plutonium2 = { false, false, false, false, false};
        System.out.println(new Solution().solution(planets2, plutonium2));

        int[] planets1 = new int[]{7, 2, 2, 7, 0, 1, 5, 2};
        boolean[] plutonium1 = { false, false, false, true, false, false, true, true };
        System.out.println(new Solution().solution(planets1, plutonium1));

        int[] planets3 = new int[]{};
        boolean[] plutonium3 = { };
        System.out.println(new Solution().solution(planets3, plutonium3));

    }
}
