package commonSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CommonTests extends BrowserFactory{

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    CommonPage commonPage = new CommonPage();

    @Test(dataProvider = "emailAndPass")
    public void alwaysKeepMenuOpenFunctionality(String email, String pass) {
        loginPage.open();
        loginPage.login(email, pass);
        boardsPage.waitForPageToBeLoaded();
        commonPage.applyAlwaysKeepThisMenuOpen();

        driver().get("https://trello.com/b/hoj4EOpw/testboard");

        Assert.assertTrue(commonPage.boardsMenu.isPresent(),
                "Menu is not shown!");
    }
}
