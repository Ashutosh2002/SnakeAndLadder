package org.example;

import org.example.models.Game;
import org.example.models.Player;

import java.util.LinkedList;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        int numberOfDices = 1;
        int dimension = 10;

        Player p1 = new Player("Varun");
        Player p2 = new Player("Ravi");

        Queue<Player> players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

//        Number of Dices, Dimension , Players
        Game game = new Game(numberOfDices, dimension, players);

//        start playing the game
        game.start();
    }
}