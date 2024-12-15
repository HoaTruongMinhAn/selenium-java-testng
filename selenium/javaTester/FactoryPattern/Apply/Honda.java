package javaTester.FactoryPattern.Apply;

public class Honda extends CarFactory {
    @Override
    public void drive() {
        System.out.println("Honda drive");
    }

    @Override
    public void alarm() {
        System.out.println("Honda alarm");
    }

    @Override
    public void stop() {
        System.out.println("Honda stop");
    }
}
