package TestCases;

import PageObjects.LoginPage;
import PageObjects.UploadBandhuDocsPage;
import Utils.XLConfig;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static Utils.DBConfig.ConnectDB;
import static Utils.XLConfig.setExcelFile;

public class UploadBandhuDocs_Test extends BaseClass {

    UploadBandhuDocsPage up = new UploadBandhuDocsPage(driver);

    @Test
    public static void UploadbandhuDocsSheetsetter() throws IOException {

        setExcelFile(filepath,"UploadBandhuDocs");

    }

    @Test
    public void TC_001_Verify_EmployeenameTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        xlcon.setCellValue(1,1,GetRandomSpecialCharacters(),excelfilepath);
        up.clickModule();
        up.SetEmpname(xlcon.getCellData(1,1));
        up.TextboxValidate(1,xlcon.getCellData(1,2),1,3);

    }

    @Test
    public void TC_002_Verify_EmployeenameTextBox_with_Numbers() throws InterruptedException, IOException {

        xlcon.setCellValue(2,1,GetRandomNumber(),excelfilepath);
        up.clickModule();
        up.SetEmpname(xlcon.getCellData(2,1));
        up.TextboxValidate(1,xlcon.getCellData(2,2),2,3);

    }

    @Test
    public void TC_003_Verify_MobileNumberTextBox_with_Characters() throws InterruptedException, IOException {

        xlcon.setCellValue(3,1,GetRandomString(),excelfilepath);
        up.clickModule();
        up.SetMobileno(xlcon.getCellData(3,1));
        up.TextboxValidate(2,xlcon.getCellData(3,2),3,3);

    }

    @Test
    public void TC_004_Verify_MobileNumberTextBox_with_SpecialCharacters() throws InterruptedException, IOException {

        xlcon.setCellValue(4,1,GetRandomSpecialCharacters(),excelfilepath);
        up.clickModule();
        up.SetMobileno(xlcon.getCellData(4,1));
        up.TextboxValidate(2,xlcon.getCellData(4,2),4,3);

    }


    @Test
    public void TC_005_Verify_EmailID_With_InValidEmail() throws InterruptedException, IOException {


        xlcon.setCellValue(5,1,GetRandomString(),excelfilepath);
        up.clickModule();
        up.SetEmailid(xlcon.getCellData(5,1));
        up.TextboxValidate(3,xlcon.getCellData(5,2),5,3);


    }

    @Test
    public void TC_006_Verify_User_is_Created() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        PageFactory.initElements(driver,UploadBandhuDocsPage.class);
        up.clickModule();
        up.SetCredentials(xlcon.getCellData(6, 1),xlcon.getCellData(7, 1),xlcon.getCellData(8, 1));
        up.savebutton();
        up.Validate(xlcon.getCellData(6,2),6,3);

    }

    @Test(dependsOnMethods = { "TC_006_Verify_User_is_Created" })
    public void TC_007_Verify_Userdata_is_Stored_in_Database() throws InterruptedException, IOException, SQLException, ClassNotFoundException {

        ConnectDB(xlcon.getCellData(9,1),xlcon.getCellData(6, 1),xlcon.getCellData(7, 1),xlcon.getCellData(8, 1),9,3);

    }

}


