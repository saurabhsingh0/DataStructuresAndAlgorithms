// throw is used to explicitly throw an exception
// an instance of exception class is passed
// Throw keyword is used in the method body to throw an exception
// You can throw one exception at a time but you can handle multiple exceptions by declaring them using throws keyword.



public class ThrowExample {
    public void checkAge(int age){
        if(age<18){
            throw new ArithmeticException("Not eligible for voting");
        }
        else {
            System.out.println("Eligible for voting");
        }
    }

    public static void main(String[] args) {
        ThrowExample obj= new ThrowExample();
        //obj.checkAge(13);
        //handdle the exception
        for(int i=2;i<=5;i++){
            try{
                obj.checkAge(i*i);
            }
            catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
