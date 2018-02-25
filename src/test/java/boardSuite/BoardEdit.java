package boardSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class BoardEdit extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardPage boardPage = new BoardPage();
    CommonPage commonPage = new CommonPage();

    @Test(dataProvider = "emailAndPass")
    public void starTheBoard(String email, String pass){
        loginPage.loginWithCookies();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");
        boardPage.starTheBoard();
        commonPage.openMenu();

        Assert.assertTrue(commonPage.getStarredBoardNames().contains("ListsForDeleting"));
    }
}
