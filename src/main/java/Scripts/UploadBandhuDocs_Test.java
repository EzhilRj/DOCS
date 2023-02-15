package Scripts;

import PageObjects.LoginPage;
import PageObjects.UploadBandhuDocsPage;
import Utils.UploadConfig;
import Utils.XLConfig;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static PageObjects.UploadBandhuDocsPage.ValidateDownloaded;
import static Utils.Constant.*;
import static Utils.DBConfig.ConnectDB;
import static Utils.XLConfig.setExcelFile;

public class UploadBandhuDocs_Test extends BaseClass {


    @Test(priority = 1)
    public static void UploadbandhuDocsSheetsetter() throws IOException {

        setExcelFile(filepath, "UploadBandhuDocs");

    }

    @Test(priority = 2)
    public void TC_001_Verify_EmployeenameTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        xlcon.setCellValue(1, 1, GetRandomSpecialCharacters(), excelfilepath);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetEmpname(xlcon.getCellData(1, 1));
        UploadBandhuDocsPage.TextboxValidate(1, xlcon.getCellData(1, 2), 1, 3);

    }

    @Test(priority = 3)
    public void TC_002_Verify_EmployeenameTextBox_with_Numbers() throws InterruptedException, IOException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        xlcon.setCellValue(2, 1, GetRandomNumber(), excelfilepath);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetEmpname(xlcon.getCellData(2, 1));
        UploadBandhuDocsPage.TextboxValidate(1, xlcon.getCellData(2, 2), 2, 3);

    }

    @Test(priority = 4)
    public void TC_003_Verify_MobileNumberTextBox_with_Characters() throws InterruptedException, IOException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        xlcon.setCellValue(3, 1, GetRandomString(), excelfilepath);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetMobileno(xlcon.getCellData(3, 1));
        UploadBandhuDocsPage.TextboxValidate(2, xlcon.getCellData(3, 2), 3, 3);

    }

    @Test(priority = 5)
    public void TC_004_Verify_MobileNumberTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        xlcon.setCellValue(4, 1, GetRandomSpecialCharacters(), excelfilepath);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetMobileno(xlcon.getCellData(4, 1));
        UploadBandhuDocsPage.TextboxValidate(2, xlcon.getCellData(4, 2), 4, 3);

    }


    @Test(priority = 6)
    public void TC_005_Verify_EmailID_With_InValidEmail() throws InterruptedException, IOException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        xlcon.setCellValue(5, 1, GetRandomString(), excelfilepath);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetEmailid(xlcon.getCellData(5, 1));
        UploadBandhuDocsPage.TextboxValidate(3, xlcon.getCellData(5, 2), 5, 3);


    }

    @Test(priority = 7)
    public void TC_006_Verify_User_is_Created() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetCredentials(xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1));
        UploadBandhuDocsPage.savebutton();
        UploadBandhuDocsPage.Validate(xlcon.getCellData(6, 2), 6, 3);

    }

    @Test(priority = 8)
    public void TC_007_Verify_Duplicate_Mobileno_EmailID() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.SetCredentials(xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1));
        UploadBandhuDocsPage.savebutton();
        UploadBandhuDocsPage.Validate(xlcon.getCellData(14,2),14,3);
        UploadBandhuDocsPage.Mobileno.clear();
        UploadBandhuDocsPage.Mobileno.sendKeys("6383421429");
        UploadBandhuDocsPage.savebutton();
        UploadBandhuDocsPage.Validate(xlcon.getCellData(15,2),15,3);

    }

    @Test(priority = 9)
    public void TC_008_Verify_Userdata_is_Stored_in_Database() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        ConnectDB(xlcon.getCellData(9, 1), xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1), 9, 3);

    }



    @Test(priority = 10)
    public void TC_009_Verify_FileUpload() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadConfig.uploadfile(Uploadinglocation+"UploadBandhuDocs.csv");
        UploadBandhuDocsPage.Uploadbutton();
        UploadBandhuDocsPage.Validate(xlcon.getCellData(11,2),11,3);

    }

    @Test(priority = 11)
    public void TC_010_Verify_UploadedData_is_Stored_in_Database() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        ConnectDB(xlcon.getCellData(12, 1), xlcon.getCellData(6, 1), xlcon.getCellData(7, 1), xlcon.getCellData(8, 1), 12, 3);

    }

    @Test(priority = 12)
    public void TC_011_Verify_ExporButton() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.ExportButton();
        Thread.sleep(1000);
        ValidateDownloaded(10, 3);

    }

    @Test(priority = 13)
    public void TC_012_Verify_UploadButton_Without_Selecting_File() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {


        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadBandhuDocsPage.Uploadbutton();
        UploadBandhuDocsPage.Validate(xlcon.getCellData(13,2),13,3);

    }

    @Test(priority = 14)
    public void TC_013_Verify_with_EmptyExcel() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();
        UploadConfig.uploadfile(Uploadinglocation+"EmptyUploadBandhuDocs.csv");
        UploadBandhuDocsPage.Uploadbutton();

    }

    @Test(priority = 15)
    public void TC_014_Verify_TextBoxErrorMessages() throws InterruptedException, IOException, SQLException, ClassNotFoundException, AWTException {

        PageFactory.initElements(driver, UploadBandhuDocsPage.class);
        UploadBandhuDocsPage.clickModule();

        UploadBandhuDocsPage.savebutton();
    }

}

    
