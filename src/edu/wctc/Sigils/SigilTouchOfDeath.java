package edu.wctc.Sigils;

public class SigilTouchOfDeath implements Sigil {
    private String name = "Touch of Death";
    private String effect = "This card instantly kills any card it damages.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
