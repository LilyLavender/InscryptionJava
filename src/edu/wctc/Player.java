package edu.wctc;

import edu.wctc.Cost.CostFree;
import edu.wctc.Power.Power;
import edu.wctc.Tribes.TribeNone;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Deck deck = new Deck();
    private Hand hand = new Hand();
    private int startingBoneCount;
    private int overkill;

    private static Player instance;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    public Player() {
        startingBoneCount = 0;
    }

    public void addToBoneCount(int bones) {
        startingBoneCount += bones;
    }

    public void addToOverkill(int overkillToAdd) {
        overkill += overkillToAdd;
    }

    public List<Card> getDeck() {
        return deck.getDeck();
    }

    public void draw() {
        hand.addToHand(deck.draw());
    }

    public void drawSquirrel() {
        hand.addToHand(new Card("Squirrel", new Power(0), 1, new CostFree(), new TribeNone(), new ArrayList<>()));
    }

    public List<Card> getHand() {
        return hand.getHand();
    }

    public void readyDeck() {
        deck.setDeck();
        deck.shuffle();
    }

    public void addToDeck(Card card) {
        deck.addToDeck(card);
    }

    public void addToHand(Card card) {
        hand.addToHand(card);
    }

    public int getHandSize() {
        return hand.getHandSize();
    }

    public int getDeckSize() {
        return deck.getTempDeckSize();
    }

    public int getFullDeckSize() {
        return deck.getFullDeckSize();
    }

    public boolean removeFromHand(int idToRemove) {
        return hand.removeFromHand(idToRemove);
    }

    public int getStartingBoneCount() {
        return startingBoneCount;
    }

    public boolean removeFromDeck(int idToRemove) {
        return deck.removeFromDeck(idToRemove);
    }
}
