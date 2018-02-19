package listEditSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardPage;
import pages.BoardsPage;
import pages.LoginPage;
import pages.windows.ListActionsWnd;

public class ListEdit extends BrowserFactory{
    LoginPage loginPage = new LoginPage();
    BoardPage boardPage = new BoardPage();
    BoardsPage boardsPage = new BoardsPage();
    ListActionsWnd listActionsWnd = new ListActionsWnd();

    @Test(dataProvider = "emailAndPass")
    public void copyList(String email, String pass){
        loginPage.open();
        loginPage.login(email, pass);
        boardsPage.waitForPageToBeLoaded();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");

        int listsBefore = boardPage.getAllLists();
        boardPage.openExtrasMenu();
        listActionsWnd.copyList();

        Assert.assertTrue(listsBefore<boardPage.lists.finds().size(),
                "List was not copied!");
    }

    @Test(dataProvider = "emailAndPass")
    public void archiveList(String email, String pass){
        loginPage.open();
        loginPage.login(email, pass);
        boardsPage.waitForPageToBeLoaded();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");

        int listsBefore = boardPage.getAllLists();
        boardPage.openExtrasMenu();
        listActionsWnd.archiveList();

        Assert.assertTrue(listsBefore>boardPage.lists.finds().size(),
                "List was not delited!");
    }

}
