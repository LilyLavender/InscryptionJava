package edu.wctc.Sigils;

public class SigilBifurcatedStrike implements Sigil {
    private String name = "Bifurcated Strike";
    private String effect = "This card will strike each opposing space to the left and right of the spaces across it.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
