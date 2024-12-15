package javaTester.FactoryPattern.Apply;

public class User {
    public static void main(String[] args) {
        CarFactory car = CarFactory.getCarFactory("honda");
        car.drive();
        car.stop();
        car.alarm();

        car = CarFactory.getCarFactory("MERCEDES");
        car.drive();
        car.stop();
        car.alarm();

        car = CarFactory.getCarFactory("SUZUki");
        car.drive();
        car.stop();
        car.alarm();
    }
}
