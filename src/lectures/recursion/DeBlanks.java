package lectures.recursion;

public class DeBlanks {
    public static void main(String[] args) {
        String input = "a b c   d e f g         h i j k l m n o p r s        t u v x y   zq";
        System.out.println(deBlanks(input));
        System.out.println(deBlank(input));
    }
    private static String deBlanks(String input){
        if (input.length() == 0){
            return input;
        }
        char[] in = input.toCharArray();
        if (String.valueOf(in[0]).equals(" ")){
            return deBlanks(input.substring(1));
        }else{
            return input.charAt(0) + deBlanks(input.substring(1));
        }
    }
    private static String deBlank(String input){
        if (input.length() == 0){
            return input;
        }else if (input.charAt(0) == ' '){
            return deBlank(input.substring(1));
        }else{
            return input.charAt(0) + deBlank(input.substring(1));
        }
    }
}
