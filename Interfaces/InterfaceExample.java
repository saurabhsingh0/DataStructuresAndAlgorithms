interface Vehicle{
    void changeGear(int a);
    void speedUp(int a);
    void applyBrakes(int a);
}
class Bicycle implements Vehicle{
    int speed;
    int gear;

    @Override
    public void changeGear(int a) {
        this.gear=a;
    }

    @Override
    public void speedUp(int a) {
        this.speed+=a;
    }

    @Override
    public void applyBrakes(int a) {
        this.speed-=a;
    }

    @Override
    public String toString() {
        return "speed is "+this.speed+" gear is "+this.gear;
    }
}
class Car implements Vehicle{
    int speed;
    int gear;

    @Override
    public void changeGear(int a) {
        this.gear=a;
    }

    @Override
    public void speedUp(int a) {
        this.speed+=a;
    }

    @Override
    public void applyBrakes(int a) {
        this.speed-=a;
    }

    @Override
    public String toString() {
        return "speed is "+this.speed+" gear is "+this.gear;
    }
}
public class InterfaceExample  {
    public static void main(String[] args) {
        Bicycle b=new Bicycle();
        b.speed=10;
        b.gear=2;
        System.out.println(b);
        b.changeGear(3);
        b.speedUp(20);
        System.out.println(b);
        //Interface can't be instantiated
        //but we can make a reference that refers to class implementing it
        Vehicle v=new Car();
        v.speedUp(10);
        v.changeGear(5);
        System.out.println(v);
    }
}
