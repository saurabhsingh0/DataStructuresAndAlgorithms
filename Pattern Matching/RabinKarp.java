public class RabinKarp {
    public static void main(String[] args) {
        String text="saurabhsaurabhsaurabhsaurabhsaurabhsaurabh";
        String pattern="saurabh";
        RabinKarpPatternMatching(text,pattern);
    }

    public static void RabinKarpPatternMatching(String text,String pattern){
        // n is text length and m is pattern length
        int n=text.length();
        int m=pattern.length();
        int d=256;
        int q=101;
        int h=1;
        for(int i=1;i<m;i++){
            h=(h*d)%q;
        }
        //System.out.println(h);
        long textHash=0;
        long patternHash=0;
        for(int i=0;i<m;i++){
            textHash=(textHash*d+text.charAt(i))%q;
            patternHash=(patternHash*d+pattern.charAt(i))%q;
        }
        System.out.println("hash of initial string is "+textHash+" hash of pattern is "+patternHash);
        for(int i=0;i<=n-m;i++){
            if(textHash==patternHash){
                int j=0;
                for(j=0;j<m;j++){
                    if(text.charAt(i+j)!=pattern.charAt(j)){
                        break;
                    }
                }
                if(j==m){
                    System.out.println("pattern found at index " +i);
                }
            }
            if(i<n-m){
                textHash=(d*(textHash-text.charAt(i)*h)+text.charAt(i+m))%q;
            }
            if(textHash<0){
                textHash+=q;
            }
        }
    }
}
