package Scripts;

import PageObjects.Bandhu_DocsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static PageObjects.Bandhu_DocsPage.*;
import static Utils.Constant.GetDate;
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
        Thread.sleep(600);
        Bandhu_DocsPage.ValidateAuditscreen(1,3,3);

    }

    @Test(dependsOnMethods = "TC_003_Verify_AuditScreen_is_Showing")
    public void TC_004_Verify_AuditScreen_Fiedls_Readonly() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.ValidateAuditscreen(2,4,3);


    }

    @Test(dependsOnMethods = "TC_004_Verify_AuditScreen_Fiedls_Readonly")
    public void TC_005_Verify_Images() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.ValidateAuditscreen(3,5,3);

    }

    @Test(dependsOnMethods = "TC_005_Verify_Images")
    public void TC_006_Verify_Datas() throws IOException, InterruptedException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Saveduniqueid();
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
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(10,2,10,3);
        try{
            Bandhu_DocsPage.SetDivision(xlcon.getCellData(10,1));
        }catch (Exception e){
            xlcon.setCellValue(10,4,"Cause :"+e.getMessage(),excelfilepath);
        }

    }

    @Test(dependsOnMethods = "TC_010_Verify_Division_name_is_Mandatory")
    public static void TC_011_Verify_Branch_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(11,2,11,3);
        try{
            Bandhu_DocsPage.Setbranch(xlcon.getCellData(11,1));
        }catch (Exception e){
            xlcon.setCellValue(11,4,"Cause :"+e.getMessage(),excelfilepath);
        }

    }

    @Test(dependsOnMethods = "TC_011_Verify_Branch_name_is_Mandatory")
    public static void TC_012_Verify_Town_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(12,2,12,3);
        try{

            Bandhu_DocsPage.SetTown(xlcon.getCellData(12,1));
        }catch (Exception e){

            xlcon.setCellValue(12,4,"Cause :"+e.getMessage(),excelfilepath);
        }


    }

    @Test(dependsOnMethods = "TC_012_Verify_Town_name_is_Mandatory")
    public static void TC_013_Verify_State_name_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(13,2,13,3);
        try{
            Bandhu_DocsPage.Setstate(xlcon.getCellData(13,1));
        }catch (Exception e){
            xlcon.setCellValue(13,4,"Cause :"+e.getMessage(),excelfilepath);
        }


    }

    @Test(dependsOnMethods = "TC_013_Verify_State_name_is_Mandatory")
    public static void TC_014_Verify_RM1_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(14,2,14,3);
        try{
            Bandhu_DocsPage.SetRm1(xlcon.getCellData(14,1));
        }catch (Exception e){

            xlcon.setCellValue(14,4,"Cause :"+e.getMessage(),excelfilepath);
        }


    }

    @Test(dependsOnMethods = "TC_014_Verify_RM1_is_Mandatory")
    public static void TC_015_Verify_RM2_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(15,2,15,3);
        try{
            Bandhu_DocsPage.SetRm2(xlcon.getCellData(15,1));
        }catch (Exception e) {
            xlcon.setCellValue(15,4,"Cause :"+e.getMessage(),excelfilepath);
        }


    }

    @Test(dependsOnMethods = "TC_015_Verify_RM2_is_Mandatory")
    public static void TC_016_Verify_Designation_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(16,2,16,3);
        try{
            Bandhu_DocsPage.SetDesignation(xlcon.getCellData(16,1));
        }catch (Exception e){
            xlcon.setCellValue(16,4,"Cause :"+e.getMessage(),excelfilepath);
        }
    }

    @Test(dependsOnMethods = "TC_016_Verify_Designation_is_Mandatory")
    public static void TC_017_Verify_ClientBranch_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(17,2,17,3);
        try{
            Bandhu_DocsPage.Setclientbranch(xlcon.getCellData(17,1));
        }catch (Exception e){
            xlcon.setCellValue(17,4,"Cause :"+e.getMessage(),excelfilepath);
        }

    }


    @Test(dependsOnMethods = "TC_017_Verify_ClientBranch_is_Mandatory")
    public static void TC_018_Verify_DOJ_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(18,2,18,3);

    }

    @Test(dependsOnMethods = "TC_018_Verify_DOJ_is_Mandatory")
    public static void TC_019_Verify_3DaysDOJ_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.SETDOJ(xlcon.getCellData(19,1));
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(19,2,19,3);
        Bandhu_DocsPage.SETDOJ(GetDate());

    }



    @Test(dependsOnMethods = "TC_019_Verify_3DaysDOJ_is_Mandatory")
    public static void TC_020_Verify_DOB_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(20,2,20,3);

    }


    @Test(dependsOnMethods = "TC_020_Verify_DOB_is_Mandatory")
    public static void TC_021_Verify_18Years_is_Mandatory() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.SETDOB(GetDate());
        Thread.sleep(1000);
        Bandhu_DocsPage.initiate();
        Thread.sleep(1000);
        ValidateAlerts(21,2,21,3);
        Bandhu_DocsPage.SETDOB(xlcon.getCellData(21,1));

    }

    @Test(dependsOnMethods = "TC_021_Verify_18Years_is_Mandatory")
    public static void TC_022_Verify_OB_Initiate() throws IOException, InterruptedException, AWTException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.SetDivision(xlcon.getCellData(10,1));
        Bandhu_DocsPage.Setbranch(xlcon.getCellData(11,1));
        Bandhu_DocsPage.SetTown(xlcon.getCellData(12,1));
        Bandhu_DocsPage.Setstate(xlcon.getCellData(13,1));
        Bandhu_DocsPage.SetRm1(xlcon.getCellData(14,1));
        Bandhu_DocsPage.SetRm2(xlcon.getCellData(15,1));
        Bandhu_DocsPage.SetDesignation(xlcon.getCellData(16,1));
        Bandhu_DocsPage.Setclientbranch(xlcon.getCellData(17,1));
        Bandhu_DocsPage.initiate();
        ValidateAuditscreen(6,22,3);

    }

}