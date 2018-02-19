package pages;

import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;

public class BoardPage extends MethodsFactory {

    private Elem extrasMenuBtn = new Elem(By.cssSelector("#board .js-list:first-child .list .list-header-extras"));
    public Elem lists = new Elem(By.cssSelector(".list.js-list-content"));
    private Elem boardStar = new Elem(By.cssSelector(".icon-star.board-header-btn-icon"));

    public void openExtrasMenu(){
        extrasMenuBtn.click();
    }

    public int getAllLists(){
        return lists.finds().size();
    }

    public void starTheBoard(){
        boardStar.click();
    }
}
