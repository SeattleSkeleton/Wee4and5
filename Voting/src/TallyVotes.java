// By Malaya Jove, Matthew Ryan, Jungsol Lee, David Mason

import java.util.*;
import java.io.*;

public class TallyVotes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("vote3.txt"));
        ArrayList<Ballot> ballots = readFile(input);
        int round = 1;
        boolean done = false;
        while (!done) {
            System.out.println("Round #" + round);
            Collections.sort(ballots);
            done = oneRound(ballots);
            System.out.println("-----------------------------");
            round++;
        }
    }

    public static ArrayList<Ballot> readFile(Scanner input) {
        ArrayList<Ballot> result = new ArrayList<Ballot>();
        while (input.hasNextLine()) {
            String text = input.nextLine();
            if (text.isEmpty()) { //added test to make sure it's not a blank line from abstain voting

            } else {
                result.add(new Ballot(text.split("\t")));
            }
        }
        return result;
    }

    public static boolean oneRound(ArrayList<Ballot> ballots) {
        String top = null;
        String bottom = null;
        int topCount = 0;
        int bottomCount = ballots.size() + 1;
        int index = 0;
        while(index < ballots.size()) {
            String next = ballots.get(index).getCandidate();
            int count = processVotes(next, index, ballots);
            if (count > topCount) {
                topCount = count;
                top = next;
            }
            if (count < bottomCount) {
                bottomCount = count;
                bottom = next;
            }
            index += count;
        }
        if (topCount == bottomCount) {
            System.out.println("Election has no winner");
            return true;
        } else if (topCount > ballots.size() / 2) {
            System.out.println("Winner is " + top);
            return true;
        } else {
            System.out.println("No winner, eliminating " + bottom);
            eliminate(bottom, ballots);
            return false;
        }
    }

    public static int processVotes(String name, int index, ArrayList<Ballot> ballots) {
        int count = 0;
        while (index < ballots.size() && ballots.get(index).getCandidate().equals(name)) {
            index++;
            count++;
        }
        double percent = 100.0 * count / ballots.size();
        System.out.printf("%d votes for %s (%4.1f%%)\n", count, name, percent);
        return count;
    }

    public static void eliminate(String candidate, ArrayList<Ballot> ballots) {
        for (Ballot b: ballots) {
            b.eliminate(candidate);
            if (b.isEmpty()) {//added section that removes a single ballot from the array of all ballots if it is empty
                ballots.remove(b);
            }
        }
    }
}