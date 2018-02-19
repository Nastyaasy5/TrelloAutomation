package loginLogoutSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;

public class Logout extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();

    @Test(dataProvider = "emailAndPass")
    public void login(String email, String pass){
        loginPage.open();
        loginPage.login(email, pass);

        commonPage.logOut();

        Assert.assertTrue(driver().getCurrentUrl().contains("logged-out"),
                "User was not logged out!");
    }
}
