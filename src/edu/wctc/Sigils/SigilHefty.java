package edu.wctc.Sigils;

public class SigilHefty implements Sigil {
    private String name = "Hefty";
    private String effect = "At the end of the owner's turn, this and adjacent cards move in the sigil's direction.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
