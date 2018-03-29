package apiTests;

import api.TrelloApi;
import core.BrowserFactory;
import helpers.DateHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.BoardsPage;
import pages.CommonPage;
import pages.LoginPage;

import java.io.IOException;

public class BoardEditApi extends BrowserFactory {

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();

    @Test
    public void createBoard() throws IOException {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/");
        int boardsBefore = boardsPage.getAllPersonalBoards();

        TrelloApi trelloApi = new TrelloApi();
        DateHelper dateHelper = new DateHelper();

        trelloApi.createBoard("NewBoard " + dateHelper.getCurrentDateTime());
        int boardsAfter = boardsPage.getAllPersonalBoards();

        Assert.assertTrue(boardsBefore<boardsAfter,
                "Board was not added!");
    }

    @Test
    public void deleteBoard() throws IOException {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/");
        int boardsBefore = boardsPage.getAllPersonalBoards();

        TrelloApi trelloApi = new TrelloApi();
        trelloApi.deleteBoard("vkbW3T2g");
        int boardsAfter = boardsPage.getAllPersonalBoards();

        Assert.assertTrue(boardsBefore>boardsAfter,
                "Board was not removed!");
    }
}
