package com.codegladiator.first;

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
import java.util.*;

public class HeroVsVillanCodeGladiator {
    public static void main(String args[] ) {
        int strengthOfVillanInt[];
        int energyOfPlayerInt[];

        //Write code here
        Scanner scanner = new Scanner(System.in);

        int noOfTestCases = Optional.ofNullable(scanner.nextLine())
                .map(Integer::parseInt)
                .orElse(0);
        assert (noOfTestCases > 10 || noOfTestCases < 1)  : " Test Case count should be between 1 and 10, inclusive.";
        String noOfGames[] = new String[noOfTestCases];

        while(noOfTestCases > 0) {

            int noOfPlayersOrVillans = Optional.ofNullable(scanner.nextLine())
                    .map(Integer::parseInt)
                    .orElse(0);
            assert (noOfPlayersOrVillans > 1000 || noOfPlayersOrVillans < 1) : " Palyers/Villans count should be between 1 and 1000, inclusive.";


            strengthOfVillanInt = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int x: strengthOfVillanInt) {
                assert (x < 1) : " Palyer energy," + x + " should be greater than or equal to one.";
            }
            assert(strengthOfVillanInt.length != noOfPlayersOrVillans) : "Palyers energy count should be equal to number of players, " + noOfPlayersOrVillans;


            energyOfPlayerInt = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int x: energyOfPlayerInt) {
                assert (x > 100000) : " Villan strength," + x + " should be less than or equal to 100000." ;
            }
            assert(energyOfPlayerInt.length != noOfPlayersOrVillans) : "Villans strength count should be equal to number of players, " + noOfPlayersOrVillans;

            noOfGames[noOfGames.length - noOfTestCases] = process(strengthOfVillanInt, energyOfPlayerInt);
            noOfTestCases --;

        }

        for(String x : noOfGames) {
            System.out.println(x);
        }

    }

    private static String process(int[] strengthOfVillanInt, int[] energyOfPlayerInt){
        Arrays.sort(strengthOfVillanInt);
        Arrays.sort(energyOfPlayerInt);

        int i = 0;
        for(int x: energyOfPlayerInt){
            if (x < strengthOfVillanInt[i]) {
                return "LOSE";
            }
        }

        return "WIN";
    }
}

/*

1
6
112 243 512 343 90 478
500 789 234 400 452 150
WIN

 */