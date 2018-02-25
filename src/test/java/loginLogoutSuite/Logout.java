package loginLogoutSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.LoginPage;

public class Logout extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();

    @Test
    public void login(){
        loginPage.loginWithCookies();
        driver().get("https://trello.com/");

        commonPage.logOut();

        Assert.assertTrue(driver().getCurrentUrl().contains("logged-out"),
                "User was not logged out!");
    }
}
