import java.util.ArrayList;

public class ListMethods {
    public static void removeDuplicates(ArrayList<String> L1) {
        for (int i = 0; i < L1.size(); i++) {
            if (L1.indexOf(L1.get(i)) != L1.lastIndexOf(L1.get(i))) {
                L1.remove(L1.lastIndexOf(L1.get(i)));
                i--;
            }
        }
    }

    public static void interleave(ArrayList<Integer> a1, ArrayList<Integer> a2) {
        int times = Math.min(a1.size(), a2.size()); //figures out which list is smaller and makes that length int times
        int i;

        for (i = 0; i < times; i++) { //for loop that operates for every value in the shorter list
            int num = a2.get(i); //gets values from second list
            a1.add(2 * i + 1, num); //2 * i + 1 skips every other value starting at 1
            //numbers from second list added to first list at indexes 1, 3, 5, and so on
        }

        if (i < a2.size()) { //adds any leftover values in list 2 to list 1
            for (int j = i; j < a2.size(); j++) {
                a1.add(a2.get(j));
            }
        }
    }
}
