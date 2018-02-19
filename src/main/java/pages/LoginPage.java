package pages;

import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;
import org.testng.Assert;

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
}
