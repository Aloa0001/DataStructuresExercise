package examPrepExercises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class RecursiveVsIterative {
    public static void main(String[] args) throws FileNotFoundException {
        Stack<Integer> stack = new Stack<>();
        System.out.println(true);
        stack.push(5);
        System.out.println(stack);
        System.out.println(recursive(8));
        System.out.println(iterative(8));
        System.out.println();

        Set<String> s = new TreeSet<>(Collections.reverseOrder());
        s.add("joe");
        s.add("bob");
        s.add("hal");
        System.out.println(s);
        System.out.println();

        TreeSet<String> ts = new TreeSet<>();
        ts.add("joe");
        ts.add("bob");
        ts.add("hal");
        System.out.println(ts);
        System.out.println();

        TreeSet<Integer> treeSet2 = new TreeSet<>();
        treeSet2.add(1);
        treeSet2.add(2);
        treeSet2.add(-2);
        treeSet2.add(4);
        System.out.println(treeSet2);



        TreeMap<String, Integer> frequencyData = new TreeMap<>( );
        readWordFile(frequencyData, "Numbers.txt");
        printAllCounts(frequencyData);
    }
    public static void printAllCounts(TreeMap<String, Integer> frequencyData){
        System.out.println("    Occurrences    Word");
        for(String word : frequencyData.keySet( )){
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }


    }

    public static void readWordFile(TreeMap<String, Integer> frequencyData, String file) throws FileNotFoundException {
        Scanner wordFile;
        String word;     // A word read from the file
        int count;   // The number of occurrences of the word

        wordFile = new Scanner(new FileReader(file));

        while (wordFile.hasNext()) {  // Read the next word and get rid of the end-of-line marker if needed:
            word = wordFile.next();   // Get the current count of this word, add one, and then store the new count:
            count = getCount(word, frequencyData) + 1;
            frequencyData.put(word, count);
        }
    }

    private static int getCount(String word, TreeMap<String, Integer> frequencyData) {
        // The word has occurred before, so get its count from map
        // No occurrences of this word
        return frequencyData.getOrDefault(word, 0); // Auto-unboxed
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
