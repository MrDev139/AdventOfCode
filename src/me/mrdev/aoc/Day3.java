package me.mrdev.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Day3 {

    public static void main(String[] args) throws IOException {
        /* each string contains 2 substrings (division by half)
        * item type is the common letter between those 2 substrings
        * the priority of the type(common letter) is its count in the alphabet 1-26(lower) 26-52(upper)
        * goal: get the sum of all the priorities of each string
        */
        BufferedReader reader = new BufferedReader(new FileReader("day3.txt"));
        String line = reader.readLine();
        int total = 0;
        while (line != null) {
            String sub = line.substring(line.length() / 2);
            String[] subs = {line.replaceAll(sub, ""), sub};//contains the split substrings
            total += getPriority(getCommonChar(subs[0], subs[1]));
            line = reader.readLine();
        }
        System.out.println("Total amount of priorities is " + total);
    }

    public static char getCommonChar(String str, String compr) { //since we know it's only one common type between in substrings we return the first one we get
        for (int i = 0; i < str.length() ; i++) {
            if(compr.contains(String.valueOf(str.charAt(i)))) {
                return str.charAt(i);
            }
        }
        return '0';
    }

    public static int getPriority(char c) {
        String Alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return Alpha.indexOf(c) + 1; //cuz we need to add 1 for indexOf
    }

}
