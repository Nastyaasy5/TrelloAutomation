package examFolder;

import core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pdfFiller.pages.LoginPage;
import pdfFiller.pages.MainPage;

public class PdfFillerTests extends BrowserFactory{

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(dataProvider = "pdFillerEmailAndPass")
    public void loginWithCookies(String email, String pass) throws InterruptedException {
        loginPage.saveCookies(email, pass);
    }

    @Test
    public void login(String email, String pass) throws InterruptedException {
        loginPage.loginWithCookies();
        driver().get("https://www.pdffiller.com");

        Assert.assertTrue(mainPage.AddDocBtn.isPresent());
    }

    @Test
    public void logout() throws InterruptedException {
        loginPage.loginWithCookies();
        driver().get("https://www.pdffiller.com");

        mainPage.logout();

        Assert.assertTrue(loginPage.emailFld.isPresent(), "Logout unseccessfull!");
    }

    @Test
    public void duplicateFile(){
        loginPage.loginWithCookies();
        driver().get("https://www.pdffiller.com/en/forms.htm");

        int docsBefore = mainPage.getAllDocsOnPage();
        mainPage.duplicate();
        int docsAfter = mainPage.getAllDocsOnPage();

        Assert.assertTrue(docsBefore<docsAfter, "Doc was not created!");
    }

    @Test
    public void createFolder() {
        loginPage.loginWithCookies();
        driver().get("https://www.pdffiller.com/en/forms.htm");

        int foldersBefore = mainPage.getAllFoldersOnPage();
        mainPage.createFolder();
        int foldersAfter = mainPage.getAllFoldersOnPage();

        Assert.assertTrue(foldersBefore<foldersAfter, "Folder was not created!");
    }

}
