package commonSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CommonTests extends BrowserFactory{

    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();

    @Test
    public void alwaysKeepMenuOpenFunctionality() {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/");
        commonPage.applyAlwaysKeepThisMenuOpen();

        driver().get("https://trello.com/b/hoj4EOpw/testboard");

        Assert.assertTrue(commonPage.boardsMenu.isPresent(),
                "Menu is not shown!");
    }
}
