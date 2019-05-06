package com.codegladiator.first;

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
        import java.util.*;
public class HatingNeighboursMaxSumWin {
    public static void main(String args[] ) throws Exception {

        int nosIntArr[];
        Scanner scanner = new Scanner(System.in);

        int noOfTestCases = Integer.parseInt(scanner.nextLine());
        int noOfGames[] = new int[noOfTestCases];

        while(noOfTestCases > 0) {

            int noOfEleToRead = Optional.ofNullable(scanner.nextLine())
                    .map(Integer::parseInt)
                    .orElse(0);

            nosIntArr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            noOfGames[noOfGames.length - noOfTestCases] = process(nosIntArr);
            noOfTestCases --;

        }

        for(int x : noOfGames) {
            System.out.println(x);
        };

    }

    public static int process(int[] nosIntArr){
        int i = 0;
        int j = 0;
        int k = 0;
        int j2 = 0;
        int k2 = 0;
        int digits = 0;
        int digitsOtr = 0;
        int digitsOtrSum = 0;
        int digitsSum = 0;
        int digitsOtrLeast = 0;
        int digitsOtrSumLeast = 0;
        int digitsLeast = 0;
        int digitsSumLeast = 0;

        int maxAt = 0, leastAt =0;
        for ( i = 0; i < nosIntArr.length; i++) {
            maxAt = ((nosIntArr[i] > nosIntArr[maxAt]) ? i : maxAt);
            leastAt = ((nosIntArr[i] < 0 && nosIntArr[i] < nosIntArr[leastAt]) ? i : leastAt);
        }

        for ( i = 0, j =0, k=0, j2 =0 , k2 = 0; i < nosIntArr.length; i++) {
            if(nosIntArr[i] > 0 ){
                if ( ((maxAt-1) >= 0  && nosIntArr[i] == nosIntArr[maxAt-1] )
                        || ((maxAt+1) < nosIntArr.length  && nosIntArr[i] == nosIntArr[(maxAt+1)])
                ){
                    digitsOtr = nosIntArr[i] * (int) Math.pow(10, k) + digitsOtr;
                    digitsOtrSum  = digitsOtrSum + nosIntArr[i];
                    k++;
                } else {
                    digits = nosIntArr[i] * (int) Math.pow(10, j) + digits;
                    digitsSum = digitsSum + nosIntArr[i];
                    j++;
                }
            } else {
                if ( ((leastAt-1) >= 0  && nosIntArr[i] == nosIntArr[leastAt-1] )
                        || ((leastAt+1) < nosIntArr.length  && nosIntArr[i] == nosIntArr[(leastAt+1)])
                ){
                    digitsOtrLeast = nosIntArr[i] * (int) Math.pow(10, k2) + digitsOtrLeast;
                    digitsOtrSumLeast  = digitsOtrSumLeast + nosIntArr[i];
                    k2++;
                } else {
                    digitsLeast = nosIntArr[i] * (int) Math.pow(10, j2) + digitsLeast;
                    digitsSumLeast = digitsSumLeast + nosIntArr[i];
                    j2++;
                }
            }
        }

        if(digitsOtrLeast > digitsOtr){
            digitsOtrSum = digitsSumLeast;
            digitsOtr = digitsOtrLeast;
        }

        if(digitsLeast > digits){
            digitsSum = digitsSumLeast;
            digits = digitsLeast;
        }

        if ( digitsOtrSum == digitsSum
                && digitsOtr > digits ) {
            return digitsOtr;
        }

        return digits;

    }
}

/*

Console
Result
Test Case Passed Successfully Time (Sec) 0.632 Memory (KiB) 212
Test Case Input
5
5
-1 7 8 -5 4
4
3 2 1 -1
4
11 12 -2 -1
4
4 5 4 3
4
5 10 4 -1
Test Case Output
48
13
12
44
10
Expected Output
48
13
12
44
10

 */