package cardEditSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.Card;
import pages.LoginPage;

public class CardEdit extends BrowserFactory{
    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    Card card = new Card();

    @Test(dataProvider = "emailAndPass")
    public void addMember(String email, String login) {
        loginPage.open();
        loginPage.login(email, login);
        boardsPage.waitForPageToBeLoaded();

        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        int membersBefore = card.getAddedMembers();
        card.openMembersWindow();
        card.selectNotAddedMember();
        card.closeMemberWindow();

        Assert.assertTrue(membersBefore<card.getAddedMembers(), "User was not added!");
        //TBD: Fails if no added members.
    }

    @Test(dataProvider = "emailAndPass")
    public void removeMember(String email, String login) {
        loginPage.open();
        loginPage.login(email, login);
        boardsPage.waitForPageToBeLoaded();
        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        int membersBefore = card.getAddedMembers();
        card.openMembersWindow();
        card.unselectMember();
        card.closeMemberWindow();

        Assert.assertTrue(membersBefore>card.getAddedMembers(), "User was not removed!");
        //TBD: Fails if no added members.
    }

    @Test(dataProvider = "emailAndPass")
    public void addComment(String email, String login){
        String comment = "Some text is here!";

        loginPage.open();
        loginPage.login(email, login);
        boardsPage.waitForPageToBeLoaded();
        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        card.fillCommentFld(comment);
        card.save();

        Assert.assertEquals(card.lastAddedComment.getText(), comment, "Comment was not added");
    }

}
