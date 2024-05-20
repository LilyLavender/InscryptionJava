package edu.wctc.Sigils;

public class SigilSprinter implements Sigil {
    private String name = "Sprinter";
    private String effect = "At the end of the owner's turn, this card moves in the sigil's direction.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
