package edu.wctc.Cost;

public class CostBlood implements CostMethod {
    private int cost;

    public CostBlood(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getCostMethod() {
        return "Blood";
    }
}
