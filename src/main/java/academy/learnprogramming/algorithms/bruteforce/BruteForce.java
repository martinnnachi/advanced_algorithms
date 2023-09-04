package academy.learnprogramming.algorithms.bruteforce;

import java.util.Arrays;

/**
 * Brute Force Algorithm
 * It will search for a pattern in an array, and if the pattern is found,
 * it will return the index of the array
 * where the first letter of the pattern was found.
 * if no match is found, it will return -1
 */
public class BruteForce {

    /**
     * This method searches for the pattern in an array and returns the index
     * of the first character that matches.
     * if no match is found -1 is returned
     * array=abcadef
     * pattern=def -> 4
     *
     * @param array
     * @param pattern
     * @return
     */
    public int firstMatch(char[] array, char[] pattern) {
        for (int a = 0; a <= array.length - pattern.length; a++) {
            for (int p = 0; p < pattern.length; p++) {
                if (array[a + p] != pattern[p]) break;
                if (p == pattern.length - 1) return a;
            }
        }
        return -1;
    }

    /**
     * This method searches for a pattern in an array and returns an array of int with
     * the indexes of the elements found
     * @param array
     * @param pattern
     * @return
     */
    public int[] everyMatch(char[] array, char[] pattern) {
        int[] found = new int[array.length];
        Arrays.fill(found, -1);
        int index = 0;
        for (int a = 0; a <= array.length - pattern.length; a++) {
            for (int p = 0; p < pattern.length; p++) {
                if (array[a + p] != pattern[p]) break;
                if (p == pattern.length - 1) {
                    found[index++] = a;
                }
            }
        }
        return found;
    }
}
