package javaTester.FactoryPattern.Apply;

public abstract class CarFactory {

    public static CarFactory getCarFactory(String carName) {
        CarFactory car = null;
        CarList carEnum = CarList.valueOf(carName.toUpperCase());

        switch (carEnum) {
            case HONDA:
                System.out.println("make new Honda");
                car = new Honda();
                break;
            case SUZUKI:
                System.out.println("make new Suzuki");
                car = new Suzuki();
                break;
            case MERCEDES:
                System.out.println("make new Mercedes");
                car = new Mercedes();
                break;
        }
        return car;
    }

    public abstract void drive();

    public abstract void alarm();

    public abstract void stop();
}
