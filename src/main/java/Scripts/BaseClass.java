package Scripts;

import PageObjects.LoginPage;
import Utils.ReadConfig;
import Utils.XLConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static PageObjects.LoginPage.username;
import static Utils.Constant.*;

public class BaseClass {

    //Properties File Reading
    static ReadConfig readconfig = new ReadConfig();

    //Log
   public Logger log = Logger.getLogger("BANDHUDOCSWEB");

    public static String excelfilepath = filepath;

    public static XLConfig xlcon = new XLConfig();

    public static WebDriver driver;
    long StartTime;
    long endTime;

    @BeforeSuite
    public void StartBrowser() throws InterruptedException, IOException {

        HashMap preferences  =  new HashMap();
        preferences.put("download.default_directory",downloadinglocation);

        ChromeOptions options =  new ChromeOptions();
        options.setExperimentalOption("prefs",preferences);

        DOMConfigurator.configure("Log4J.xml");
        if (readconfig.GetBrowser().equalsIgnoreCase("Chrome")) {

            log.info("Chrome is Opened");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (readconfig.GetBrowser().equalsIgnoreCase("firefox")) {

            log.info("Firefox is Opened");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);

        } else if (readconfig.GetBrowser().equalsIgnoreCase("Edge")) {

            log.info("Microsoft Edge is Opened");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);

        }

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get(readconfig.getapplicationURL());
        log.info(readconfig.getapplicationURL());
        driver.manage().window().maximize();
        PageFactory.initElements(driver, LoginPage.class);
        LoginPage.SetLoginCredentials(Username,password,Company);



    }

    @AfterSuite(enabled = true)
    public void closebrowser() throws InterruptedException {

        driver.quit();
        endTime = System.currentTimeMillis();
        long Totaltime = endTime - StartTime;
        System.out.println("TIMETAKEN:" + Totaltime);
        driver.quit();

    }

    @AfterMethod
    public void captureScreen(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE); // capture screenshot file
            File target = new File(Screenshotfilepath + result.getName() + ".png");

            FileUtils.copyFile(source, target);
        }

    }

    public String GetRandomNumber() {

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

    public String GetRandomString(){

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


}
