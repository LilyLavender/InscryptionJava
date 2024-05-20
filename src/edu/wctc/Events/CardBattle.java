package edu.wctc.Events;

import edu.wctc.*;
import edu.wctc.Cost.CostFree;
import edu.wctc.Helper.Helper;
import edu.wctc.Power.Power;
import edu.wctc.Sigils.Sigil;
import edu.wctc.Tribes.TribeNone;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class CardBattle implements Event {
    private int score;
    private int playerBones;

    @Override
    public void commence(Player player, List<Card> allCards) {
        // Create playfield
        Playfield pf = new Playfield();

        // Create card displayer
        CardDisplayer cd = new CardDisplayer();

        // Ready deck
        player.readyDeck();

        // Add bone count
        playerBones += player.getStartingBoneCount();

        // Put squirrel + 2 from deck into hand
        player.drawSquirrel();
        player.draw();
        player.draw();

        // Have a chance of starting the game with an enemy card already in play
        Random rand = new Random();
        if (rand.nextInt(2) == 0) {
            int randIntSpot = rand.nextInt(4);
            int randIntCard = rand.nextInt(59);
            pf.addToPlayfield(allCards.get(randIntCard), 0, randIntSpot);
        }

        // Pre-battle text
        Main.soutForceEnter("A battle has begun!");

        // Main battle functionality
        while (true) {

            // Player plays cards
            boolean endAttackingPhase = false;
            while (!endAttackingPhase) {
                pf.displayPlayField(cd);
                if (player.getHandSize() > 0) {
                    System.out.println("Your hand: ");
                    cd.displayCards(player.getHand());
                    boolean correctCards = false;
                    do {
                        displayScale();
                        System.out.println("You have " + playerBones + " bone(s).");
                        System.out.println("Play a card by typing the number of the card and the number of the spot to place it in the format \"X-X\"");
                        System.out.println("End your turn with \"e\".");
                        String instruction = Helper.getString("", "Invalid input");
                        if (instruction.matches("^[1-9]+-[1-4]$")) {
                            String[] parts = instruction.split("-");
                            int part0 = Integer.parseInt(parts[0]) - 1;
                            int part1 = Integer.parseInt(parts[1]) - 1;
                            if (player.getHandSize() <= part0) {
                                System.out.println("Card " + (part0+1) + " does not exist.");
                            } else {
                                if (player.getHand().get(part0).getCostMethod().equals("Blood")) {
                                    int bloodCost = player.getHand().get(part0).getCost();
                                    System.out.println("To play that card, you need " + bloodCost + " sacrifice(s).");
                                    Card[][] playfield = pf.getPlayfield();
                                    boolean[] availableSacs = new boolean[4];
                                    for (int i = 0; i < 4; i++) {
                                        if (playfield[1][i].getTribeString() != "Pelt"
                                            && !playfield[1][i].getName().isEmpty()) {
                                            availableSacs[i] = true;
                                        } else {
                                            availableSacs[i] = false;
                                        }
                                    }

                                    List<Integer> availableSacIndexes = new ArrayList<>();
                                    for (int i = 0; i < availableSacs.length; i++) {
                                        if (availableSacs[i]) {
                                            availableSacIndexes.add(i);
                                        }
                                    }

                                    if (availableSacIndexes.size() >= bloodCost) {
                                        boolean correctSacs = false;
                                        while (!correctSacs) {
                                            System.out.println("List the numbers of the cards you wish to sacrifice in a comma-seperated list");
                                            String userSacNums = Helper.getString("", "Invalid input");
                                            String[] sacParts = userSacNums.split(",");
                                            List<Integer> indexesToSac = new ArrayList<>();
                                            for (int i = 0; i < sacParts.length; i++) {
                                                if (availableSacIndexes.indexOf(Integer.parseInt(sacParts[i])-1) != -1) {
                                                    indexesToSac.add(Integer.parseInt(sacParts[i])-1);
                                                }
                                            }
                                            if (indexesToSac.size() == sacParts.length) {
                                                if (pf.addToPlayfield(player.getHand().get(part0), 1, part1)) {
                                                    checkOnPlaySigils(player, part0, allCards);
                                                    player.removeFromHand(part0);
                                                    indexesToSac.stream().forEach(i -> {
                                                        playerBones += pf.getDyingBoneCount(1, i);
                                                        pf.removeFromPlayfield(1, i, false);
                                                    });
                                                    correctSacs = true;
                                                    correctCards = true;
                                                } else if (indexesToSac.contains(part1)) {
                                                    indexesToSac.stream().forEach(i -> {
                                                        playerBones += pf.getDyingBoneCount(1, i);
                                                        pf.removeFromPlayfield(1, i, false);
                                                    });
                                                    pf.addToPlayfield(player.getHand().get(part0), 1, part1);
                                                    checkOnPlaySigils(player, part0, allCards);
                                                    player.removeFromHand(part0);
                                                    correctSacs = true;
                                                    correctCards = true;
                                                } else {
                                                    System.out.println("There is already a card in that spot.");
                                                }
                                            } else {
                                                System.out.println("At least one index specified was incorrect");
                                            }
                                        }
                                    } else {
                                        System.out.println("You do not have enough sacrifices for that card.");
                                    }
                                } else if (player.getHand().get(part0).getCostMethod().equals("Bones")) {
                                    if (playerBones < player.getHand().get(part0).getCost()) {
                                        System.out.println("You do not have enough bones to play that card.");
                                    } else {
                                        if (pf.addToPlayfield(player.getHand().get(part0), 1, part1) ) {
                                            checkOnPlaySigils(player, part0, allCards);
                                            playerBones -= player.getHand().get(part0).getCost();
                                            player.removeFromHand(part0);
                                            correctCards = true;
                                        } else {
                                            System.out.println("There is already a card in that spot.");
                                        }
                                    }
                                } else {
                                    if (pf.addToPlayfield(player.getHand().get(part0), 1, part1) ) {
                                        checkOnPlaySigils(player, part0, allCards);
                                        player.removeFromHand(part0);
                                        correctCards = true;
                                    } else {
                                        System.out.println("There is already a card in that spot.");
                                    }
                                }
                            }
                        } else if (instruction.equals("e") || instruction.equals("E")) {
                            correctCards = true;
                            endAttackingPhase = true;
                        }
                    } while (!correctCards);

                } else {
                    System.out.println("Your hand is empty. End your turn with \"e\".");
                    Helper.getChar(true, new char[]{'e','E'}, "", "");
                    endAttackingPhase = true;
                }
            }

            // Player cards attack
            cardsAttack(pf, 1, 0);

            // Check scale
            if (score > 5) {
                System.out.println("The scale is over 5 points in your favor.");
                System.out.println("You have won.");
                if (score > 6) {
                    int overkill = score - 6;
                    System.out.println("You have earned " + overkill + " overkill.");
                    player.addToOverkill(overkill);
                }
                break;
            } else {
                displayScale();
            }

            // Enemy plays card(s)
            if (rand.nextInt(8) != 0) {
                int randIntSpot = rand.nextInt(4);
                int randIntCard = rand.nextInt(59);
                Card card = allCards.get(randIntCard);
                pf.addToPlayfield(card, 0, randIntSpot);
                System.out.println("The enemy plays " + card.getName());
            }

            // Enemy cards attack
            cardsAttack(pf, 0, 1);

            // Check scale
            if (score < -5) {
                System.out.println("The scale is over 5 points in the enemy's favor.");
                System.out.println("You have lost.");
                break;
            } else {
                displayScale();
            }

            // Draw card
            pf.displayPlayField(cd);
            System.out.println("Your hand: ");
            cd.displayCards(player.getHand());
            if (player.getDeckSize() > 0) {
                System.out.println("Draw a card with \"d\" or a squirrel with \"s\".");
                char userChar = Helper.getChar(true, new char[]{'d','D','s','S'}, "", "Invalid input.");
                if (userChar == 'd'
                || userChar == 'D') {
                    player.draw();
                } else {
                    player.drawSquirrel();
                }
            } else {
                System.out.println("Your deck is empty. Draw a squirrel with \"s\".");
                Helper.getChar(true, new char[]{'s','S'}, "", "Invalid input.");
                player.drawSquirrel();
            }
        }
    }

    private void cardsAttack(Playfield pf, int attackingRowNum, int defendingRowNum) {
        List<Card> attackingRow = pf.getPlayfieldRow(attackingRowNum);
        List<Card> defendingRow = pf.getPlayfieldRow(defendingRowNum);
        for (int i = 0; i < attackingRow.size(); i++) {
            Card attackingCard = attackingRow.get(i);
            Card defendingCard = defendingRow.get(i);
            if (!attackingCard.getName().isEmpty()
                    && attackingCard.getPowerMethod() != "X"
                    && attackingCard.getPower() != 0) {
                int cardDamage = attackingCard.getPower();
                if (attackingCard.getPowerMethod().equals("Ants")) {
                    cardDamage = 0;
                    for (int j = 0; j < attackingRow.size(); j++) {
                        if (attackingRow.get(j).getPowerMethod().equals("Ants")) {
                            cardDamage++;
                        }
                    }
                }
                if (defendingCard.getName().isEmpty()
                        || (attackingCard.hasSigil("Airborne") && !defendingCard.hasSigil("Mighty Leap"))
                        && cardDamage != 0
                        || (defendingCard.hasSigil("Waterborne"))) {
                    System.out.println(attackingCard.getName() + " deals " + cardDamage + " direct damage.");
                    if (attackingRowNum == 1) {
                        score += cardDamage;
                    } else {
                        score -= cardDamage;
                    }
                } else {
                    defendingCard.subtractCurrHealth(cardDamage);
                    if (defendingCard.getCurrHealth() <= 0) {
                        pf.removeFromPlayfield(defendingRowNum, i, true);
                        if (defendingRowNum == 1) {
                            playerBones += pf.getDyingBoneCount(1, i);
                        }
                    }
                    System.out.println(attackingCard.getName() + " deals " + cardDamage + " damage to the " + defendingCard.getName() + ".");
                }
            }
        }
    }

    private void displayScale() {
        if (score > 0) {
            System.out.println("The scale is " + score + " point(s) in your favor.");
        } else if (score < 0) {
            System.out.println("The scale is " + Math.abs(score) + " point(s) in the enemy's favor.");
        } else {
            System.out.println("The scale is even.");
        }
    }

    private void checkOnPlaySigils(Player player, int part0, List<Card> allCards) {
        Card card = player.getHand().get(part0);
        if (card.hasSigil("Ant Spawner")) {
            System.out.println(card.getName() + " added an ant to your hand.");
            player.addToHand(allCards.get(26));
        }
        if (card.hasSigil("Rabbit hole")) {
            System.out.println(card.getName() + " added a rabbit to your hand.");
            player.addToHand(new Card("Rabbit", new Power(0), 1, new CostFree(), new TribeNone(), new ArrayList<>()));
        }
        if (card.hasSigil("Fecundity")) {
            System.out.println(card.getName() + " added a copy of itself to your hand.");
            player.addToHand(card);
        }
    }
}
