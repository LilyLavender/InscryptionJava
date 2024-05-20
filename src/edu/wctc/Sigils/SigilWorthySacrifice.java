package edu.wctc.Sigils;

public class SigilWorthySacrifice implements Sigil {
    private String name = "Worthy Sacrifice";
    private String effect = "This card counts as 3 Blood rather than 1 Blood when sacrificed.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
