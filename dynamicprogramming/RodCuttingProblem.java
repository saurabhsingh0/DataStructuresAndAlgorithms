package com.saurabh.algorithms.dynamicprogramming;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int lenth = 10;
        int[] prices = {1,5,8,9,10,17,17,20,24,30};
        int[] revenue = new int[lenth+1];
        int maxRevenue = RodCuttingProblem.cut_rod(prices, 5);
        System.out.println("Max Revenue is from recursion approach : "+maxRevenue);
        System.out.println("Max Revenue is from memoized approach : "+
                RodCuttingProblem.memoized_cut_rod(prices,revenue, 10));
        System.out.println(Arrays.toString(revenue));
    }

    //recursive top-down approach
    public static int cut_rod(int[] prices, int n){
        if(n==0){
            return 0;
        }
        int q= -1;
        for(int i=1; i<=n; i++){
            q = Math.max(q, prices[i-1]+cut_rod(prices, n-i));
        }
        return q;
    }

    //memoized cut-rod
    public static int memoized_cut_rod(int[] prices, int[] revenue, int n){
        if(revenue[n]>0){
            return revenue[n];
        }
        int q;
        if(n==0){
            q=0;
        }else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, prices[i-1] + memoized_cut_rod(prices, revenue, n - i));
            }
        }
        revenue[n] = q;
        return revenue[n];
    }
}
