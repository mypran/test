package com.codegladiator.challenge;


/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.util.*;
public class HeroVsVillanCodeGladiator {
    public static void main(String args[] ) throws Exception {

        //Write code here
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());
        String noOfGames[] = new String[noOfTestCases];

        while(noOfTestCases > 0) {
            int i=0;
            int noOfPlayersOrVillans = Integer.parseInt(scanner.nextLine());

            String arr[] = scanner.nextLine().split(" ");
            int strengthOfVillanInt[] = new int[arr.length];

            String[] arr2 = scanner.nextLine().split(" ");
            int energyOfPlayerInt[] = new int[arr2.length];
            for(String val: arr2){
                strengthOfVillanInt[i] = Integer.parseInt(arr[i]);
                energyOfPlayerInt[i] = Integer.parseInt(val);
                i++;
            }

            noOfGames[noOfGames.length - noOfTestCases] = process(strengthOfVillanInt, energyOfPlayerInt);
            noOfTestCases --;

        }

        for(String x : noOfGames) {
            System.out.println(x);
        }

    }

    private static String process(int[] strengthOfVillanInt, int[] energyOfPlayerInt){
        strengthOfVillanInt = countingSort(strengthOfVillanInt);
        boolean villanKilled;
        int prevPlayerMax = 0;
        for (int i = strengthOfVillanInt.length -1; i >=0 ; i--) {
            villanKilled = false;
            prevPlayerMax = 0;
            for (int j = 0; j < energyOfPlayerInt.length; j++) {
                if (energyOfPlayerInt[j] != -1
                        && energyOfPlayerInt[j] > strengthOfVillanInt[i]
                ) {
                    if(prevPlayerMax == 0 ) {
                        prevPlayerMax = j;
                    } else if(energyOfPlayerInt[prevPlayerMax] < energyOfPlayerInt[j]) {
                        prevPlayerMax = j;
                    }
                    villanKilled = true;
                }
            }
            if(villanKilled == false){
                return "LOSE";
            }
            energyOfPlayerInt[prevPlayerMax] = -1;
        }
        return "WIN";
    }

    private static int[] countingSort(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }

        int[] sortedNumbers = new int[max+1];

        for (int i = 0; i < numbers.length; i++) {
            sortedNumbers[numbers[i]]++;
        }

        int insertPosition = 0;

        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < sortedNumbers[i]; j++) {
                numbers[insertPosition] = i;
                insertPosition++;
            }
        }
        return numbers;
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
The challenge line of input consist of number of test cases, T.

The challenge line of each test case consist of number of villains and player, N.

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