package edu.wctc.Sigils;

public class SigilFecundity implements Sigil {
    private String name = "Fecundity";
    private String effect = "When this card is played, a copy of it enters your hand.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
