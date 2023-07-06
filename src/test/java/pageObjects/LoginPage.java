package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-email")
    WebElement emailTxt;

    @FindBy(id="input-password")
    WebElement passwordTxt;

    @FindBy(xpath = "//type[text()='Login']")
    WebElement loginBtn;


    public void setEmail(String email){
        emailTxt.sendKeys(email);
    }
    public void setPassword(String password){
        passwordTxt.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }



}
