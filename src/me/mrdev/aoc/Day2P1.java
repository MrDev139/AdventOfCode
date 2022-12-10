package me.mrdev.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2P1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("day2.txt"));
        String line = reader.readLine();
        int score = 0;
        while (line != null) {
            //System.out.println(line); A Z
            String[] game = line.split(" "); //[A,Z]

            switch (game[1]) {
                case "X":
                    game[1] = "A";
                    break;
                case "Y":
                    game[1] = "B";
                    break;
                case "Z":
                    game[1] = "C";
                    break;
                default:
                    System.out.println("don't touch the file you son of a bitch");
            }

            score += new Game(game[0] , game[1]).getScore();
            line = reader.readLine();
        }
        System.out.println("Final score: " + score);
    }

    static class Game {

        private Move opponent;
        private Move player;

        public Game(String op, String p) {
            this.opponent = Arrays.stream(Move.values()).filter(m -> m.getCode().equals(op)).findAny().orElse(null);
            this.player = Arrays.stream(Move.values()).filter(m -> m.getCode().equals(p)).findAny().orElse(null);
        }

        public int getScore() {
            if(opponent == Move.ROCK && player == Move.PAPER || opponent == Move.PAPER && player == Move.SCISSORS || opponent == Move.SCISSORS && player == Move.ROCK) {
                return 6 + player.getValue();
            }
            if(opponent == player) {
                return 3 + player.getValue();
            }
            return player.getValue();
        }

    }

    enum Move {
        ROCK(1, "A"),PAPER(2, "B"),SCISSORS(3 , "C");

        private int value;
        private String code;

        Move(int value, String code) {
            this.value = value;
            this.code = code;
        }

        public int getValue() {
            return value;
        }

        public String getCode() {
            return code;
        }


    }

}
