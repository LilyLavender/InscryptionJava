package edu.wctc.Power;

public class Power implements PowerMethod {
    private int power;

    public Power(int power) {
        this.power = power;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public String getPowerMethod() {
        return "Power";
    }

    @Override
    public void addPower(int powerToAdd) {
        power += powerToAdd;
    }
}
