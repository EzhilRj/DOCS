package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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

    //AUDIT SCREEN
    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[2]")
    public static WebElement uniqueid;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[3]")
    public static WebElement Employeename;

    @FindBy(xpath = "//*[@id=\"assestsList\"]/tbody/tr/td[4]")
    public static WebElement EmailId;

    @FindBy(className = "list-inline-item")
    public static WebElement Eye;

    @FindBy(id = "singledata")
    public static WebElement Auditscreen;

    @FindBy(id = "txt_uniqueid")
    public static WebElement uniqueid1;

    @FindBy(id = "txt_employeename")
    public static WebElement Employeename1;

    @FindBy(id = "txt_mobileno")
    public static WebElement MobileNo;

    @FindBy(id = "txt_emailid")
    public static WebElement Emailid1;

    @FindBy(id = "img_aadharcardimage")
    public static WebElement Aadharimage;

    @FindBy(id = "txt_aadharcardno")
    public static WebElement Aadharno;

    @FindBy(className = "close")
    public static WebElement CloseAadharDetails;

    @FindBy(id = "img_bankimageimage")
    public static WebElement BankImage;

    @FindBy(id = "txt_bankaccountno")
    public static WebElement Bankaccno;

    @FindBy(id = "txt_ifsccode")
    public static WebElement IFSC;

    @FindBy(xpath = "//*[@id=\"myModal_AI\"]/div/div/div[1]/span")
    public static WebElement CloseBankDetails;

    @FindBy(id = "BtnApproveId")
    public static WebElement Approvebutton;

    @FindBy(id = "BtnRejectId")
    public static WebElement Rejectbutton;

    @FindBy(id = "txt_rejectRemarks")
    public static WebElement Remarks;

    //OB Initate Screen
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

    @FindBy(id = "txt_aadharcardno")
    public static WebElement AadharNo1;

    @FindBy(id = "txt_CandidateName")
    public static WebElement Employeename2;

    @FindBy(id = "txt_EmailID")
    public static WebElement Emailid2;

    @FindBy(id = "txt_MobileNumber")
    public static WebElement MobileNo1;

    @FindBy(id = "txt_BankAcNumber")
    public static WebElement BankAccountno1;

    @FindBy(id = "txt_IFSC_Code")
    public static WebElement IFSC1;

    @FindBy(id = "download_Resume")
    public static WebElement Resume;

    @FindBy(id = "BtnOB_Initiate")
    public static WebElement Obinitiate;

    @FindBy(xpath = "//*[text()='Close']")
    public static WebElement Closebutton2;

    //Events
    public static void BandhuProcess() {

        Bandhuprocess.click();
        BandhuDocs.click();
    }

    public static String GetUniqueid(){
        return uniqueid.getText();
    }

    public static String GetEmpname(){
        return Employeename.getText();
    }

    public static String GetEmailID(){
        return EmailId.getText();
    }

    public static void View(){
        Eye.click();
    }

    public static boolean ViewAuditscreen(){
        return Auditscreen.isDisplayed();
    }

    public static String Getuniqueid1(){
        return uniqueid1.getText();
    }

    public static String GetEmpname1(){
        return Employeename1.getText();
    }

    public String GetMobno(){
        return MobileNo.getText();
    }

    public static String GetEmailID1(){
        return Emailid1.getText();
    }

    public static void Aadharimg(){
        Aadharimage.click();
    }

    public static String GetAadharNo(){

        return Aadharno.getText();
    }

    public static void close(){

        CloseAadharDetails.click();
    }

    public static void Bankimg(){

        BankImage.click();
    }

    public String GetBankaccno(){
        return Bankaccno.getText();
    }

    public String GetIFSC(){
        return IFSC.getText();
    }

    public static void close1(){

        CloseBankDetails.click();
    }

    public void Approve(){
        Approvebutton.click();
    }

    public void Reject(){
        Rejectbutton.click();
    }

    public void Remarks(String remarks){
        Remarks.sendKeys(remarks);
    }

    public void SetDivision(String divisionname){
        Select div = new Select(division);
        div.selectByVisibleText(divisionname);
    }

    public void SetTown(String town){
        Select tow = new Select(TownName);
        tow.selectByVisibleText(town);
    }

    public void Setbranch(String branch){
        Select branc = new Select(Branchname);
        branc.selectByVisibleText(branch);
    }

    public void Setstate(String state){
        Select sta = new Select(statename);
        sta.selectByVisibleText(state);
    }

    public void SetRm1(String rm1){
        Select reportingmanager1 = new Select(Rm1);
        reportingmanager1.selectByVisibleText(rm1);
    }

    public void SetRm2(String rm2){
        Select reportingmanager2 = new Select(Rm2);
        reportingmanager2.selectByVisibleText(rm2);
    }

    public void SetDesignation(String Designation){
        Select design = new Select(Desig);
        design.selectByVisibleText(Designation);
    }

    public void SetCategory(String category){
        Select cat = new Select(EmpCate);
        cat.selectByVisibleText(category);
    }

    public void Setclientbranch(String clientbranch){
        Select sc = new Select(ClientBranch);
        sc.selectByVisibleText(clientbranch);
    }

    public void SETDOJ(String doj){

        DOJ.sendKeys(doj);
    }

    public void SETDOB(String dob){
        DOB.sendKeys(dob);
    }

    public static boolean GetAadhar1(){

        return AadharNo1.isDisplayed();
    }

    public String GetCandidatename(){

        return Employeename2.getText();
    }

    public String GetEmailID2(){

        return  Emailid2.getText();
    }


    public String GetMobNo1(){

        return MobileNo1.getText();
    }

    public String GetBankAccno1(){

        return BankAccountno1.getText();
    }

    public String GetIFSC1(){

        return IFSC1.getText();
    }

    public void Resume(){
        Resume.click();
    }

    public void initiate(){

        Obinitiate.click();
    }

    public void Close2(){

        Closebutton2.click();
    }

    //Validations
    public static void Validatedata(int setrow, int setcell) throws IOException {

        boolean ui = uniqueid.isDisplayed();
        boolean en = Employeename.isDisplayed();
        boolean ei = EmailId.isDisplayed();

        if (ui && en && ei) {
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

    public static void ValidateAuditscreen(int value, int setrow, int setcell, WebElement... Element1) throws IOException {

        if (value == 1) {
            if (ViewAuditscreen()) {
                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);
            } else {
                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);
            }

        } else if (value == 2) {
            if (Bandhu_DocsPage.uniqueid1.getAttribute("readonly") == null && Bandhu_DocsPage.Employeename1.getAttribute("readonly") == null &&
                    Bandhu_DocsPage.MobileNo.getAttribute("readonly") == null && Bandhu_DocsPage.Emailid1.getAttribute("readonly") == null) {

                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);

            } else {
                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);
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
                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } else if (value == 4) {

            if (GetUniqueid().equals(Getuniqueid1()) && GetEmpname().equals(GetEmpname1()) && (GetEmailID()).equals(GetEmailID1())) {
                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);
            } else {
                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);
            }

        } else if (value == 5) {

            if (Element1!=null) {

                xlcon.setCellValue(setrow, setcell, "TestCase Passed", excelfilepath);
                Assert.assertTrue(true);
            } else {

                xlcon.setCellValue(setrow, setcell, "TestCase Failed", excelfilepath);
                Assert.assertTrue(false);
            }

        }
    }


        public static void verifyimageActive(WebElement imgElement){
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



    }







