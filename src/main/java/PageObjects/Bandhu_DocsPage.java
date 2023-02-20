package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import java.util.List;

import static Scripts.BaseClass.*;

public class Bandhu_DocsPage {

    @FindBy(xpath = "//*[text()='Bandhu Process']")
    public static WebElement Bandhuprocess;

    @FindBy(xpath = "//*[text()='Bandhu Docs']")
    public static WebElement BandhuDocs;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr")
    public static WebElement Webtable;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[2]")
    public static WebElement uniqueID;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[3]")
    public static WebElement Empname;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[4]")
    public static WebElement EmailId;

    @FindBy(className = "list-inline-item")
    public static WebElement Eye;

    @FindBy(id = "singledata")
    public static WebElement Auditscreen;

    @FindBy(id = "txt_uniqueid")
    public static WebElement uniqueid1;

    @FindBy(id = "txt_employeename")
    public static WebElement Empname1;

    @FindBy(id = "txt_mobileno")
    public static WebElement mobno;

    @FindBy(id = "txt_emailid")
    public static WebElement Emailid1;

    @FindBy(id = "img_aadharcardimage")
    public static WebElement Aadharimage;

    @FindBy(id = "txt_aadharcardno")
    public static WebElement Aadharno;

    @FindBy(id = "img_bankimageimage")
    public static WebElement bankImage;

    @FindBy(id = "txt_bankaccountno")
    public static WebElement Bankaccno;

    @FindBy(id = "txt_ifsccode")
    public static WebElement IFSC;

    @FindBy(id = "BtnApproveId")
    public static WebElement Approvebutton;

    @FindBy(id = "BtnRejectId")
    public static WebElement RejectbUtton;

    @FindBy(id = "txt_rejectRemarks")
    public static WebElement Remarks;

    @FindBy(className = "close")
    public static WebElement close;

    @FindBy(id = "txt_DivisonName")
    public static WebElement division;

    @FindBy(id = "txt_TownName")
    public static WebElement TownName;

    @FindBy(id = "txt_BranchName")
    public static WebElement Branchname;

    @FindBy(id = "txt_StateName")
    public static WebElement statename;
    @FindBy(id = "txt_ReportingManager1")
    public static WebElement Rm1;

    @FindBy(id = "txt_ReportingManager2")
    public static WebElement Rm2;

    @FindBy(id = "txt_Designation")
    public static WebElement Desig;

    @FindBy(id = "txt_EmployeeCategory")
    public static WebElement EmpCate;

    @FindBy(id = "txt_ClientBranch")
    public static WebElement ClientBranch;

    @FindBy(id = "txt_DOJ")
    public static WebElement DOJ;

    @FindBy(id = "txt_DOB")
    public static WebElement DOB;

    @FindBy(id = "txt_AadharNumber")
    public static WebElement aadharno;

    @FindBy(id = "img_AadharFrontPhoto")
    public static WebElement Aadharfront;

    @FindBy(id = "img_AadharBackPhoto")
    public static WebElement Aadharback;

    @FindBy(id = "txt_CandidateName")
    public static WebElement Candname;

    @FindBy(id = "txt_EmailID")
    public static WebElement Email;

    @FindBy(id = "txt_MobileNumber")
    public static WebElement Mno;

    @FindBy(id = "txt_BankAcNumber")
    public static WebElement bankAcno;

    @FindBy(id = "txt_IFSC_Code")
    public static WebElement ifsc;

    @FindBy(id = "txt_BankProof")
    public static WebElement bankproof;

    @FindBy(id = "download_Resume")
    public static WebElement Resume;

    @FindBy(id = "BtnOB_Initiate")
    public static WebElement Obinitiate;

    @FindBy(xpath = "//*[text()='Close']")
    public static WebElement Closebutton;


    public static void Clickmodule() {

        Bandhuprocess.click();
        BandhuDocs.click();
    }

    public String Getuniqeid(){
        return uniqueID.getText();
    }

    public String GetEmpname(){
        return Empname.getText();
    }

    public String GetEmailID(){
        return EmailId.getText();
    }

    public void View(){
         Eye.click();
    }























    public static void Validatedata(int setrow, int setcell) throws IOException {

        boolean ui = uniqueID.isDisplayed();
        boolean en = Empname.isDisplayed();
        boolean ei = EmailId.isDisplayed();

        if (ui == true && en == true && ei == true) {

            xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
            Assert.assertTrue(true);
        } else {
            xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
            Assert.assertTrue(false);

        }

    }


    public static void Validatetitle(int getrow, int getcell, int setrow, int setcell) throws IOException {

        if (driver.getCurrentUrl().contains(xlcon.getCellData(getrow, getcell))) {

            xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
            Assert.assertTrue(true);

        } else {

            xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
            Assert.assertTrue(false);

        }
    }

    public static void ValidateAuditscreen(int value, int setrow, int setcell) throws IOException {

        if (value == 1) {

            if (Auditscreen.isDisplayed()) {

                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);

            } else {

                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);

            }
        } else if (value == 2) {

            if (
                    Bandhu_DocsPage.uniqueid1.getAttribute("readonly") == null && Bandhu_DocsPage.Empname1.getAttribute("readonly") == null && Bandhu_DocsPage.mobno.getAttribute("readonly") == null && Bandhu_DocsPage.Emailid1.getAttribute("readonly") == null) {

                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);

            } else {

                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);

            }

        } else if (value == 3) {

            try {
                int invalidImageCount = 0;
                List<WebElement> imagesList = driver.findElements(By.tagName("img"));
                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);
                for (WebElement imgElement : imagesList) {
                    if (imgElement != null) {
                        verifyimageActive(imgElement);
                    }
                }
                System.out.println("Total no. of invalid images are " + invalidImageCount);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
    }


    public static void verifyimageActive(WebElement imgElement) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(imgElement.getAttribute("src"));
            HttpResponse response = client.execute(request);
            // verifying response code he HttpStatus should be 200 if not,
            // increment as invalid images count
            int invalidImageCount = 0;
            if (response.getStatusLine().getStatusCode() != 200)
                invalidImageCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void scrollPageDown(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}







