package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "txtUsername")
    public static WebElement username;

    @FindBy(name = "txtPassword")
    public static WebElement password;

    @FindBy(name = "txtClient")
    public static WebElement Company;

    @FindBy(name = "btnLogin")
    public static WebElement loginButton;

    public static void SetLoginCredentials(String Username,String Password,String company){

        username.sendKeys(Username);
        password.sendKeys(Password);
        Company.sendKeys(company);
        loginButton.click();
    }


}
