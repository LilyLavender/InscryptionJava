package edu.wctc.Sigils;

public class SigilBeesWithin implements Sigil {
    private String name = "Bees Within";
    private String effect = "When this card is struck, a Bee is created in your hand.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
