package Scripts;

import PageObjects.Bandhu_DocsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

import static PageObjects.Bandhu_DocsPage.*;
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
        Thread.sleep(2000);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(10,2,10,3);
        Bandhu_DocsPage.SetDivision(xlcon.getCellData(10,1));

    }

    @Test(dependsOnMethods = "TC_010_Verify_Division_name_is_Mandatory")
    public static void TC_011_Verify_Branch_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(11,2,11,3);
        Bandhu_DocsPage.Setbranch(xlcon.getCellData(11,1));

    }

    @Test(dependsOnMethods = "TC_011_Verify_Branch_name_is_Mandatory")
    public static void TC_012_Verify_Town_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(12,2,12,3);
        Bandhu_DocsPage.SetTown(xlcon.getCellData(12,1));

    }

    @Test(dependsOnMethods = "TC_012_Verify_Town_name_is_Mandatory")
    public static void TC_013_Verify_State_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(13,2,13,3);
        Bandhu_DocsPage.Setstate(xlcon.getCellData(13,1));

    }

    @Test(dependsOnMethods = "TC_013_Verify_State_name_is_Mandatory")
    public static void TC_014_Verify_RM1_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(14,2,14,3);
        Bandhu_DocsPage.SetRm1(xlcon.getCellData(14,1));

    }

    @Test(dependsOnMethods = "TC_014_Verify_RM1_is_Mandatory")
    public static void TC_015_Verify_RM2_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(15,2,15,3);
        Bandhu_DocsPage.SetRm2(xlcon.getCellData(15,1));

    }

    @Test(dependsOnMethods = "TC_015_Verify_RM2_is_Mandatory")
    public static void TC_016_Verify_Designation_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(16,2,16,3);
        Bandhu_DocsPage.SetDesignation(xlcon.getCellData(16,1));

    }

    @Test(dependsOnMethods = "TC_016_Verify_Designation_is_Mandatory")
    public static void TC_017_Verify_ClientBranch_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(17,2,17,3);
        Bandhu_DocsPage.Setclientbranch(xlcon.getCellData(17,1));

    }

    @Test(dependsOnMethods = "TC_017_Verify_ClientBranch_is_Mandatory")
    public static void TC_018_Verify_3DaysDOJ_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.SETDOJ(xlcon.getCellData(18,1));
        Bandhu_DocsPage.initiate();
        ValidateAlerts(18,2,18,3);

    }

    @Test(dependsOnMethods = "TC_018_Verify_3DaysDOJ_is_Mandatory")
    public static void TC_019_Verify_DOJ_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(19,2,19,3);
        DOJ.click();
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);

    }

    @Test(dependsOnMethods = "TC_019_Verify_DOJ_is_Mandatory")
    public static void TC_020_Verify_18Years_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        DOB.click();
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(20,2,20,3);


    }

    @Test(dependsOnMethods = "TC_020_Verify_18Years_is_Mandatory")
    public static void TC_021_Verify_DOB_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.initiate();
        ValidateAlerts(21,2,21,3);
        Bandhu_DocsPage.SETDOB(xlcon.getCellData(21,1));

    }

}