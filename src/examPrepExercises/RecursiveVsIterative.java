package examPrepExercises;

public class RecursiveVsIterative {
    public static void main(String[] args) {
        System.out.println(recursive(8));
        System.out.println(iterative(8));
    }

    private static float recursive(float n) {
        if (n == 0) {
            return 1;
        }
        return 1 + 1 / recursive(n - 1);
    }

    private static float iterative(float n) {
        int i = 0;
        float result = 1;
        while (i < n) {
            result = 1 + 1 / result;
            i++;
        }
        return result;
    }
}
