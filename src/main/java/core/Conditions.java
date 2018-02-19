package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.MethodsFactory.driver;

public class Conditions {

    public void waitForElementToBeShown(Elem element){
        WebDriverWait wait = new WebDriverWait(driver(), 15);
        wait.until(ExpectedConditions.visibilityOf(element.find()));
    }
}
