package edu.wctc;

import edu.wctc.Events.*;
import edu.wctc.Helper.Helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    private List<Event> events = new ArrayList<>();
    private int currentEvent;

    private static Game instance;

    private Game(Player player) {
        DefaultCardsCreator dcc = DefaultCardsCreator.getInstance();
        List<Card> allCards = dcc.createCards();

        playIntro();

        givePlayerStartingDeck(player, allCards);

        events.addAll(Arrays.asList(
                new CardChoiceDefault(),
                new CardChoiceCost(),
                new CardBattle(),
                new Campfire(),
                new CardChoiceTribe(),
                new CardBattle()
                //new BuyPelts(),
                //new MysteriousStones(),
                //new CardBattle(),
                //new TradePelts(),
                //new BoneAltar(),
                //new CardBattle()
        ));

        for (Event event : events) {
            event.commence(player, allCards);
        }
    }

    public static Game getInstance(Player player) {
        if (instance == null) {
            instance = new Game(player);
        }
        return instance;
    }

    private void playIntro() {
        Main.soutForceEnter("Hello player, welcome to Inscryption.");
    }

    public void givePlayerStartingDeck(Player player, List<Card> allCards) {
        CardDisplayer cd = new CardDisplayer();

        Main.soutForceEnter("Let's get you a starting deck");
        Main.soutForceEnter("Tell me if any of these catch your eye");

        // Vanilla deck
        displayThree(cd, allCards, 50, 33, 10);
        Main.soutForceEnter("The vanilla deck.. great for beginners.");
        // Ant deck
        displayThree(cd, allCards, 26, 27, 51);
        Main.soutForceEnter("The ant deck. An unusual deck for experimental people.");
        // Bone deck
        displayThree(cd, allCards, 28, 11, 54);
        Main.soutForceEnter("The bone deck, for those who want to explore the game deeper.");

        Main.soutForceEnter("So what'd'ya say? Which creatures shall accompany you on your journey?");
        System.out.println("1) Choose the vanilla deck\n2) Choose the ant deck\n3) Choose the bone deck\n");

        int userDeckInt = Helper.getInt(true, 1, 3, "", "That's not a deck number, try again, pal.");
        switch (userDeckInt) {
            case 1 -> { addToPlayerDeck(player, new ArrayList<Card>(Arrays.asList(allCards.get(50), allCards.get(33), allCards.get(10)))); }
            case 2 -> { addToPlayerDeck(player, new ArrayList<Card>(Arrays.asList(allCards.get(26), allCards.get(27), allCards.get(51)))); }
            case 3 -> { addToPlayerDeck(player, new ArrayList<Card>(Arrays.asList(allCards.get(28), allCards.get(11), allCards.get(54)))); }
        }

        displayPlayerDeck(cd, player);

        Main.soutForceEnter("Now, let's begin.");
    }

    public void addToPlayerDeck(Player player, List<Card> cardsToAdd) {
        cardsToAdd.forEach(card -> player.addToDeck(card));
    }

    public void displayPlayerDeck(CardDisplayer cd, Player player) {
        System.out.println("Your deck: ");
        cd.displayCards(player.getDeck());
        Main.soutForceEnter("");
    }

    public void displayThree(CardDisplayer cd, List<Card> allCards, int id1, int id2, int id3) {
        List<Card> cards = new ArrayList<>();
        cards.add(allCards.get(id1));
        cards.add(allCards.get(id2));
        cards.add(allCards.get(id3));
        cd.displayCards(cards);
    }
}
