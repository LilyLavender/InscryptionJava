package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.CardDisplayer;
import edu.wctc.Helper.Helper;
import edu.wctc.Main;
import edu.wctc.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardChoiceDefault extends CardChoice {
    @Override
    public void commence(Player player, List<Card> allCards) {
        Main.soutForceEnter("You have reached a clearing, where three cards lay.");
        Main.soutForceEnter("Choose one to keep.");

        Random rand = new Random();
        int card1num = rand.nextInt(59);
        int card2num = rand.nextInt(59);
        while (card1num == card2num) {
            card2num = rand.nextInt(59);
        }
        int card3num = rand.nextInt(59);
        while (card3num == card2num || card3num == card1num) {
            card3num = rand.nextInt(59);
        }

        List<Card> cards = new ArrayList<>();
        cards.add(allCards.get(card1num));
        cards.add(allCards.get(card2num));
        cards.add(allCards.get(card3num));

        CardDisplayer cd = new CardDisplayer();
        cd.displayCards(cards);
        System.out.println("1) Choose the " + cards.get(0).getName() + "\n2) Choose the " + cards.get(1).getName() + "\n3) Choose the " + cards.get(2).getName() + "\n");
        int userChoice = Helper.getInt(true, 1, 3, "", "Invalid choice.");
        player.addToDeck(cards.get(userChoice-1));

        Main.soutForceEnter("You picked up the " + cards.get(userChoice-1).getName() + " and moved on.");
    }
}
