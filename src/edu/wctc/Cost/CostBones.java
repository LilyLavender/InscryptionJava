package edu.wctc.Cost;

public class CostBones implements CostMethod {
    private int cost;

    public CostBones(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public String getCostMethod() {
        return "Bones";
    }
}
