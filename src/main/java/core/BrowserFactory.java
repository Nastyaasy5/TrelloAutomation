package core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BrowserFactory extends MethodsFactory {

    @BeforeTest
    public void setUp(){
        DRIVER.set(new ChromeDriver());
    }


    @DataProvider(name = "emailAndPass")
    public Object[][] emailPassProvider() {
        return new Object[][]{
                {"nastya.kuzorova@gmail.com", "Nastyusha35"},
        };
    }

    @DataProvider(name = "pdFillerEmailAndPass")
    public Object[][] pdFillerEmailPassProvider() {
        return new Object[][]{
                {"nastya.kuzorova@gmail.com", "Nastyaasy5"},
        };
    }

    @AfterTest
    public void tearDown(){
        driver().quit();
    }
}
