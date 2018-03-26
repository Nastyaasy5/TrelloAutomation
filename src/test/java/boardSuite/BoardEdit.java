package boardSuite;

import api.TrelloApi;
import core.BrowserFactory;
import helpers.DateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;

public class BoardEdit extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardPage boardPage = new BoardPage();
    CommonPage commonPage = new CommonPage();

    @Test
    public void createBoard() throws IOException {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/");

        TrelloApi trelloApi = new TrelloApi();
        DateHelper dateHelper = new DateHelper();

        String newBoard = trelloApi.createBoard("NewBoard " + dateHelper.getCurrentDateTime());
        System.out.println(newBoard);
    }

    @Test
    public void starTheBoard(){
        loginPage.loginWithCookies();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");
        boardPage.starTheBoard();
        commonPage.openMenu();

        Assert.assertTrue(commonPage.getStarredBoardNames().contains("ListsForDeleting"));
    }
}
