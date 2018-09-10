// Throws clause is used to declare an exception, which means it works similar to the try-catch block.
// throws is followed by exception class names.
// throws is used in method signature to declare the exceptions that can occur in the statements present in the method.
//  You can throw one exception at a time but you can handle multiple exceptions by declaring them using throws keyword

public class ThrowsExample {
    public int divison(int a,int b)throws ArithmeticException{
        int t=a/b;
        return t;
    }

    public static void main(String[] args) {
        ThrowsExample obj= new ThrowsExample();
        try{
            obj.divison(13,0);
        }
        catch (ArithmeticException e){
            System.out.println("You should not divide by zero");
        }
    }
}
