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

/*


TechGig
Open Contest - Code Gladiators 2019...
Instructions Help

Time:01:25:46/03:00:00
Problem Statement
Discussions
My Submissions
WIN or LOSE (100 Marks)
A new fighting game has become popular. There are N number of villains with each having some strength. There are N players in the game with each having some energy. The energy is used to kill the villains. The villain can be killed only if the energy of the player is greater than the strength of the villain.





Maxi is playing the game and at a particular time wants to know if it is possible for him to win the game or not with the given set of energies and strengths of players and villains. Maxi wins the game if his players can kill all the villains with the allotted energy.



Input Format
The first line of input consist of number of test cases, T.

The first line of each test case consist of number of villains and player, N.

The second line of each test case consist of the N space separated strengths of Villains.

The third line of each test case consist of N space separated energy of players.



Constraints
1<= T <=10

1<= N <=1000

1<= strength , energy <=100000



Output Format
For each test case, Print WIN if all villains can be killed else print LOSE in separate lines.

Sample TestCase 1
Input
1
6
112 243 512 343 90 478
500 789 234 400 452 150
Output
WIN
Explanation
For the given test case, If we shuffle the players and villains, we can observe that all the villains can be killed by players.



Player

Villain

RESULT

500

478

WIN

789

512

WIN

234

112

WIN

400

243

WIN

452

343

WIN

150

90

WIN


As all the villains can be killed by the players, MAXI will WIN the game. Thus, the final output is WIN.
Sample TestCase 2
Input
2
6
10 20 50 100 500 400
30 20 60 70 90 490
5
10 20 30 40 50
40 50 60 70 80
Output
LOSE
WIN
Time Limit(X):
1.00 sec(s) for each input.
Memory Limit:
512 MB
Source Limit:
100 KB
Allowed Languages:
C, C++, C++11, C++14, C#, Java, Java 8, Kotlin, PHP, PHP 7, Python, Python 3, Perl, Ruby, Node Js, Scala, Clojure, Haskell, Lua, Erlang, Swift, VBnet, Js, Objc, Pascal, Go, F#, D, Groovy, Tcl, Ocaml, Smalltalk, Cobol, Racket, Bash, GNU Octave, Rust, Common LISP, R, Julia, Fortran, Ada, Prolog, Icon, Elixir, CoffeeScript, Brainfuck, Pypy, Lolcode, Nim, Picolisp, Pike, pypy3


Judge Environment


Draft saved at 10:27 PM
38343536373132332829303456789101112131415161718192021222324252627123940
 */