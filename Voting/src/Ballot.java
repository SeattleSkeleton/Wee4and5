import java.util.*;
public class Ballot implements Comparable<Ballot>{
    private ArrayList<String> preferences;

    public Ballot(String[] names) {
        preferences = new ArrayList<>();
        for (String next: names) {
            preferences.add(next);
        }
    }

    public String getCandidate() {
        if (preferences.isEmpty()) {
            return "none";
        } else {
            return preferences.get(0);
        }
    }

    public void eliminate(String name) {
        preferences.remove(name);
    }

    public int compareTo(Ballot other) {
        return getCandidate().compareTo(other.getCandidate());
    }

    public boolean isEmpty() { //added isEmpty method
        if (preferences.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
