package chapter1;

public class Ex6 {

    public static void main(String[] args) {

        cyclic("abcdefghijklmnoprstuvxzywq");
    }

    private static void cyclic(String str) {
        System.out.println(str);
        cyclic(str.toCharArray(), 0, str.toCharArray().length - 1);
    }

    private static void cyclic(char[] str, int low, int high) {

        if (low == high) {
            return;
        } else {
            char[] copied = new char[str.length];
            for (int j = 1; j < str.length; j++) {
                copied[j - 1] = str[j];
                System.out.print(str[j]);
            }
            high--;
            System.out.println(str[0]);
            copied[str.length - 1] = str[0];
            cyclic(copied, low, high);
        }
    }
}
