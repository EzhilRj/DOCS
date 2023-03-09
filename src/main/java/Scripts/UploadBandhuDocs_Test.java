package Scripts;

import PageObjects.UploadBandhuDocsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

import static PageObjects.UploadBandhuDocsPage.*;
import static Utils.Constant.*;
import static Utils.DBConfig.ConnectDB;
import static Utils.XLConfig.setExcelFile;

public class UploadBandhuDocs_Test extends BaseClass {

    public static  String Specialchar = GetRandomSpecialCharacters();
    public static  String Randomnum = GetRandomNumber();
    public static  String Randomstring = GetRandomString();

    @Test(priority = 1)
    public static void UploadbandhuDocsSheetsetter() throws IOException {

        setExcelFile(filepath, "UploadBandhuDocs");
        log.info("UploadBandhuDocs");

    }

    @Test(priority = 2)
    public void TC_001_Verify_EmployeenameTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        log.info("TC_001_Verify_EmployeenameTextBox_with_SpecialCharacters");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetEmpname(Specialchar);
        TextboxValidate(1, xlcon.getCellData(1, 2), 1, 3);

    }

    @Test(priority = 3)
    public void TC_002_Verify_EmployeenameTextBox_with_Numbers() throws InterruptedException, IOException {

        log.info("TC_002_Verify_EmployeenameTextBox_with_Numbers");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.SetEmpname(Randomnum);
        TextboxValidate(1, xlcon.getCellData(2, 2), 2, 3);

    }

    @Test(priority = 4)
    public void TC_003_Verify_MobileNumberTextBox_with_Characters() throws InterruptedException, IOException {

        log.info("TC_003_Verify_MobileNumberTextBox_with_Characters");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.SetMobileno(Randomstring);
        TextboxValidate(2, xlcon.getCellData(3, 2), 3, 3);

    }

    @Test(priority = 5)
    public void TC_004_Verify_MobileNumberTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        log.info("TC_004_Verify_MobileNumberTextBox_with_SpecialCharacters");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.SetMobileno(Specialchar);
        TextboxValidate(2, xlcon.getCellData(4, 2), 4, 3);

    }


    @Test(priority = 6)
    public void TC_005_Verify_EmailID_With_InValidEmail() throws InterruptedException, IOException {

        log.info("TC_005_Verify_EmailID_With_InValidEmail");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.SetEmailid(Randomstring);
        TextboxValidate(3, xlcon.getCellData(5, 2), 5, 3);

    }

    @Test(priority = 7)
    public void TC_006_Verify_User_is_Created() throws InterruptedException, IOException {

        log.info("TC_006_Verify_User_is_Created");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetCredentials(xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1));
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(6, 2), 6, 3);

    }

    @Test(priority = 8)
    public void TC_007_Verify_Duplicate_Mobileno_EmailID() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        log.info("TC_007_Verify_Duplicate_Mobileno_EmailID");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetCredentials(xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1));
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(14,2),14,3);
        UploadBandhuDocsPage.Mobileno.clear();
        UploadBandhuDocsPage.Mobileno.sendKeys("6383421429");
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(15,2),15,3);

    }

    @Test(priority = 9)
    public void TC_008_Verify_Userdata_is_Stored_in_Database() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        log.info("TC_008_Verify_Userdata_is_Stored_in_Database");
        ConnectDB(1,xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1), 10, 3);

    }



    @Test(priority = 10)
    public void TC_009_Verify_FileUpload() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        log.info("TC_009_Verify_FileUpload");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        uploadfile(Uploadinglocation+"UploadBandhuDocs.csv");
        UploadBandhuDocsPage.Uploadbutton();
        Validate(xlcon.getCellData(11,2),11,3);

    }

    @Test(priority = 11)
    public void TC_010_Verify_UploadedData_is_Stored_in_Database() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        log.info("TC_010_Verify_UploadedData_is_Stored_in_Database");
        ConnectDB(1, xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1), 12, 3);

    }

    @Test(priority = 12)
    public void TC_011_Verify_ExporButton() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        log.info("TC_011_Verify_ExporButton");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.ExportButton();
        Thread.sleep(1000);
        ValidateDownloaded(10, 3);

    }

    @Test(priority = 13)
    public void TC_012_Verify_UploadButton_Without_Selecting_File() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        log.info("TC_012_Verify_UploadButton_Without_Selecting_File");
        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.Uploadbutton();
        Validate(xlcon.getCellData(14,2),14,3);

    }

    @Test(priority = 14)
    public void TC_013_Verify_with_EmptyExcel() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        uploadfile(Uploadinglocation+"EmptyUploadBandhuDocs.csv");
        UploadBandhuDocsPage.Uploadbutton();

    }

    @Test(priority = 15)
    public void TC_014_Verify_TextBoxErrorMessages() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(17,2),17,3);
        UploadBandhuDocsPage.SetCredentials(xlcon.getCellData(6, 1),"","");
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(18,2),18,3);
        UploadBandhuDocsPage.SetCredentials("",xlcon.getCellData(7, 1),"");
        UploadBandhuDocsPage.savebutton();
        Validate(xlcon.getCellData(19,2),19,3);

    }

}

    
