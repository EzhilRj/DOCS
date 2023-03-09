package PageObjects;

import Scripts.BaseClass;
import Utils.DBConfig;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import javax.swing.*;

import java.io.File;
import java.io.IOException;

import static Scripts.BaseClass.*;
import static Utils.Constant.downloadinglocation;
import static Utils.Constant.isFileDownloaded;
import static Utils.DBConfig.ConnectDB;
import static Utils.ListenersConfig.test;

public class UploadBandhuDocsPage extends BaseClass {

    @FindBy(xpath = "//*[text()='Bandhu Process']")
    public static WebElement Bandhuprocess;

    @FindBy(xpath = "//*[text()='Upload Bandhu Docs']")
    public static WebElement UploadbandhuDocs;

    @FindBy(id = "ctl00_Content_txtEmployeeName")
    public static WebElement Employeename;

    @FindBy(id = "ctl00_Content_txtMobileNo")
    public static WebElement Mobileno;

    @FindBy(id = "ctl00_Content_txtEmailID")
    public static WebElement EmailID;

    @FindBy(id = "ctl00_Content_Button1")
    public static WebElement Save;

    @FindBy(id = "ctl00_Content_btnUpload")
    public static WebElement upload;

    @FindBy(id = "ctl00_Content_btnExport")
    public static WebElement Export;

    @FindBy(id = "ctl00_Content_excelFile")
    public static WebElement Choosefile;


    @FindBy(id = "ctl00_Content_regexpName")
    public static WebElement textboxerrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator")
    public static WebElement EmployeenameErrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator3")
    public static WebElement mobilenumErrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator5")
    public static WebElement EmailIdErrmsg;

    @FindBy(className= "errorInsmsg")
    public static WebElement Errormsg;


    public static void SetEmpname(String empname){

        Employeename.clear();
        Employeename.sendKeys(empname);
        Mobileno.click();
        log.info(empname);

    }

    public static void SetMobileno(String mobno){

        Mobileno.clear();
        Mobileno.sendKeys(mobno);
        EmailID.click();
        log.info(mobno);


    }

    public static void SetEmailid(String email){

        EmailID.clear();
        EmailID.sendKeys(email);
        Mobileno.click();
        log.info(email);

    }

    public static void SetCredentials(String Employee,String Mobilenum , String Email ){

        Employeename.sendKeys(Employee);
        Mobileno.sendKeys(Mobilenum);
        EmailID.sendKeys(Email);
        log.info(Employee);
        log.info(Mobilenum);
        log.info(Email);

    }


    public static void savebutton(){

        Save.click();

    }

    public static void Uploadbutton(){

        upload.click();

    }

    public static void ExportButton(){

        Export.click();

    }

    public static void Choosefile(){

        Choosefile.click();

    }

    public static String EmployeenameTextBoxErrormsg(){


        String errmsg1 = EmployeenameErrmsg.getText();

        return errmsg1;
    }

    public static String mobilenumTextBoxErrormsg(){


        String errmsg2 = mobilenumErrmsg.getText();

        return errmsg2;
    }

    public static String EmailIDTextBoxErrormsg(){


        String errmsg3 = EmailIdErrmsg.getText();

        return errmsg3;
    }


    public static void clickModule() throws InterruptedException {

        Thread.sleep(600);
        UploadBandhuDocsPage.Bandhuprocess.click();
        Thread.sleep(1000);
        UploadBandhuDocsPage.UploadbandhuDocs.click();
    }


    //TextBox Validation
    public static void TextboxValidate(int value,String errmsg,int row , int cell) throws IOException {


        if (value == 1) {
            if (EmployeenameTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);
                log.info(errmsg);
                log.info("TestCase Passed");

            }

        } else if (value == 2) {

            if (mobilenumTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);
                log.info(errmsg);
                log.info("TestCase Passed");

            }

        } else if (value == 3) {

            if (EmailIDTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);
                log.info(errmsg);
                log.info("TestCase Passed");
            }

        }else{

            xlcon.setCellValue(row,cell,"TestCase Failed",excelfilepath);
            log.error("TestCase Failed");
            Assert.assertTrue(false,"TestCase Failed");


        }

    }


    public static void Validate(String errmsg,int row , int column) throws IOException {

        if(driver.getPageSource().contains(errmsg)){

            xlcon.setCellValue(row,column,"TestCase Passed",excelfilepath);
            log.info(errmsg);
            log.info("TestCase Passed");
            Assert.assertTrue(true);

        }else {

            xlcon.setCellValue(row,column,"TestCase Failed",excelfilepath);
            xlcon.setCellValue(6,4,"Cause : "+Errormsg.getText(),excelfilepath);
            log.error("TestCase Failed");
            Assert.assertTrue(false);

        }

    }

    public static void ValidateDownloaded(int row , int column) throws IOException, InterruptedException {


        boolean verifyfiledownload = isFileDownloaded(downloadinglocation,"UploadBandhuDocs.csv");

        if(verifyfiledownload){

            xlcon.setCellValue(row,column,"TestCase Passed",excelfilepath);
            log.info("File Downloaded Successfully");
            Assert.assertTrue(true, "Testcase Passed");
            File f= new File (downloadinglocation+"UploadBandhuDocs.csv");
            f.delete();
            log.info("File Deleted Successfully");


        }else{

            xlcon.setCellValue(row,column,"TestCase Failed",excelfilepath);
            log.error("TestCase Failed");
            Assert.assertTrue(false, "Testcase failed");
        }



    }




    }




