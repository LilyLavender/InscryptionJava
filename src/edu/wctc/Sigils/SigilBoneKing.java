package edu.wctc.Sigils;

public class SigilBoneKing implements Sigil {
    private String name = "Bone King";
    private String effect = "When this card dies, 4 Bones are awarded instead of 1.";

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }
}
