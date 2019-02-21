/*
    Author: Yuan Zhang
*/


// This program calculates the distribution of numbers after using unfair shuffle algorithm

import java.util.Random;

public class ShuffleAnalysis {

    public static int[] badShuffle(int n) {
        // bad shuffle algorithm
        int pick;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i; // make an ordered list with elements from 0 to n-1
        }
        for (int i = n - 1; i >= 0; i--) {
            Random r = new Random();
            pick = r.nextInt(n);
            int temp = arr[i];
            arr[i] = arr[pick];
            arr[pick] = temp;
        }
        return arr;
    }

    public static int[][] countTimes(int n,int m) { //n is the number of elements; m is the times of running
        int[][] count = new int[n][n];
        for (int i = 0; i < m; i++) {
            int[] arr = badShuffle(n);
            for (int j = 0; j < n ; j++) {
                count[j][arr[j]]++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 50;
        int m = 1000000;
        int[][] times = new int[n][n];
        times = countTimes(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(times[i][j] + "\t");
            }
            System.out.println();

        }

    }
}
