package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static Scripts.BaseClass.driver;
import static Scripts.BaseClass.log;

public class Constant {

    public static  final String downloadinglocation = System.getProperty("user.dir")+"\\Downloads\\";
    public static  final String DevelopmentURL = "http://devnewhrms.ppms.co.in/";
    public static  final String QAURL = "http://qa-hrms.ppms.co.in/";
    public static  final String LIVEURL = "http://hrms.ppms.co.in/";
    public static  final String Uploadinglocation = System.getProperty("user.dir")+"\\Uploads\\";
    public static final String filepath = "./src/main/resources/Datas/DocsTestDatas.xlsx";
    public static final String Screenshotfilepath = System.getProperty("user.dir") + "/ScreenShots/";
    public static final String Databaseurl = "jdbc:sqlserver://183.83.187.133\\FIELDLYTICSDEVS:1433;DatabaseName=HRMS_ARVIND;encrypt=true;trustServerCertificate=true";
    public static final String Dbusername = "Fieldlytics2021";
    public static final String Dbpassword = "PPMSdevserver$2022";
    public static final String classname = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public static String GetRandomNumber() {

        int randomnum1 = ThreadLocalRandom.current().nextInt();
        String randomnum = String.valueOf(randomnum1);

        return randomnum;

    }

    public static String GetRandomSpecialCharacters() {

        String Randspecchar = "!@#$%^&*()_+{}";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * Randspecchar.length());
            salt.append(Randspecchar.charAt(index));
        }
        String Randomspecailcharac = salt.toString();
        return Randomspecailcharac;

    }

    public static String GetRandomString(){

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();

        return randomString;
    }

    public static boolean isFileDownloaded(String downloadPath, String fileName) {

        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {

            if (dir_contents[i].getName().equals(fileName))

                return flag=true;
        }

        return flag;
    }

    public static void uploadfile(String Path) throws AWTException, InterruptedException {

        Thread.sleep(800);
        WebElement uploadPhotoBtn = driver.findElement(By.xpath("//*[@type=\"file\"]"));
        uploadPhotoBtn.sendKeys(Path);
        log.info(Path);

    }

    public static String GetDate(){

        Date thisdate =  new Date();
        SimpleDateFormat df =  new SimpleDateFormat("dd-MM-YYYY");
        return df.format(thisdate);


    }





}
