package edu.wctc.Sigils;

public class SigilManyLives implements Sigil {
    private String name = "Many Lives";
    private String effect = "When this card is sacrificed, it does not perish.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
