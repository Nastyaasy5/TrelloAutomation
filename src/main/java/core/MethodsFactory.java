package core;

import org.openqa.selenium.WebDriver;

public class MethodsFactory {

    static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver driver(){
        return DRIVER.get();
    }

    public boolean isElementPresent(Elem element) {
        return element.isPresent();
    }
}
