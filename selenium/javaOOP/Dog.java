package javaOOP;

public class Dog extends Animals{


    public static void main(String[] args) {
        Animals animal1 = new Animals();
        System.out.println(animal1.age);

        animal1.age = 10;
        System.out.println(animal1.age);

        animal1.setName("Huskey");
        System.out.println(animal1.getName());

    }

}
