package hashes;

import com.sun.net.httpserver.Filter;

import java.util.Collections;
import java.util.Hashtable;

public class Hashes {









    public static void main(String[] args) {
        String hash = "Alexander";
        int i = hashXCode(hash);
        System.out.println(i);
        System.out.println(hash.hashCode());

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
