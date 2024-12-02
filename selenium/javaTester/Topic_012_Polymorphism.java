package javaTester;

public class Topic_012_Polymorphism {
    //Constructor
    public Topic_012_Polymorphism(){
        System.out.println("Topic_012_Polymorphism");
    }

    public Topic_012_Polymorphism(String name){
        System.out.println("Topic_012_Polymorphism " + name);
    }

    public static void main(String[] args) {
//        WebDriver driver = new FirefoxDriver();
//        Actions action = new Actions(driver);
//        action.click();
//        action.click(driver.findElement(By.xpath("")));

        Topic_012_Polymorphism object1 = new Topic_012_Polymorphism();
        Topic_012_Polymorphism object2 = new Topic_012_Polymorphism("Mary");
    }
}
