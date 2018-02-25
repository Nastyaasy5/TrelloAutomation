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
    ListActionsWnd listActionsWnd = new ListActionsWnd();

    @Test
    public void copyList() {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");

        int listsBefore = boardPage.getAllLists();
        boardPage.openExtrasMenu();
        listActionsWnd.copyList();

        Assert.assertTrue(listsBefore<boardPage.lists.finds().size(),
                "List was not copied!");
    }

    @Test
    public void archiveList(){
        loginPage.loginWithCookies();
        driver().get("https://trello.com/b/uUqn0ZdY/listsfordeleting");

        int listsBefore = boardPage.getAllLists();
        boardPage.openExtrasMenu();
        listActionsWnd.archiveList();

        Assert.assertTrue(listsBefore>boardPage.lists.finds().size(),
                "List was not delited!");
    }

}
