package javaTester;

public abstract class Topic_002_Abstract_Animal {
    private String name;
    protected int age;
    public String color;

    public Topic_002_Abstract_Animal(String name){
        this.name = name;
        System.out.println("Animal created");
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public abstract void eat();

    public void sleep() {
        System.out.println("animal sleep");
    }
}
