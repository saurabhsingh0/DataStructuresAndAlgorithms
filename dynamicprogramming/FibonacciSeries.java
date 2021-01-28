package com.saurabh.algorithms.dynamicprogramming;

import java.io.BufferedReader;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n =40;
        int[] array = new int[n+1];
        array[1]=1;
        array[2]=2;
        FibonacciSeries.fibo(n, array);
        System.out.println("Answer from memoization approach: "+array[n-1]);
        System.out.println("Answer from bottom up approach: "+fiob_bottom_up(n));
    }
    // 1,1,2,3,5,8,13,21,34,55,89

    //Memoization (Top Down) Approach
    public static int fibo(int n, int[] array){
        if(array[n]!=0){
            return array[n];
        }
        array[n] = fibo(n-1, array)+ fibo(n-2, array);
        return array[n];
    }

    //Bottom Up Approach
    public static int fiob_bottom_up(int n){
        int[] fibo = new int[n+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i=3; i<=n; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        return fibo[n];
    }
}
