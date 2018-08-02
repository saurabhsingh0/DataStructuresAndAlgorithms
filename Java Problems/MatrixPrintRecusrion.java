/*You are given a n*n matrix fill the element in following manner
for n=5
matrix[][]=
1	2	3	4	5	
16	17	18	19	6	
15	24	25	20	7	
14	23	22	21	8	
13	12	11	10	9


for n=6
matrix[][]=
1	2	3	4	5	6	
20	21	22	23	24	7	
19	32	33	34	25	8	
18	31	36	35	26	9	
17	30	29	28	27	10	
16	15	14	13	12	11 */





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixPrintRecusrion {
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the value of n: ");
        int n=Integer.parseInt(br.readLine());
        int matrix[][]= new int[n][n];
        fillMatrix(matrix,1,0,n-1);
        //to print the matrix
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    //recursive method to fill the matrix
    public static void fillMatrix(int matrix[][],int count,int offset,int n){
        if(count>(n+1)*(n+1)){
            return;
        }
        int i=offset,j=offset;
        //fill matrix from left to right ie increment column
        while(j<=(n-offset)){
            if(matrix[i][j]<1){
                matrix[i][j]=count;
                count++;
                j++;
            }
        }
        j=n-offset;
        //fill matrix from top to bottom ie increment row
        while(i<=(n-offset)){
            if(matrix[i][j]<1){
                matrix[i][j]=count;
                count++;
                i++;
            }
            else {
                i++;
            }
        }
        i=n-offset;
        //fill the matrix from right to left ie decrement column
        while(j>=offset){
            if(matrix[i][j]<1){
                matrix[i][j]=count;
                count++;
                j--;
            }
            else {
                j--;
            }
        }
        j=offset;
        while(i>=offset){
            if(matrix[i][j]<1){
                matrix[i][j]=count;
                count++;
                i--;
            }
            else {
                i--;
            }
        }
        fillMatrix(matrix,count,offset+1,n);
    }
}
