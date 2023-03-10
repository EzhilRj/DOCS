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
import java.time.Duration;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static Utils.Constant.*;

public class BaseClass {

    //Properties File Reading
    static ReadConfig readconfig = new ReadConfig();
    //Log
    public static Logger log = Logger.getLogger("DOCSWEB1.0");

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
        options.setExperimentalOption("prefs",preferences).addArguments("--remote-allow-origins=*");

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

        if(readconfig.GetEnvironment().equals("Dev")){
            log.info(readconfig.GetEnvironment());
            driver.get(DevelopmentURL);
            log.info(readconfig.GetEnvironment());
        } else if (readconfig.GetEnvironment().equals("QA")) {
            driver.get(QAURL);
            log.info(readconfig.GetEnvironment());
        } else if (readconfig.GetEnvironment().equals("Live")) {
            driver.get(LIVEURL);
            log.info(readconfig.GetEnvironment());
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        PageFactory.initElements(driver, LoginPage.class);
        LoginPage.SetLoginCredentials(readconfig.Getusername(),readconfig.GetPassword(),readconfig.GetClient());
        log.info(readconfig.Getusername()+readconfig.GetPassword()+readconfig.GetClient());

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

}
