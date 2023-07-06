package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void test_loginDDT(String email, String password, String exp){
        logger.info("*** Starting TC_003_LoginDDT ***");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            LoginPage lp = new LoginPage(driver);
            lp.setEmail(email);
            lp.setPassword(rb.getString(password));
            lp.clickLoginButton();

            MyAccountPage myacc = new MyAccountPage(driver);
            boolean targetPage = myacc.isMyAccountPageExists();
            Assert.assertEquals(targetPage,true);

            if(exp.equals("Valid")){
                if(targetPage==true){
                    myacc.clickLogout();
                    Assert.assertTrue(true);
                }else{
                    Assert.assertTrue(false);
                }
            }
            if(exp.equals("Invalid")){
                if(targetPage){
                    myacc.clickLogout();
                    Assert.assertTrue(false);
                }else{
                    Assert.assertTrue(true);
                }
            }
            logger.info("*** Finished TC_003 ***");

        } catch (Exception e) {
            Assert.fail();
        }


    }

}
