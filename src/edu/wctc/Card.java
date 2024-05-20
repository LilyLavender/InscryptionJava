package edu.wctc;

import edu.wctc.Cost.CostMethod;
import edu.wctc.Power.PowerMethod;
import edu.wctc.Sigils.Sigil;
import edu.wctc.Tribes.Tribe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Card {
    private String name;
    private PowerMethod power;
    private int health;
    private int currHealth;
    private CostMethod cost;
    private List<Sigil> sigils = new ArrayList<>();
    private Tribe tribe;

    public Card(String name, PowerMethod power, int health, CostMethod cost, Tribe tribe, List<Sigil> sigils) {
        this.name = name;
        this.power = power;
        this.health = health;
        this.cost = cost;
        this.tribe = tribe;
        this.sigils = sigils;
    }

    public boolean addSigil(Sigil sigil) {
        String sigilClassName = sigil.getClass().getName();
        if (sigils.stream().anyMatch(s -> s.getClass().getName().equals(sigilClassName))) {
            return false;
        } else {
            this.sigils.add(sigil);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power.getPower();
    }

    public String getPowerMethod() {
        return power.getPowerMethod();
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int healthToAdd) {
        health += healthToAdd;
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void subtractCurrHealth(int health) {
        currHealth -= health;
    }

    public String getCostMethod() {
        return cost.getCostMethod();
    }

    public int getCost() {
        return cost.getCost();
    }

    public List<Sigil> getSigils() {
        return sigils;
    }

    public Tribe getTribe() {
        return tribe;
    }

    public String getTribeString() {
        return tribe.toString();
    }

    public void addPower(int powerToAdd) {
        power.addPower(powerToAdd);
    }

    public boolean hasSigil(String sigilName) {
        return sigils.stream().anyMatch(s -> s.getName().equals(sigilName));
    }

    public int getDyingBoneCount() {
        if (hasSigil("Bone King")) {
            return 4;
        } else {
            return 1;
        }
    }

}
