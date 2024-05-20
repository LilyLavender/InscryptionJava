package edu.wctc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();
    private List<Card> tempDeck = new ArrayList<>();

    public void setDeck() {
        tempDeck.addAll(deck);
    }

    public void addToDeck(Card card) {
        deck.add(card);
    }

    public boolean removeFromDeck(int idToRemove) {
        Card card = deck.remove(idToRemove);
        return card != null;
    }

    public Card draw() {
        if (getTempDeckSize() > 0) {
            return tempDeck.remove(0);
        }
        return null;
    }

    public void shuffle() {
        Collections.shuffle(tempDeck);
    }

    public int getFullDeckSize() {
        return deck.size();
    }

    public int getTempDeckSize() {
        return tempDeck.size();
    }

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> getTempDeck() {
        return tempDeck;
    }
}
