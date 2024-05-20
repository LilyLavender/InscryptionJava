package edu.wctc.Cost;

public class CostFree implements CostMethod {
    @Override
    public int getCost() {
        return -1;
    }

    public String getCostMethod() {
        return "Free";
    }
}
