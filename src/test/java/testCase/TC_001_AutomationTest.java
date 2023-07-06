package testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

import javax.swing.*;

public class TC_001_AutomationTest extends BaseClass{



    @Test
    void test_account_Registration(){
        try {
            logger.debug("APPLICATION LOGS....");
            logger.info("*** starting TC_001_AccountRegistrationTest ***");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("clicked on my account");
            hp.clickRegister();
            logger.info("Clicked on register link");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            regpage.setFirstname("abc");
            regpage.setLastname("xyz");
            regpage.setEmail(randomAlphaNumeric() + "@admin.com");
            regpage.setPassword(rb.getString("password"));
            regpage.clickPrivacyButton();
            regpage.clickContinue();
            logger.info("clicked on continue");
            Assert.assertEquals(regpage.getConfirmationMsg(),"Your Account Has Been Created!", "not getting expected message");
        } catch (Exception e) {
            logger.error("error");
            Assert.fail();
            e.printStackTrace();
        }

    }




}
