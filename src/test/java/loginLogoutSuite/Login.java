package loginLogoutSuite;

import core.BrowserFactory;
import helpers.SerializationWorker;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.LoginPage;

import java.util.Set;

public class Login extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Test(dataProvider = "emailAndPass")
    public void login(String email, String pass){
       loginPage.open();
       loginPage.login(email, pass);

       Assert.assertTrue(boardsPage.boardSection.isPresent(), "Board page is not opened!");
    }

    @Test(dataProvider = "PemailAndPass")
    public void getCookiesForFutureLogin(String email, String pass) throws InterruptedException {
        loginPage.saveCookies(email, pass);
    }
}
