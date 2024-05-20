package edu.wctc.Sigils;

public class SigilLooseTail implements Sigil {
    private String name = "Loose Tail";
    private String effect = "When this card would be struck, a tail is created in its place and this card moves to the right.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
