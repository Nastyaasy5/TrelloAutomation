package core;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

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

    @AfterTest
    public void tearDown(){
        driver().quit();
    }
}
