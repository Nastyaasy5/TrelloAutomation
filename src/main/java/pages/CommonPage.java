package pages;

import core.Elem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CommonPage {

    private Elem boardsBtn = new Elem(By.cssSelector(".js-boards-menu"));
    private Elem keepMenuOpenBtn = new Elem(By.cssSelector(".quiet-button.js-pin"));
    public Elem boardsMenu = new Elem(By.cssSelector(".boards-drawer-pinned"));
    public Elem starredBoards = new Elem(By.cssSelector(".starred-sidebar-boards-list " +
            ".compact-board-tile-link-text-name"));
    private Elem memberIcon = new Elem(By.cssSelector(".member"));
    private Elem logOutBtn = new Elem(By.cssSelector(".js-logout"));

    public void applyAlwaysKeepThisMenuOpen(){
        openMenu();
        keepMenuOpenBtn.click();
    }

    public void openMenu(){
        boardsBtn.click();
    }

    public List<String> getStarredBoardNames(){
        List<String> starredBoardNames = new ArrayList<>();
        for(WebElement board: starredBoards.finds()){
            starredBoardNames.add(board.getText());
        }
        return starredBoardNames;
    }

    public void openMemberMenu(){
        memberIcon.click();
    }

    public void logOut(){
        openMemberMenu();
        logOutBtn.click();
    }
}
