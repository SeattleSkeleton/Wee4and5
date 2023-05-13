import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> run = new ArrayList<>(List.of("be", "be", "is", "not", "or",
                "question", "that", "the", "to", "to"));
        ListMethods.removeDuplicates(run);
        System.out.println(run);
        ArrayList<String> run2 = new ArrayList<>();
        ListMethods.removeDuplicates(run2);
        System.out.println(run2);

        ArrayList<Integer> run3 = new ArrayList<>(List.of(10, 20 , 30 ));
        ArrayList<Integer> run4 = new ArrayList<>(List.of(6, 7, 8, 9, 10, 11));
        ListMethods.interleave(run3, run4);
        System.out.println(run3);
    }
}