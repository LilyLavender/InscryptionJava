package edu.wctc.Sigils;

public class SigilLeader implements Sigil {
    private String name = "Leader";
    private String effect = "Creatures adjacent to this card gain 1 Power.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
