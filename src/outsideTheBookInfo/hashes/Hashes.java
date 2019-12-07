package outsideTheBookInfo.hashes;

import java.util.Hashtable;

public class Hashes {

    public static void main(String[] args) {
        String hash = "Alexander";
        String h = "Alexandee";

        int i = hashXCode(hash);
        System.out.println(i);
        System.out.println(hash.charAt(8));
        System.out.println(hash.hashCode());
        System.out.println(h.hashCode());

        Hashtable<Integer, String> table = new Hashtable<>();
        System.out.println(table);
        System.out.println(table.contains(hash));
        System.out.println();

    }

    /**hashCode method*/
    public static int hashXCode(String s){
        int g = 31;
        int hash = 0;
        for(int i = 0 ; i<s.length(); i++){
            hash = g*hash + s.charAt(i);
        }
        return hash;
    }
}
