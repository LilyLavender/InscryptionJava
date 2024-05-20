package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.Player;

import java.util.List;

public abstract class CardChoice implements Event {
    @Override
    public void commence(Player player, List<Card> allCards) {

    }
}
