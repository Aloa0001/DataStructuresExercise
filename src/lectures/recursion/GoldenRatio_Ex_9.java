package lectures.recursion;

public class GoldenRatio_Ex_9 {
    public static void main(String[] args) {
        System.out.println(goldenRatio(5));
        System.out.println(mystery(3,5));
        System.out.println(mystery(3,11));
    }

    private static float goldenRatio(int n) {
        if (n == 0) {
            return 1;
        }
        return 1 + 1 / goldenRatio(n - 1);
    }

    private static int mystery(int a, int b) {
        if (b == 0) return 0;
        else if (b % 2 == 0) return mystery(a + a, b / 2);
        else return mystery(a + a, b / 2) + a;
    }
}
