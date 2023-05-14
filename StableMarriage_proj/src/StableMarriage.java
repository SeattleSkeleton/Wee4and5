import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class StableMarriage {
    public static void main(String[] args) throws FileNotFoundException {
        getPreferences();
    }

    public static void getPreferences() throws FileNotFoundException { // this method reads the text document for each person's preference list
        File file = new File("C:\\Users\\David\\IdeaProjects\\StableMarriage_proj\\Hopeless Romantics");
        Scanner scanner = new Scanner(file);
        int counter = 0;
        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                int next = scanner.nextInt();

                counter++;
                if(counter % numberOfPairs() == 0) {
                    System.out.print(next);
                    System.out.println();
                } else {
                    System.out.print(next + ", ");
                }
            } else {
                scanner.next();
            }
        }
    }
    public static int numberOfPairs() throws FileNotFoundException {

        /* This method finds the number of pairs of people in the text document.
           This allows us to have the `getPreferences()` method be flexible to the text document,
           so we don't have to change the code when we change the text document */

        File file = new File("C:\\Users\\David\\IdeaProjects\\StableMarriage_proj\\Hopeless Romantics");
        Scanner sc = new Scanner(file);

        int count = 0;

        while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }

        return (count - 1) / 2;
    }
    public static void createArray() throws FileNotFoundException {
        for(int i = 0; i < numberOfPairs(); i++) {

        }
    }
}
