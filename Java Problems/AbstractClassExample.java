abstract public class Animal {
    protected boolean isMammal;
    protected boolean isCarnivorous;

    public Animal(boolean isMammal,boolean isCarnivorous){
        this.isMammal=isMammal;
        this.isCarnivorous=isCarnivorous;
    }

    public boolean getIsMammal(){
        return this.isMammal;
    }

    public boolean getIsCarnivorous(){
        return this.isCarnivorous;
    }

    abstract public String getGreeting();

    public void printAnimal(String name){
        System.out.println("A "+name+" says " +this.getGreeting()+", is "+(this.isCarnivorous?"":"not ")
        +"carnivorous, and is "+(this.getIsMammal()?"":"not "+"a mammal"));
    }
}
class Dog extends Animal{
    Dog(){
        super(true,true);
    }
    public String getGreeting(){
        return "bow";
    }
}
class Cat extends Animal{
    Cat(){
        super(true,false);
    }

    @Override
    public String getGreeting() {
        return "meow";
    }
}

class Duck extends Animal{
    Duck(){
        super(false,false);
    }

    @Override
    public String getGreeting() {
        return "quack";
    }
}
class Solution{
    public static void main(String[] args) {
        Dog dog= new Dog();
        dog.printAnimal("dog");
        Cat cat= new Cat();
        cat.printAnimal("cat");
        Duck duck=new Duck();
        duck.printAnimal("duck");
    }
}