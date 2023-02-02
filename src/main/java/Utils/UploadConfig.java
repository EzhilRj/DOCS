package Utils;

import Scripts.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadConfig extends BaseClass {

    public static void uploadfile(String Path) throws AWTException, InterruptedException {

        Thread.sleep(800);
        WebElement uploadPhotoBtn = driver.findElement(By.xpath("//*[@type=\"file\"]"));
        uploadPhotoBtn.sendKeys(Path);

    }

}
