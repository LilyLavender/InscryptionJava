package edu.wctc.Power;

public class PowerNone implements PowerMethod {

    @Override
    public int getPower() {
        return 0;
    }

    @Override
    public String getPowerMethod() {
        return "X";
    }

    @Override
    public void addPower(int powerToAdd) {}
}
