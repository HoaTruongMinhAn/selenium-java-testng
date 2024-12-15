package javaTester.FactoryPattern.Apply;

public class Mercedes extends CarFactory {
    @Override
    public void drive() {
        System.out.println("Mercedes drive");
    }

    @Override
    public void alarm() {
        System.out.println("Mercedes alarm");
    }

    @Override
    public void stop() {
        System.out.println("Mercedes stop");
    }
}
