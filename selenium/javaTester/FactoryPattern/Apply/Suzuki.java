package javaTester.FactoryPattern.Apply;

public class Suzuki extends CarFactory {
    @Override
    public void drive() {
        System.out.println("Suzuki drive");
    }

    @Override
    public void alarm() {
        System.out.println("Suzuki alarm");
    }

    @Override
    public void stop() {
        System.out.println("Suzuki stop");
    }
}
