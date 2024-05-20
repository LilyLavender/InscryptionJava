package edu.wctc.Events;

import edu.wctc.Card;
import edu.wctc.CardDisplayer;
import edu.wctc.Helper.Helper;
import edu.wctc.Main;
import edu.wctc.Player;

import java.util.List;
import java.util.Random;

public class Campfire implements Event {
    @Override
    public void commence(Player player, List<Card> allCards) {
        Random rand = new Random();
        CardDisplayer cd = new CardDisplayer();

        int campfireType = rand.nextInt(2);
        String campfireBuffString = campfireType == 0 ? "power" : "health";
        int campfireBuffInt = campfireType == 0 ? 1 : 2;

        Main.soutForceEnter("You came across a small group of survivors. Faces shrunken from starvation, they huddled around a campfire.");
        Main.soutForceEnter("You can warm a creature up by the fire to increase its " + campfireBuffString + " by " + campfireBuffInt + ", at a risk...");

        System.out.println("Your deck: ");
        cd.displayCards(player.getDeck());
        System.out.println("Choose the number of a creature to warm, or 0 to leave.");

        int creatureToWarmInt = Helper.getInt(true, 0, player.getFullDeckSize(), "", "Invalid number.");
        if (creatureToWarmInt == 0) {
            Main.soutForceEnter("You decided not to risk it this time..");
            return;
        } else {
            Card creature = player.getDeck().get(creatureToWarmInt-1);
            if (campfireType == 0) {
                creature.addPower(campfireBuffInt);
            } else {
                creature.addHealth(campfireBuffInt);
            }
            Main.soutForceEnter("Your " + creature.getName() + " had its " + campfireBuffString + " increased by " + campfireBuffInt);
            Main.soutForceEnter("The survivors licked their lips. Risk it again? (y/n)");
            char userRiskAgainChar = Helper.getChar(true, new char[]{'n','N','y','Y'}, "", "Invalid choice");
            if (userRiskAgainChar == 'n' || userRiskAgainChar == 'N') {
                Main.soutForceEnter("You snatched the " + creature.getName() + " up and ran away.");
                return;
            } else {
                if (rand.nextInt(2) == 0) {
                    Main.soutForceEnter("The survivors pounced, and devoured the " + creature.getName());
                    player.removeFromDeck(creatureToWarmInt);
                } else {
                    if (campfireType == 0) {
                        creature.addPower(campfireBuffInt);
                    } else {
                        creature.addHealth(campfireBuffInt);
                    }
                    Main.soutForceEnter("Your " + creature.getName() + " had its " + campfireBuffString + " increased by " + campfireBuffInt);
                    Main.soutForceEnter("You ran away without risking it again.");
                }
            }
        }
    }
}
