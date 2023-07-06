package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass{
    @Test
    public void test_login(){
        try {
            logger.info("starting TC_002 testcase");

            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(rb.getString("email"));
            lp.setPassword(rb.getString("password"));
            lp.clickLoginButton();

            MyAccountPage myacc = new MyAccountPage(driver);
            boolean targetPage = myacc.isMyAccountPageExists();
            Assert.assertEquals(targetPage,true);
        } catch (Exception e) {
            Assert.fail();
        }
    }



}
