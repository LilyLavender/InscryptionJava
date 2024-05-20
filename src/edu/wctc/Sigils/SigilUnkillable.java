package edu.wctc.Sigils;

public class SigilUnkillable implements Sigil {
    private String name = "Unkillable";
    private String effect = "When this card perishes, a copy of it enters your hand.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
