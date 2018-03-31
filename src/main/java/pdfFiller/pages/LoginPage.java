package pdfFiller.pages;

import core.Elem;
import core.MethodsFactory;
import helpers.SerializationWorker;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class LoginPage extends MethodsFactory{

    private String pageUrl = "https://www.pdffiller.com/en/login.htm";

    public Elem emailFld = new Elem(By.cssSelector("#login-enter [name=username]"));
    private Elem passwordFld = new Elem(By.cssSelector("#login-enter [name=password]"));
    private Elem loginBtn = new Elem(By.cssSelector("#form-login-submit"));

    public void login(String email, String password){
        emailFld.type(email);
        passwordFld.type(password);
        loginBtn.click();
    }

    public void open(){
        driver().get(pageUrl);
    }

    public void loginWithCookies() {
        open();

        Set<Cookie> cookies = (Set<Cookie>) SerializationWorker.deserializeStorage("pdFillerCookies");
        for(Cookie cookie : cookies){
            driver().manage().addCookie(cookie);
        }
    }

    public void saveCookies(String email, String pass) throws InterruptedException {
        // Save Cookies to file
        open();
        login(email, pass);
        Thread.sleep(1000);

        Set<Cookie> cookies = driver().manage().getCookies();
        SerializationWorker.serializeStorage(cookies, "pdFillerCookies");
    }
}
