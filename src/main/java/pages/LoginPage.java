package pages;

import core.Elem;
import core.MethodsFactory;
import helpers.SerializationWorker;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginPage extends MethodsFactory {

    private String pageUrl = "https://trello.com/login";

    private Elem emailFld = new Elem(By.cssSelector("input#user"), "Email Field");
    private Elem passwordFld = new Elem(By.cssSelector("input#password"), "User Password");
    private Elem loginBtn = new Elem(By.cssSelector("input#login"),"Submit Button");

    public void open(){
        driver().get(pageUrl);
    }

    public void login(String email, String password){
        emailFld.type(email);
        passwordFld.type(password);
        loginBtn.click();
    }

    public void saveCookies(String email, String pass) throws InterruptedException {
        // Save Cookies to file
        open();
        login(email, pass);
        Thread.sleep(1000);

        Set<Cookie> cookies = driver().manage().getCookies();
        SerializationWorker.serializeStorage(cookies, "trelloCookies");
    }

    public void loginWithCookies() {
        open();

        Set<Cookie> cookies = (Set<Cookie>) SerializationWorker.deserializeStorage("trelloCookies");
        for(Cookie cookie : cookies){
            driver().manage().addCookie(cookie);
        }
    }
}
