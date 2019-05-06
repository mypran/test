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

/*


TechGig
Open Contest - Code Gladiators 2019...
Instructions Help

Time:01:16:26/03:00:00
Problem Statement
Discussions
My Submissions
Neighbours and New Year Party (100 Marks)
In the XYZ society, the neighbours hate each other for their attitude. Various activities are organized in the society for Welcoming the New Year. The tickets were provided to each house with an integer written on it. Some got tickets with positive integers and some got tickets with negative integers. In the evening, people had to carry their tickets to the club house where the eligible ones will get the exciting gifts. The eligibility of winning the gift depends on the maximum sum which can be formed from the tickets numbers keeping in mind that neighbours hate each other. Since the neighbours hate each other, the two cannot be together in the list of maximum sum.





The President of the society, Mr. Singh, is a wise man and know that neighbours in society don't like each other. Also, he don't wish to become bad in front of people. So, he came up with an idea to design a program which will provide the list of integers forming maximum sum and thus all the members of the list will be given the gifts. The only problem with this idea is that he don't know programming so he is asking you to provide the correct list of integers. The people may be annoying but are smart and will fight if the list provided by you doesn't form the maximum sum.


Note: The integer written on ticket of individuals may or may not be unique. In case, when there are two list with equal maximum sum, the list with first greater element would be considered. For better understanding, look at the explanation of Test case 4 in Sample Test Case. The tickets with integer 0 are not considered for winning the gifts.


Input Format
The first line of input consist of number of test cases, T.

The first line of each test case consist of the number of houses (tickets distributed) in society, N.

The second line of each test case consist of N space separated tickets with integer written on them.




Constraints
1<= T <=10

1<= N <=10000

-1000<= Integer_on_Ticket <=1000



Output Format
For each test case, print the ticket numbers in a single line forming the maximum sum in the format similar to Sample Test Case.

Sample TestCase 1
Input
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
Output
48
13
12
44
10
Explanation
Test Case 1: Maximum sum which can be formed is 12. Element considered 8, 4. Note that Output is printed from the reverse side of the array which is TRUE for all the test cases without the space. So, the output is 48.
Test Case 2: Maximum sum which can be formed is 4. Element considered 3, 1. Output = 13.
Test Case 3: Maximum sum which can be formed is 12 as by taking any other element value of maximum sum decreases.
Test Case 4: Maximum sum which can be formed is 8 by taking 3, 5 or 4, 4. But the output is 4, 4 as 3 is smaller than 4.
Test Case 5: Maximum sum which can be formed is 10.

Time Limit(X):
0.70 sec(s) for each input.
Memory Limit:
512 MB
Source Limit:
100 KB
Allowed Languages:
C, C++, C++11, C++14, C#, Java, Java 8, Kotlin, PHP, PHP 7, Python, Python 3, Perl, Ruby, Node Js, Scala, Clojure, Haskell, Lua, Erlang, Swift, VBnet, Js, Objc, Pascal, Go, F#, D, Groovy, Tcl, Ocaml, Smalltalk, Cobol, Racket, Bash, GNU Octave, Rust, Common LISP, R, Julia, Fortran, Ada, Prolog, Icon, Elixir, CoffeeScript, Brainfuck, Pypy, Lolcode, Nim, Picolisp, Pike, pypy3


Judge Environment


Draft saved at 1:16 PM
424344453940413738343536313233282930232425262720212217181914151612131234567891011


 */