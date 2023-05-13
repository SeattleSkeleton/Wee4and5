import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("mobydick.txt"));
        Set<String> uniqueWords = new HashSet<>(counter(in));
        System.out.println("Number of unique words = " + uniqueWords.size());
        ArrayList<String> test = toArrayList(uniqueWords);
        toLinkedList(uniqueWords);
        toArray(uniqueWords);
    }

    public static Set<String> counter(Scanner in) {
        Set<String> uniqueWords = new HashSet<>();
        long startTime = System.currentTimeMillis();

        while (in.hasNext()) {
            String word = in.next().toLowerCase();
            uniqueWords.add(word);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time (ms): " + (endTime - startTime));
        return uniqueWords;
    }

    public static boolean contains(String word, Set<String> uniqueWords) {
        if (uniqueWords.contains(word)) {
            return true;
        } else {
            return false;
        }
    }

    public static String[] toArray(Set<String> uniqueWords) {
        long startTime = System.currentTimeMillis();
        String[] store = new String[uniqueWords.size()];
        int i = 0;
        for(String word : uniqueWords) {
            store[i] = word;
            i++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time (ms) for Array: " + (endTime - startTime));
        return store;
    }

    public static ArrayList<String> toArrayList(Set<String> uniqueWords) {
        long startTime = System.currentTimeMillis();
        ArrayList<String> store = new ArrayList<>();
        for (String word : uniqueWords) {
            store.add(word);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time (ms) for Arraylist: " + (endTime - startTime));
        return store;
    }

    public static LinkedList<String> toLinkedList(Set<String> uniqueWords) {
        long startTime = System.currentTimeMillis();
        LinkedList<String> stored = new LinkedList<>(uniqueWords);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time (ms) for LinkedList: " + (endTime - startTime));
        return stored;
    }

}