package edu.wctc.Sigils;

public class SigilGuardian implements Sigil {
    private String name = "Guardian";
    private String effect = "When an opposing card is played opposite an empty space, this card moves to that space.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
