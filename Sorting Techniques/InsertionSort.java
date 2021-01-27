package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) throws IOException {
        //int[] array={5,2,4,6,1,3};
        //int[] array={31, 41, 59, 26, 41, 58};
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0; i< str.length; i++){
            array[i] = Integer.parseInt(str[i]);
        }
        InsertionSort.insertionSort(array);
        for(int i=0; i< array.length; i++){
            System.out.print(array[i]+" ");;
        }
    }

    public static void insertionSort(int[] array){
        for(int i=1; i<array.length; i++){
            int key=array[i];
            //insert the key into sorted sequence of A[0..i-1]
            int j=i-1;
            while(j>=0 && array[j]>key){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
    }
}
