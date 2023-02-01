package PageObjects;

import Utils.DBConfig;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import javax.swing.*;

import java.io.IOException;

import static Scripts.BaseClass.*;
import static Utils.DBConfig.ConnectDB;

public class UploadBandhuDocsPage {

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

        Employeename.sendKeys(empname);
        Mobileno.click();

    }

    public static void SetMobileno(String mobno){

        Mobileno.sendKeys(mobno);
        EmailID.click();


    }

    public static void SetEmailid(String email){

        EmailID.sendKeys(email);
        Mobileno.click();

    }

    public static void SetCredentials(String Employee,String Mobilenum , String Email ){

        Employeename.sendKeys(Employee);
        Mobileno.sendKeys(Mobilenum);
        EmailID.sendKeys(Email);

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


    public static void clickModule(){

        UploadBandhuDocsPage.Bandhuprocess.click();
        UploadBandhuDocsPage.UploadbandhuDocs.click();
    }


    //TextBox Validation
    public static void TextboxValidate(int value,String errmsg,int row , int cell) throws IOException {


        if (value == 1) {
            if (EmployeenameTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);

            }

        } else if (value == 2) {

            if (mobilenumTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);

            }

        } else if (value == 3) {

            if (EmailIDTextBoxErrormsg().equals(errmsg)) {

                Assert.assertTrue(true, "TestCase Passed");
                xlcon.setCellValue(row,cell,"TestCase Passed",excelfilepath);
            }

        }else{

            Assert.assertTrue(false,"TestCase Failed");
            xlcon.setCellValue(row,cell,"TestCase Failed",excelfilepath);
        }

    }


    public static void Validate(String errmsg,int row , int column) throws IOException {

        if(driver.getPageSource().contains(errmsg)){

            xlcon.setCellValue(row,column,"TestCase Passed",excelfilepath);
            Assert.assertTrue(true);



        }else {

            xlcon.setCellValue(row,column,"TestCase Failed",excelfilepath);
            xlcon.setCellValue(6,4,"Cause : "+Errormsg.getText(),excelfilepath);
            Assert.assertTrue(false);


        }
        

    }



}
