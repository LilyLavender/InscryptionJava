package edu.wctc;

import edu.wctc.Cost.CostBlood;
import edu.wctc.Cost.CostBones;
import edu.wctc.Cost.CostFree;
import edu.wctc.Cost.CostMethod;
import edu.wctc.Power.Power;
import edu.wctc.Power.PowerAnt;
import edu.wctc.Power.PowerMethod;
import edu.wctc.Power.PowerNone;
import edu.wctc.Sigils.*;
import edu.wctc.Tribes.*;

import java.util.ArrayList;
import java.util.List;

public class DefaultCardsCreator {

    private static DefaultCardsCreator instance;

    private DefaultCardsCreator() {
    }

    public static DefaultCardsCreator getInstance() {
        if (instance == null) {
            instance = new DefaultCardsCreator();
        }
        return instance;
    }

    public List<Card> createCards() {
        List<Card> cardList = new ArrayList<>();

        Object[][] cardData = {
                {"Kingfisher", 1, 1, new CostBlood(1), new TribeAvian(), new SigilAirborne(), new SigilWaterborne()},
                {"Raven Egg", 0, 2, new CostBlood(1), new TribeAvian(), new SigilFledgling()},
                {"Sparrow", 1, 2, new CostBlood(1), new TribeAvian(), new SigilAirborne()},
                {"Magpie", 1, 1, new CostBlood(2), new TribeAvian(), new SigilAirborne(), new SigilHoarder()},
                {"Raven", 2, 3, new CostBlood(2), new TribeAvian(), new SigilAirborne()},
                {"Turkey Vulture", 3, 3, new CostBones(8), new TribeAvian(), new SigilAirborne()},
                {"Stunted Wolf", 2, 2, new CostBlood(1), new TribeCanine()},
                {"Wolf Cub", 1, 1, new CostBlood(1), new TribeCanine(), new SigilFledgling()},
                {"Bloodhound", 2, 3, new CostBlood(2), new TribeCanine(), new SigilGuardian()},
                {"Caged Wolf", new PowerNone(), 6, new CostBlood(2), new TribeCanine()},
                {"Wolf", 3, 2, new CostBlood(2), new TribeCanine()},
                {"Coyote", 2, 1, new CostBones(4), new TribeCanine()},
                {"Alpha", 1, 2, new CostBones(4), new TribeCanine(), new SigilLeader()},
                {"Child 13", 0, 1, new CostBlood(1), new TribeHooved(), new SigilManyLives()},
                {"Long Elk", 1, 2, new CostBones(4), new TribeHooved(), new SigilSprinter(), new SigilTouchOfDeath()},
                {"Black Goat", 0, 1, new CostBlood(1), new TribeHooved(), new SigilWorthySacrifice()},
                {"Elk Fawn", 1, 1, new CostBlood(1), new TribeHooved(), new SigilFledgling(), new SigilSprinter()},
                {"Elk", 2, 4, new CostBlood(2), new TribeHooved(), new SigilSprinter()},
                {"Pronghorn", 1, 3, new CostBlood(2), new TribeHooved(), new SigilSprinter(), new SigilBifurcatedStrike()},
                {"Moose Buck", 3, 7, new CostBlood(3), new TribeHooved(), new SigilHefty()},
                {"Mantis God", 1, 1, new CostBlood(1), new TribeInsect(), new SigilTrifurcatedStrike()},
                {"Strange Larva", 0, 3, new CostBlood(1), new TribeInsect(), new SigilFledgling()},
                {"Bee", 1, 1, new CostFree(), new TribeInsect(), new SigilAirborne()},
                {"Beehive", 0, 2, new CostBlood(1), new TribeInsect(), new SigilBeesWithin()},
                {"Mantis", 1, 1, new CostBlood(1), new TribeInsect(), new SigilBifurcatedStrike()},
                {"Ring Worm", 0, 1, new CostBlood(1), new TribeInsect()},
                {"Worker Ant", new PowerAnt(), 2, new CostBlood(1), new TribeInsect()},
                {"Ant Queen", new PowerAnt(), 1, new CostBlood(2), new TribeInsect(), new SigilAntSpawner()},
                {"Stinkbug", 1, 2, new CostBones(2), new TribeInsect(), new SigilStinky()},
                {"Cockroach", 1, 1, new CostBones(4), new TribeInsect(), new SigilUnkillable()},
                {"Corpse Maggots", 1, 2, new CostBones(5), new TribeInsect(), new SigilCorpseEater()},
                {"Geck", 1, 1, new CostFree(), new TribeReptile()},
                {"Ouroboros", 1, 1, new CostBlood(2), new TribeReptile(), new SigilUnkillable()},
                {"Bullfrog", 1, 2, new CostBlood(1), new TribeReptile(), new SigilMightyLeap()},
                {"Skink", 1, 2, new CostBlood(1), new TribeReptile(), new SigilLooseTail()},
                {"Adder", 1, 1, new CostBlood(2), new TribeReptile(), new SigilTouchOfDeath()},
                {"River Snapper", 1, 6, new CostBlood(2), new TribeReptile()},
                {"Rattler", 3, 1, new CostBones(6), new TribeReptile()},
                {"Rabbit Pelt", new PowerNone(), 1, new CostFree(), new TribePelt()},
                {"Wolf Pelt", new PowerNone(), 2, new CostFree(), new TribePelt()},
                {"Golden Pelt", new PowerNone(), 3, new CostFree(), new TribePelt()},
                {"Mole Man", 0, 6, new CostBlood(1), new TribeNone(), new SigilMightyLeap(), new SigilBurrower()},
                {"The Daus", 2, 2, new CostBlood(2), new TribeNone(), new SigilBellist()},
                {"Urayuli", 7, 7, new CostBlood(4), new TribeNone()},
                {"Squirrel", 0, 1, new CostFree(), new TribeNone()},
                {"Cat", 0, 1, new CostBlood(1), new TribeNone(), new SigilManyLives()},
                {"Mole", 0, 4, new CostBlood(1), new TribeNone(), new SigilBurrower()},
                {"Porcupine", 1, 2, new CostBlood(1), new TribeNone(), new SigilSharpQuills()},
                {"River Otter", 1, 1, new CostBlood(1), new TribeNone(), new SigilWaterborne()},
                {"Skunk", 0, 3, new CostBlood(1), new TribeNone(), new SigilStinky()},
                {"Stoat", 1, 3, new CostBlood(1), new TribeNone()},
                {"Warren", 0, 2, new CostBlood(1), new TribeNone(), new SigilRabbitHole()},
                {"Beaver", 1, 3, new CostBlood(2), new TribeNone(), new SigilDamBuilder()},
                {"Field Mice", 2, 2, new CostBlood(2), new TribeNone(), new SigilFecundity()},
                {"Rat King", 2, 1, new CostBlood(2), new TribeNone(), new SigilBoneKing()},
                {"Great White", 4, 2, new CostBlood(3), new TribeNone(), new SigilWaterborne()},
                {"Grizzly", 4, 6, new CostBlood(3), new TribeNone()},
                {"Oppossum", 1, 1, new CostBones(2), new TribeNone()},
                {"Bat", 2, 1, new CostBones(4), new TribeNone(), new SigilAirborne()}
        };

        // Add every card from cardData to cardList
        for (Object[] data : cardData) {
            String name = (String) data[0];
            PowerMethod power = data[1].getClass().getName().toString() == "java.lang.Integer" ? new Power((int)data[1]) : (PowerMethod) data[1];
            int health = (int) data[2];
            CostMethod cost = (CostMethod) data[3];
            Tribe tribe = (Tribe) data[4];
            List<Sigil> sigils = new ArrayList<>();
            for (int i = 5; i < data.length; i++) {
                if (data[i] instanceof Sigil) {
                    sigils.add((Sigil) data[i]);
                }
            }
            Card card = new Card(name, power, health, cost, tribe, sigils);
            cardList.add(card);
        }

        return cardList;
    }
}
