package outsideTheBookInfo.trees;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("something", 22);
        System.out.println(treeMap.containsKey("something"));
        System.out.println(treeMap.get("something"));

        //course example
        for (String word : treeMap.keySet()) {
            System.out.println(word);
        }
        TreeMap<String, Integer> frequencyData = new TreeMap<>();
       // readWordFile(frequencyData, "Numbers.txt"); //not working
        printAllCounts(frequencyData);
    }

    public static void printAllCounts(TreeMap<String, Integer> frequencyData) {
        System.out.println("    Occurrences    Word");
        for (String word : frequencyData.keySet()) {
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }
    }


    /**
     * https://hkr.instructure.com
     *
     * @param treeMap the collection
     * @param file    the source
     * @throws FileNotFoundException if the file is not found
     */
    public static void readWordFile(TreeMap<String, Integer> treeMap, String file) throws FileNotFoundException {
        Scanner wordFile;
        String word;     // A word read from the file
        int count;   // The number of occurrences of the word
        wordFile = new Scanner(new FileReader(file));
        while (wordFile.hasNext()) {
            // Read the next word and get rid of the end-of-line marker if needed:
            word = wordFile.next();
            // Get the current count of this word, add one, and then store the new count:
            count = getCount(word, treeMap) + 1; //?
            treeMap.put(word, count);
        }
    }

    private static int getCount(String word, TreeMap<String, Integer> treeMap) {
        // return the value at the key word, or 0 if doesn't exist
        return treeMap.getOrDefault(word, 0); // Auto-unboxed
    }
}
