package Scripts;

import PageObjects.Bandhu_DocsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;

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
        Bandhu_DocsPage.ValidateAuditscreen(5,7,3);

    }

    @Test
    public void TC_008_Verify_BankDetails() throws IOException, InterruptedException {



    }








}