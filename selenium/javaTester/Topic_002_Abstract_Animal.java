package javaTester;

public abstract class Topic_002_Abstract_Animal {
    String name;
    public Topic_002_Abstract_Animal(String name){
        this.name = name;
        System.out.println("Animal created");
    }

    public abstract void eat();

    public void sleep() {
        System.out.println("animal sleep");
    }
}
