package lectures.recursion;

public class PrintIntRecursively {
    public static void main(String[] args) {
        printIntegerRecursively(1376789747);
    }

    private static void printIntegerRecursively(int n) {
        if (n >= 10) {
            printIntegerRecursively(n/10);
        }
            System.out.print(n%10);
    }
}
