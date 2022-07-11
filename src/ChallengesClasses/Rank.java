package ChallengesClasses;

import java.util.ArrayList;
import java.util.Random;

public class Rank<T> {

    private ArrayList<T> items;
    public ArrayList<T> rankedTodos = new ArrayList<>();

    public Rank(ArrayList<T> items) {
        this.items = items;
        rank();
    }

    private void rank() {

        while (true) {
            int randomIndex = new Random().nextInt(this.items.size());

            rankedTodos.add(this.items.get(randomIndex));

            this.items.remove(randomIndex);

            if (this.items.size() == 0) {
                break;
            }
        }
    }
}
