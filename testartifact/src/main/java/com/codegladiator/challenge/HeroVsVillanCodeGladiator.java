package com.codegladiator.challenge;

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */


import java.util.*;
public class HeroVsVillanCodeGladiator {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(scanner.nextLine());

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
            System.out.println(process(strengthOfVillanInt, energyOfPlayerInt));
            noOfTestCases --;
        }


    }

    private static String process(int[] strengthOfVillanInt, int[] energyOfPlayerInt){
        strengthOfVillanInt = countingSort(strengthOfVillanInt);
        energyOfPlayerInt = countingSort(energyOfPlayerInt);
        int i = 0;
        for(int x: energyOfPlayerInt){
            if (x < strengthOfVillanInt[i]) {
                return "LOSE";
            }
            i++;
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

