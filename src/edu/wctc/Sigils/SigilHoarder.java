package edu.wctc.Sigils;

public class SigilHoarder implements Sigil {
    private String name = "Hoarder";
    private String effect = "When this card is played, choose a card from your deck to be drawn immediately.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
