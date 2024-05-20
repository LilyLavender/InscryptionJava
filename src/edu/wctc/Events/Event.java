package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.Player;

import java.util.List;

public interface Event {
    void commence(Player player, List<Card> allCards);
}
