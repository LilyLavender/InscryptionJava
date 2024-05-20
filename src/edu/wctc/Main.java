package edu.wctc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = Player.getInstance();
        Game game = Game.getInstance(player);
    }

    public static void soutForceEnter(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
