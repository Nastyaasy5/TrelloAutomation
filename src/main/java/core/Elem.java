package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

import static core.MethodsFactory.driver;

public class Elem {

    private int waitTime = 15;

    private By by;
    private String name = "";

    public Elem(By by, String name){
        this.by = by;
        this.name = name;
    }

    public Elem(By by){
        this.by = by;
    }

    public WebElement find(){
        return find(waitTime);
    }

    public WebElement find(int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        try {
            return wait.withMessage(name).until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            if (e.getCause().toString().contains("org.openqa.selenium.NoSuchElementException")) {
                NoSuchElementException ne = new NoSuchElementException("Element: '" + toString() + "' not found on page: " + driver().getCurrentUrl());
                ne.setStackTrace(e.getStackTrace());
                throw ne;
            }
            throw e;
        }
    }

    public List<WebElement> finds(){
        return finds(waitTime);
    }

    public List<WebElement> finds(int waitTime) {
        WebDriverWait wait = new WebDriverWait(driver(), waitTime);
        try {
            return wait.withMessage(name).until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (TimeoutException e) {
            if (e.getCause().toString().contains("org.openqa.selenium.NoSuchElementException")) {
                NoSuchElementException ne = new NoSuchElementException("Element: '" + toString() + "' not found on page: " + driver().getCurrentUrl());
                ne.setStackTrace(e.getStackTrace());
                throw ne;
            }
            throw e;
        }
    }

    public String getText(){
        return find().getText();
    }

    public void clear(){
        find().clear();
    }

    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    public void click(){
        find().click();
    }

    public boolean isPresent() {
        if (find().isDisplayed()) {
            return true;
        }
        return false;
    }
}
