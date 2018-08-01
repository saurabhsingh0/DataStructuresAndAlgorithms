import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args){
        int array[]={2,8,7,1,3,5,6,4};
        int length=array.length;
        System.out.println(length);
        quickSort(array,0,length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int array[],int p,int r){
        if(p<r){
            int q=partition(array,p,r);
            quickSort(array, p, q-1);
            quickSort(array, q+1, r);
        }

    }

    //method to find partition
    public static int partition(int array[],int p,int r){
        int x=array[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(array[j]<=x){
               i+=1;
               //swap array[i] and array[j]
               int temp=array[j];
               array[j]=array[i];
               array[i]=temp;
            }
        }
        int temp=array[i+1];
        array[i+1]=array[r];
        array[r]=temp;
        return i+1;
    }
}


/*Algorithm:
QUICKSORT (A, p, r)
         if (p<r)
            q=PARTITION(A, p, r)
            QUICKSORT(A, p, q-1)
            QUICKSORT(A, q+1, r)


PARTITION(A, p, r)
1 x = A[r]
2 i = p-1
3 for j = p to r-1
4   if A[j] <= x
5       i = i+1
6       exchange A[i] with A[j]
7 exchange A[i+1] with A[r]
8 return i+1 */