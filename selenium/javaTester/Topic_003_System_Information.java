package javaTester;

import java.io.File;
import java.nio.file.FileSystems;

public class Topic_003_System_Information {
    int amount;

    //test ssss
    public static void main(String[] args) {
        //Get OS name
        String osName = System.getProperty("os.name");
        System.out.println("OS name: " + osName);

        //Get path to this project
        String projectPath = System.getProperty("user.dir");
        System.out.println("projectPath: " + projectPath);

        //Get path separator for current OS
        // Windows, Linux: \
        // Mac: /
        String separator1 = File.separator;
        System.out.println("File separator 1: " + separator1);

        String separator2 = System.getProperty("file.separator");
        System.out.println("File separator 2: " + separator2);

        String separator3 = FileSystems.getDefault().getSeparator();
        System.out.println("File separator 3: " + separator3);


        //Get path to a file
        String filePath = projectPath + File.separator + "uploadFiles" + File.separator + "big image 1.png";
        System.out.println("filePath: " + filePath);

        //Get OS user name
        System.out.println("OS user name: " + System.getProperty("user.name"));
        System.out.println("OS user name: " + System.getenv("USERNAME"));

        //Get java version
        System.out.println("Java version: " + System.getProperty("java.version"));



    }


}
