import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxContigiousSubArray {
    public static void main (String[] args)throws IOException {
        //int array[]={-2,-3,4,-1,-2,1,5,-3};  ans is 7
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[]=br.readLine().split(" ");
        int high=Integer.parseInt(str[0]);
        int array[]=new int[high];
        for(int i=0;i<high;i++){
            array[i]=Integer.parseInt(str[i+1]);
        }*/
        int array[]={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int high=array.length-1;
        int ans=findMaxContinguousSubArray(array,0,high-1);
        System.out.println(ans);
    }
    public static int returnMaxOfThree(int a,int b,int c){
        return  (a>=b) && (a>=c)? a : (b>=c) ? b :c;
    }
    public static int findMaxContinguousSubArray(int [] array,int low,int high){
        if(low==high){
            return array[low];
        }
        if((low+1==high) && (low <high)){
            return returnMaxOfThree(array[low],array[high],array[low]+array[high]);
        }
        int mid=(low+high)/2;
        int left_MSS=findMaxContinguousSubArray(array,low,mid);
        int right_Mss=findMaxContinguousSubArray(array,mid+1,high);
        int leftSum=-99999,rightSum=-99999,sum=0;
        for(int i=mid;i>=0;i--){
            sum+=array[i];
            if(sum>leftSum){
                leftSum=sum;
            }
        }
        sum=0;
        for(int i=mid+1;i<=high;i++){
            sum+=array[i];
            if(sum>rightSum){
                rightSum=sum;
            }
        }
        int ans=returnMaxOfThree(left_MSS,leftSum+rightSum,right_Mss);
        return ans;
    }
}
