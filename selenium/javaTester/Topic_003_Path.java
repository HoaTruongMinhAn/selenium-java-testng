package javaTester;

import java.io.File;

public class Topic_003_Path {
    int amount;

    //test ssss
    public static void main (String[] args) {
        //Get OS name
        String osName = System.getProperty("os.name");
        System.out.println(osName);

        //Get path to this project
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        //Get path separator for current OS
        // Window: \
        // Mac: /
        String separator = File.separator;
        System.out.println(separator);
    }


}
