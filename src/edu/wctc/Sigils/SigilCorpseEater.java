package edu.wctc.Sigils;

public class SigilCorpseEater implements Sigil {
    private String name = "Corpse Eater";
    private String effect = "If a card that you own dies by combat, this card is played from your hand on its space.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
