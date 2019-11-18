package lectures.recursion;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println("is "+isPalindrome("fggfg"));
    }
    private static boolean isPalindrome(String input){
        if (input.length() < 2){
            return true;
        }
        char[] in = input.toCharArray();
        if (String.valueOf(in[0]).equals(String.valueOf(in[in.length-1]))){
            return isPalindrome(input.substring(1, input.length()-1));
        }else {
            return false;
        }
    }
}
