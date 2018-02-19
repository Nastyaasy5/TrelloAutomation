package accountSettingsSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AccountSettingsEdit extends BrowserFactory{

    LoginPage loginPage = new LoginPage();
    BoardsPage boardsPage = new BoardsPage();
    AccountPage accountPage = new AccountPage();

    @Test(dataProvider = "emailAndPass")
    public void changeNotificationEmailFrequency(String email, String pass){
        loginPage.open();
        loginPage.login(email, pass);
        boardsPage.waitForPageToBeLoaded();
        driver().get("https://trello.com/nastya593/account");
        accountPage.openSendEmailWnd();

        String selectedFreq = accountPage.getSelectedEmailFreq();
        accountPage.changeEmailFreq();
        accountPage.openSendEmailWnd();

        Assert.assertNotEquals(selectedFreq, accountPage.getSelectedEmailFreq(),
                "Email frequency was not changed!");


    }
}
