import java.io.*;

class PrivateConstructor {
    private PrivateConstructor(){
        System.out.println("Instance Created");
    }

    //Since main is within the class it has access to private methods of the class and hence object is created
    /*public static void main(String[] args) {
        PrivateConstructor pv = new PrivateConstructor();
        System.out.println(pv.hashCode());
    }*/
    public static PrivateConstructor getInstanceOfPrivateConstructor(){
        return new PrivateConstructor();
    }
}

class Temp{
    public static void main(String[] args) {
        //cannot directly call the constructor
        //PrivateConstructor pv = new PrivateConstructor(); // PrivateConstructor() has private access in PrivateConstructor
        PrivateConstructor pv1=PrivateConstructor.getInstanceOfPrivateConstructor();
        System.out.println(pv1.hashCode());
        PrivateConstructor pv2=PrivateConstructor.getInstanceOfPrivateConstructor();
        System.out.println(pv2.hashCode());
    }
}

