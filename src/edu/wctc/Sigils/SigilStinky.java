package edu.wctc.Sigils;

public class SigilStinky implements Sigil {
    private String name = "Stinky";
    private String effect = "The creature opposing this card loses 1 Power.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
