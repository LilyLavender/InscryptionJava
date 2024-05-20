package edu.wctc.Sigils;

public class SigilDamBuilder implements Sigil {
    private String name = "Dam Builder";
    private String effect = "When this card is played, Dams are created on adjacent empty spaces.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
