package pageObjects;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement txtFirstname;

    @FindBy(id = "input-lastname")
    WebElement txtLastname;

    @FindBy(id = "input-email")
    WebElement txtEmail;

    @FindBy(id = "input-password")
    WebElement txtPassword;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyButton;

    public void setFirstname(String firstname){
        txtFirstname.sendKeys(firstname);
    }
    public void setLastname(String lastname){
        txtLastname.sendKeys(lastname);
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void clickContinue(){
        continueButton.click();
    }

    public String getConfirmationMsg() {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());

        }

    }

    public void clickPrivacyButton(){
        privacyButton.click();
    }
}
