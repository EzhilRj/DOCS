package Scripts;

import PageObjects.Bandhu_DocsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static PageObjects.Bandhu_DocsPage.ValidateAlerts;
import static Utils.Constant.filepath;
import static Utils.XLConfig.setExcelFile;

public class BandhuDocs_Test extends BaseClass {

    @Test
    public void BandhuDocsSheetSetter() throws IOException {

        setExcelFile(filepath, "BandhuDocs");

    }

    @Test
    public void TC_001_Verify_BandhuDocs_PageTitle() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.BandhuProcess();
        Bandhu_DocsPage.Validatetitle(1,1,1,3);

    }

    @Test
    public void TC_002_Employee_DataisShowing() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        driver.switchTo().frame("myIframe");
        Bandhu_DocsPage.Validatedata(2,3);

    }

    @Test(dependsOnMethods = "TC_002_Employee_DataisShowing")
    public void TC_003_Verify_AuditScreen_is_Showing() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.View();
        Thread.sleep(1000);
        Bandhu_DocsPage.ValidateAuditscreen(1,3,3);

    }

    @Test(dependsOnMethods = "TC_003_Verify_AuditScreen_is_Showing")
    public void TC_004_Verify_AuditScreen_Fiedls_Readonly() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.ValidateAuditscreen(2,4,3);


    }

    @Test(dependsOnMethods = "TC_004_Verify_AuditScreen_Fiedls_Readonly")
    public void TC_005_Verify_Images() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.ValidateAuditscreen(3,5,3);

    }

    @Test(dependsOnMethods = "TC_005_Verify_Images")
    public void TC_006_Verify_Datas() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.ValidateAuditscreen(4,6,3);

    }

    @Test(dependsOnMethods = "TC_006_Verify_Datas")
    public void TC_007_Verify_AadharDetails() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Aadharimg();
        Bandhu_DocsPage.ValidateAuditscreen(5,7,3,Bandhu_DocsPage.Aadharno);
        Thread.sleep(600);
        Bandhu_DocsPage.close();



    }

    @Test(dependsOnMethods = "TC_007_Verify_AadharDetails")
    public static void TC_008_Verify_BankDetails() throws IOException, InterruptedException, AWTException {


        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Bankimg();
        Bandhu_DocsPage.ValidateAuditscreen(5,8,3,Bandhu_DocsPage.Bankaccno);
        Thread.sleep(600);
        Bandhu_DocsPage.close1();

    }

    @Test(dependsOnMethods = "TC_008_Verify_BankDetails")
    public static void TC_009_Verify_Reject_without_Reason() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Reject();
        ValidateAlerts(9,2,9,3);
    }

    @Test(dependsOnMethods = "TC_009_Verify_Reject_without_Reason")
    public static void TC_010_Verify_Division_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Approve();
        Bandhu_DocsPage.initiate();
        ValidateAlerts(10,2,10,3);

    }

    @Test(dependsOnMethods = "TC_010_Verify_Division_name_is_Mandotory")
    public static void TC_011_Verify_Branch_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Approve();
        Bandhu_DocsPage.initiate();
        ValidateAlerts(10,2,10,3);

    }

    @Test(dependsOnMethods = "TC_011_Verify_Branch_name_is_Mandatory")
    public static void TC_012_Verify_Town_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Approve();
        Bandhu_DocsPage.initiate();
        ValidateAlerts(10,2,10,3);

    }






}