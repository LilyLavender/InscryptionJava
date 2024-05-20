package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Playfield {
    private Card[][] playfield = new Card[2][4];

    public Playfield() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                playfield[i][j] = new BlankCard();
            }
        }
    }

    public Card[][] getPlayfield() {
        return playfield;
    }

    public List<Card> getPlayfieldRow(int r) {
        if (r >= 0 && r <= 1) {
            List<Card> row = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                row.add(playfield[r][i]);
            }
            return row;
        } else {
            return null;
        }
    }

    public void displayPlayField(CardDisplayer cd) {
        for (int i = 0; i < 2; i++) {
            List<Card> fieldRow = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                fieldRow.add(playfield[i][j]);
            }
            cd.displayCards(fieldRow);
        }
    }

    public boolean addToPlayfield(Card card, int r, int c) {
        if (playfield[r][c].getName().isEmpty()) {
            playfield[r][c] = card;
            return true;
        }
        return false;
    }

    // killed bool is to differentiate from sacrificing and killing, for sigil stuff
    public boolean removeFromPlayfield(int r, int c, boolean killed) {
        if (!playfield[r][c].getName().isEmpty()) {
            playfield[r][c] = new BlankCard();
            return true;
        }
        return false;
    }

    public int getDyingBoneCount(int r, int c) {
        if (!playfield[r][c].getName().isEmpty()) {
            if (r == 1) {
                return playfield[r][c].getDyingBoneCount();
            }
        }
        return 0;
    }
}
