package PageObjects;

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

import static TestCases.BaseClass.*;

public class UploadBandhuDocsPage {

    WebDriver driver;

    public UploadBandhuDocsPage(WebDriver driver){

        this.driver = driver;

    }

    @FindBy(xpath = "//*[text()='Bandhu Process']")
    public WebElement Bandhuprocess;

    @FindBy(xpath = "//*[text()='Upload Bandhu Docs']")
    public  WebElement UploadbandhuDocs;

    @FindBy(id = "ctl00_Content_txtEmployeeName")
    public WebElement Employeename;

    @FindBy(id = "ctl00_Content_txtMobileNo")
    public  WebElement Mobileno;

    @FindBy(id = "ctl00_Content_txtEmailID")
    public WebElement EmailID;

    @FindBy(id = "ctl00_Content_Button1")
    public WebElement Save;

    @FindBy(id = "ctl00_Content_btnUpload")
    public WebElement upload;

    @FindBy(id = "ctl00_Content_btnExport")
    public WebElement Export;

    @FindBy(id = "ctl00_Content_excelFile")
    public WebElement Choosefile;


    @FindBy(id = "ctl00_Content_regexpName")
    public WebElement textboxerrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator")
    public WebElement EmployeenameErrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator3")
    public WebElement mobilenumErrmsg;

    @FindBy(id = "ctl00_Content_RegularExpressionValidator5")
    public WebElement EmailIdErrmsg;


    public  void SetEmpname(String empname){

        Employeename.sendKeys(empname);
        Mobileno.click();

    }

    public  void SetMobileno(String mobno){

        Mobileno.sendKeys(mobno);
        EmailID.click();


    }

    public  void SetEmailid(String email){

        EmailID.sendKeys(email);
        Mobileno.click();

    }

    public  void SetCredentials(String Employee,String Mobilenum , String Email ){

        Employeename.sendKeys(Employee);
        Mobileno.sendKeys(Mobilenum);
        EmailID.sendKeys(Email);

    }


    public void savebutton(){

        Save.click();

    }

    public void Uploadbutton(){

        upload.click();

    }

    public void ExportButton(){

        Export.click();

    }

    public void Choosefile(){

        Choosefile.click();

    }

    public  String EmployeenameTextBoxErrormsg(){


        String errmsg1 = EmployeenameErrmsg.getText();

        return errmsg1;
    }

    public  String mobilenumTextBoxErrormsg(){


        String errmsg2 = mobilenumErrmsg.getText();

        return errmsg2;
    }

    public String EmailIDTextBoxErrormsg(){


        String errmsg3 = EmailIdErrmsg.getText();

        return errmsg3;
    }


    public void clickModule(){

       this.Bandhuprocess.click();
       this.UploadbandhuDocs.click();
    }


    //TextBox Validation
    public void TextboxValidate(int value,String errmsg,int row , int cell) throws IOException {


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


    public void Validate(String errmsg,int row , int column) throws IOException {

        if(driver.getPageSource().contains(errmsg)){


            Assert.assertTrue(true);
            xlcon.setCellValue(row,column,"TestCase Passed",excelfilepath);


        }else{

            Assert.assertTrue(false);
            xlcon.setCellValue(row,column,"TestCase Failed",excelfilepath);

        }

    }



}
