package javaTester.FactoryPattern.NotApply;

public class User {
    public static void main(String[] args) {
        Honda honda = new Honda();
        honda.drive();
        honda.alarm();
        honda.stop();


        Suzuki suzuki = new Suzuki();
        suzuki.driveMe();
        suzuki.alarmMe();
        suzuki.stopMe();


        Mercedes mercedes = new Mercedes();
        mercedes.letDrive();
        mercedes.letAlarm();
        mercedes.letStop();
    }
}
