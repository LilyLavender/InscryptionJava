package edu.wctc.Sigils;

public class SigilWaterborne implements Sigil {
    private String name = "Waterborne";
    private String effect = "On the opponent's turn, creatures attacking this card's space attack directly.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
