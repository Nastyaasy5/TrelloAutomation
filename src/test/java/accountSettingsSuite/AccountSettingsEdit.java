package accountSettingsSuite;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class AccountSettingsEdit extends BrowserFactory{

    LoginPage loginPage = new LoginPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void changeNotificationEmailFrequency(){
        loginPage.loginWithCookies();
        driver().get("https://trello.com/nastya593/account");
        accountPage.openSendEmailWnd();

        String selectedFreq = accountPage.getSelectedEmailFreq();
        accountPage.changeEmailFreq();
        accountPage.openSendEmailWnd();

        Assert.assertNotEquals(selectedFreq, accountPage.getSelectedEmailFreq(),
                "Email frequency was not changed!");


    }
}
