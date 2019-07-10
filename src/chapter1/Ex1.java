package chapter1;

import java.util.Scanner;

/**
 * Highest common factor of two numbers
 */
public class Ex1 {

    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        a = sc.nextInt();
        System.out.println("Enter your second number: ");
        b = sc.nextInt();
        System.out.println("The H.C.F of " + a + " and " + b + " is: " + HCF(a,b));
    }

    private static int HCF(int a, int b) {

        int c;
        if (a > b) {
            c = a % b;
            if (c == 0)
                return b;
            else
                return HCF(b, c);
        } else {
            c = b % a;
            if (c == 0)
                return a;
            else
                return HCF(a, c);
        }
    }
}
