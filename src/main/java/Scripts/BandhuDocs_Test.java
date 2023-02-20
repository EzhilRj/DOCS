package Scripts;

import PageObjects.Bandhu_DocsPage;
import PageObjects.UploadBandhuDocsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static Scripts.BaseClass.driver;
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
        Bandhu_DocsPage.Clickmodule();
        Bandhu_DocsPage.Validatetitle(1,1,1,3);

    }

    @Test
    public void TC_002_Employee_DataisShowing() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Clickmodule();
        driver.switchTo().frame("myIframe");
        Bandhu_DocsPage.Validatedata(2,3);

    }

    @Test
    public void TC_003_Verify_AuditScreen_is_Showing() throws IOException {

        PageFactory.initElements(driver, Bandhu_DocsPage.class);
        Bandhu_DocsPage.Eye.click();
        Bandhu_DocsPage.ValidateAuditscreen(3,3);

    }




}