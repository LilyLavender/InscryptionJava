package edu.wctc.Sigils;

public class SigilBurrower implements Sigil {
    private String name = "Burrower";
    private String effect = "This card will move to any empty space that is attacked by an enemy to block it.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
