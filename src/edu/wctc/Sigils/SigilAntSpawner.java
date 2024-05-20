package edu.wctc.Sigils;

public class SigilAntSpawner implements Sigil {
    private String name = "Ant Spawner";
    private String effect = "When this card is played, an Ant enters your hand.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
