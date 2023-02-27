package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties pro;

    public ReadConfig() {

        File src = new File("./src/main/resources/Configuration/BandhuDocs.properties");

        try {

            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);

        } catch (Exception e) {

            System.out.println("Exception is" + e.getMessage());
        }

    }

    public String GetBrowser() {

        String browser = pro.getProperty("Browser");
        return browser;

    }

    public String getapplicationURL() {

        String Url = pro.getProperty("BaseURL");
        return Url;

    }

    public String Getusername() {

        return pro.getProperty("Username");

    }


    public String GetPassword() {

        return pro.getProperty("Password");

    }

    public String GetClient() {

        return pro.getProperty("Company");

    }
}
