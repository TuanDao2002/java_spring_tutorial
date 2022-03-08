package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deal {
    private final ArrayList<String> cards;
    private final ArrayList<String> suits;

    public Deal() {
        cards = new ArrayList<>(Arrays.asList("Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"));
        suits = new ArrayList<>(Arrays.asList("club", "diamond", "heart", "spade"));
    }

    public String getCard() {
        Collections.shuffle(cards);
        Collections.shuffle(suits);

        return cards.get(0) + " of " + suits.get(0);
    }
}
