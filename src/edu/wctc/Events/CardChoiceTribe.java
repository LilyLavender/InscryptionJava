package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.Helper.Helper;
import edu.wctc.Main;
import edu.wctc.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardChoiceTribe extends CardChoice {
    @Override
    public void commence(Player player, List<Card> allCards) {
        Main.soutForceEnter("You find three obscured cards. You can only see their tribes.");
        Main.soutForceEnter("Choose one to keep.");

        Random rand = new Random();
        Card card1 = allCards.get(rand.nextInt(59));
        while (card1.getTribeString().equals("Pelt")
        || card1.getTribeString().isEmpty()) {
            card1 = allCards.get(rand.nextInt(59));
        }
        Card card2 = allCards.get(rand.nextInt(59));
        while (card1.getTribeString() == card2.getTribeString()
                || card2.getTribeString().equals("Pelt")
                || card2.getTribeString().isEmpty()) {
            card2 = allCards.get(rand.nextInt(59));
        }
        Card card3 = allCards.get(rand.nextInt(59));
        while (card3.getTribeString() == card2.getTribeString()
                || card3.getTribeString() == card1.getTribeString()
                || card3.getTribeString().equals("Pelt")
                || card3.getTribeString().isEmpty()) {
            card3 = allCards.get(rand.nextInt(59));
        }

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        System.out.println("1) Choose the " + card1.getTribeString() + "\n");
        System.out.println("2) Choose the " + card2.getTribeString() + "\n");
        System.out.println("3) Choose the " + card3.getTribeString() + "\n");
        int userChoice = Helper.getInt(true, 1, 3, "", "Invalid choice.");
        player.addToDeck(cards.get(userChoice-1));

        Main.soutForceEnter("You picked up the " + cards.get(userChoice-1).getName() + " and moved on.");
    }
}
