package javaTester;

public class Topic_002_Interface_Dell implements Topic_002_Interface_Computer{


    @Override
    public void run() {

    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Dell run");
        System.out.println(Topic_002_Interface_Computer.myName);
    }
}
