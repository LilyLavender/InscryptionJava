package edu.wctc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    private List<Card> hand = new ArrayList<>();

    public Hand() {

    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public boolean removeFromHand(int idToRemove) {
        Card card = hand.remove(idToRemove);
        return card != null;
    }

    public int getHandSize() {
        return hand.size();
    }


    public List<Card> getHand() {
        return hand;
    }
}
