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

    @Test
    public void addMember() {
        loginPage.loginWithCookies();

        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        int membersBefore = card.getAddedMembers();
        card.openMembersWindow();
        card.selectNotAddedMember();
        card.closeMemberWindow();

        Assert.assertTrue(membersBefore<card.getAddedMembers(), "User was not added!");
        //TBD: Fails if no added members.
    }

    @Test
    public void removeMember() {
        loginPage.loginWithCookies();
        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        int membersBefore = card.getAddedMembers();
        card.openMembersWindow();
        card.unselectMember();
        card.closeMemberWindow();

        Assert.assertTrue(membersBefore>card.getAddedMembers(), "User was not removed!");
        //TBD: Fails if no added members.
    }

    @Test
    public void addComment(){
        String comment = "Some text is here!";

        loginPage.loginWithCookies();
        driver().get("https://trello.com/c/mXgWKGIZ/1-testcard");
        card.fillCommentFld(comment);
        card.save();

        Assert.assertEquals(card.lastAddedComment.getText(), comment, "Comment was not added");
    }

}
