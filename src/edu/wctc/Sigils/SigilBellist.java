package edu.wctc.Sigils;

public class SigilBellist implements Sigil {
    private String name = "Bellist";
    private String effect = "When this card is played, Chimes are created on adjacent empty spaces.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
