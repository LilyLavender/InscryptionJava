package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.CardDisplayer;
import edu.wctc.Helper.Helper;
import edu.wctc.Main;
import edu.wctc.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardChoiceCost extends CardChoice {
    @Override
    public void commence(Player player, List<Card> allCards) {
        Main.soutForceEnter("You find three obscured cards. You can only see their costs.");
        Main.soutForceEnter("Choose one to keep.");

        Random rand = new Random();
        Card card1 = allCards.get(rand.nextInt(59));
        Card card2 = allCards.get(rand.nextInt(59));
        while (card1.getCost() == card2.getCost()
                && card1.getCostMethod().equals(card2.getCostMethod())) {
            card2 = allCards.get(rand.nextInt(59));
        }
        Card card3 = allCards.get(rand.nextInt(59));
        while ((card3.getCost() == card2.getCost()
                && card3.getCostMethod().equals(card2.getCostMethod()))
                || (card3.getCost() == card1.getCost()
                && card3.getCostMethod().equals(card3.getCostMethod()))) {
            card3 = allCards.get(rand.nextInt(59));
        }

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        cards.add(card3);

        if (!card1.getCostMethod().equals("Free")) {
            System.out.println("1) Choose the " + card1.getCost() + " " + card1.getCostMethod() + "\n");
        } else {
            System.out.println("1) Choose the free card\n");
        }
        if (!card2.getCostMethod().equals("Free")) {
            System.out.println("2) Choose the " + card2.getCost() + " " + card2.getCostMethod() + "\n");
        } else {
            System.out.println("2) Choose the free card\n");
        }
        if (!card3.getCostMethod().equals("Free")) {
            System.out.println("3) Choose the " + card3.getCost() + " " + card3.getCostMethod() + "\n");
        } else {
            System.out.println("3) Choose the free card\n");
        }

        int userChoice = Helper.getInt(true, 1, 3, "", "Invalid choice.");
        player.addToDeck(cards.get(userChoice-1));

        Main.soutForceEnter("You picked up the " + cards.get(userChoice-1).getName() + " and moved on.");
    }
}
