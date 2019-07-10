package chapter1;

import java.util.Scanner;

public class Ex2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Select a number: ");
        int choice = in.nextInt();
        System.out.println("The factorial number of " + choice + " is " + findFactorial(choice));
    }

    private static int findFactorial(int n) {
        if (n < 2) {
            return n;
        } else {
            return n * findFactorial(n - 1);
        }
    }
}
