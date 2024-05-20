package edu.wctc.Sigils;

public class SigilTrifurcatedStrike implements Sigil {
    private String name = "Trifurcated Strike";
    private String effect = "This card will deal damage to the opposing spaces left, right, and opposite of it.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
