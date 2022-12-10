package me.mrdev.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day2P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("day2.txt"));
        String line = reader.readLine();
        int score = 0;
        while (line != null) {
            //System.out.println(line); A Z
            String[] game = line.split(" "); //[A,Z]

            score += new Game(game[0] , game[1]).getScore();
            line = reader.readLine();
        }
        System.out.println("Final score: " + score);
    }

    static class Game {

        private Move opponent;
        private String status;

        public Game(String op, String status) {
            this.opponent = Arrays.stream(Move.values()).filter(m -> m.getCode().equals(op)).findAny().orElse(null);
            this.status = status;
        }

        public int getScore() { //i wanted it this way so i don't edit the class too much from D2P1
            if(status.equals("X")) { //lose
                switch (opponent) {
                    case ROCK:
                        return Move.SCISSORS.getValue();
                    case PAPER:
                        return Move.ROCK.getValue();
                    case SCISSORS:
                        return Move.PAPER.getValue();
                }
            }else if(status.equals("Z")) { //win
                switch (opponent) {
                    case ROCK:
                        return Move.PAPER.getValue() + 6;
                    case PAPER:
                        return Move.SCISSORS.getValue() + 6;
                    case SCISSORS:
                        return Move.ROCK.getValue() + 6;
                }
            }
            return opponent.getValue() + 3; //draw
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
