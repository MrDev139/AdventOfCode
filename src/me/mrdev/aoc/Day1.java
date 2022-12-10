package me.mrdev.aoc;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("day1.txt"));
        String line = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        int current = 0;
        while(line != null) { //read all file lines
            if(line.isEmpty()){ //if space detected
                line = reader.readLine();
                list.add(current);
                current = 0;
                continue;
            }
            current += Integer.parseInt(line); //keep adding the numbers from the lines until we reach a space
            line = reader.readLine();
        }
        Collections.sort(list); //sorting from smallest to biggest
        System.out.println("the biggest value is " + list.get(list.size() - 1));
        int top3 = list.get(list.size() - 1) + list.get(list.size() - 2) + list.get(list.size() - 3);
        System.out.println("top three values combined " + top3);
    }
    /* original code for part 1 of day 1
        BufferedReader reader = new BufferedReader(new FileReader("day1.txt"));
        String line = reader.readLine();
        int biggest = 0;
        int current = 0;
        while(line != null) { //read all file lines
            if(line.isEmpty()){ //if space detected
                line = reader.readLine();
                if(current > biggest) { //if current is biggest than the biggest value
                    biggest = current; //out new biggest value
                }
                current = 0; //we reset the value
                continue;
            }
            current += Integer.parseInt(line); //keep adding the numbers from the lines until we reach a space
            line = reader.readLine();
        }
        System.out.println("the biggest value is " + biggest);*/

}