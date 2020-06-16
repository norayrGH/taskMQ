package com.matching.task;

/**
 * Algorithm: n!/(2*(n-2)!)
 *    n
 * --------
 * 2*(n-2)!
 */
public class Combinations {
    public static void main(String[] args) {
        int total = 10;
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int lineNumber = 1;
        for (int i = 0; i < total - 1; i++) {
            for (int j = i + 1; j < total; j++, lineNumber++) {
                System.out.println(lineNumber + ":\t" + String.join(" ", String.valueOf(letters.charAt(i)), String.valueOf(letters.charAt(j))));
            }
        }
    }
}
