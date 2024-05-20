package edu.wctc.Sigils;

public class SigilFledgling implements Sigil {
    private String name = "Fledgling";
    private String effect = "After surviving for 1 turn, this card grows into a stronger form.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
