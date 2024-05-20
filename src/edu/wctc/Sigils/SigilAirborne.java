package edu.wctc.Sigils;

public class SigilAirborne implements Sigil {
    private String name = "Airborne";
    private String effect = "This card will ignore opposing cards and strike an opponent directly.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
