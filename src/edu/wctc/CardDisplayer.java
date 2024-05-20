package edu.wctc;

import edu.wctc.Cost.CostMethod;
import edu.wctc.Power.PowerMethod;
import edu.wctc.Sigils.Sigil;
import edu.wctc.Tribes.Tribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Abandon all hope, ye who enter here ⎛⎝(•ⱅ•)⎠⎞
public class CardDisplayer {
    public CardDisplayer() {}

    public void displayCards(List<Card> cards) {
        List<String> outputs = new ArrayList<>();
        for (Card card : cards) {
            int longestString = 18;
            int borderLength = longestString + 2;
            if (!card.getName().isEmpty()) {
                String name = card.getName();
                int power = card.getPower();
                int health = card.getCurrHealth() != 0 ? card.getCurrHealth() : card.getHealth();
                int cost = card.getCost();
                List<Sigil> sigils = card.getSigils();
                String tribe = card.getTribeString();
                String costMethod = card.getCostMethod();
                String costString = cost >= 0 ? cost + " " : "";
                String powerMethod = card.getPowerMethod();
                String powerString = powerMethod == "Ants" ? powerMethod : power + " " + powerMethod;

                String ret = "";
                ret += "•" + repeatCharacter('-', borderLength) + "•\n" +
                        "| " + addWhitespace(name, longestString) + " |\n";
                if (!tribe.isEmpty()) {
                    ret += "| " + addWhitespace(tribe, longestString) + " |\n";
                }

                ret += "•" + repeatCharacter('-', borderLength) + "•\n";
                if (powerMethod != "X") {
                    ret += "| " + addWhitespace(powerString, longestString) + " |\n";
                }
                ret +=
                        "| " + addWhitespace(health + " Health", longestString) + " |\n" +
                                "| " + addWhitespace(costString + costMethod, longestString) + " |\n" +
                                "•" + repeatCharacter('-', borderLength) + "•\n";
                for (Sigil sigil : sigils) {
                    ret += "| " + addWhitespace(sigil.getName(), longestString) + " |\n";
                }
                if (!sigils.isEmpty()) {
                    ret += "•" + repeatCharacter('-', borderLength) + "• ";
                }

                outputs.add(ret);
            } else {
                String ret = "";
                ret += "•" + repeatCharacter('-', borderLength) + "•\n";
                for (int i = 0; i < 9; i++) {
                    ret += "| " + addWhitespace("", longestString) + " |\n";
                }
                ret += "•" + repeatCharacter('-', borderLength) + "•\n";
                outputs.add(ret);
            }
        }

        List<List<String>> linesList = new ArrayList<>();
        int maxLines = 0;

        for (String output : outputs) {
            String[] lines = output.split("\n");
            maxLines = Math.max(maxLines, lines.length);
            linesList.add(Arrays.asList(lines));
        }

        List<StringBuilder> combinedLines = new ArrayList<>();
        for (int i = 0; i < maxLines; i++) {
            combinedLines.add(new StringBuilder());
        }

        int j = 0;
        List<Integer> prevLines = new ArrayList<>();
        for (List<String> lines : linesList) {
            for (int i = 0; i < maxLines; i++) {
                if (i < lines.size()) {
                    combinedLines.get(i).append(lines.get(i).trim() + "   ");
                } else {
                    combinedLines.get(i).append(repeatCharacter(' ', 25));
                }

                prevLines.add(combinedLines.get(i).length());
                if (prevLines.size() > cards.size()) {
                    prevLines.remove(0);
                }
            }
            j++;
            if (j % cards.size() == 0) {
                for (StringBuilder builder : combinedLines) {
                    builder.append("\n");
                }
            }
        }

        StringBuilder combinedOutput = new StringBuilder();
        for (StringBuilder builder : combinedLines) {
            combinedOutput.append(builder);
        }

        System.out.println(combinedOutput);
    }

    private String addWhitespace(String string, int targetLength) {
        int whitespaceToAdd = targetLength - string.length();
        StringBuilder builder = new StringBuilder(string);
        for (int i = 0; i < whitespaceToAdd; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    private String repeatCharacter(char c, int times) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            builder.append(c);
        }
        return builder.toString();
    }
}
