package javaTester;

public class Topic_002_Abstract_Dog extends Topic_002_Abstract_Animal {
    public Topic_002_Abstract_Dog(String name) {
        super(name);
        System.out.println("Dog created");
    }

    @Override
    public void eat() {
        System.out.println("Eating Dog");
    }

    public void sleep() {
        System.out.println("dog sleep");
    }

    public static void main(String[] args) {
        Topic_002_Abstract_Dog dog = new Topic_002_Abstract_Dog("Lulu");
        System.out.println("name " + dog.getName());

        dog.eat();
        dog.sleep();

        dog.color = "white";
        System.out.println("color" + dog.color);

        dog.age = 5;
        System.out.println("age " + dog.age);
    }
}
