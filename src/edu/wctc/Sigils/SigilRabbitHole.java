package edu.wctc.Sigils;

public class SigilRabbitHole implements Sigil {
    private String name = "Rabbit Hole";
    private String effect = "When this card is played, a Rabbit is created in your hand.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
