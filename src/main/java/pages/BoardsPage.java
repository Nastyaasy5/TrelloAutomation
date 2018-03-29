package pages;

import core.Conditions;
import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardsPage extends MethodsFactory {

    public Elem boardSection = new Elem(By.cssSelector(".boards-page-board-section:nth-child(1)"));
    private Elem personalBoards = new Elem(By.cssSelector(".boards-page-board-section:nth-child(1) li"));

    private Conditions condition = new Conditions();

    public void waitForPageToBeLoaded() {
        condition.waitForElementToBeShown(boardSection);
    }

    public int getAllPersonalBoards(){
        return personalBoards.finds().size();
    }
}
