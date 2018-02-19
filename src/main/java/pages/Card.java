package pages;

import core.Conditions;
import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;

public class Card extends MethodsFactory{

    public Elem addMemberBtn = new Elem(By.cssSelector("a.js-change-card-members"),
            "Add Member");
    private Elem addedMembers = new Elem(By.cssSelector(".js-card-detail-members-list .member"));
    private Elem addedMembersOnBoard = new Elem(By.cssSelector("li.item.active"));
    private Elem notAddedMembers =
            new Elem(By.cssSelector(".pop-over-section.js-board-members > ul li:not(.active)"));
    private Elem closeMemberWndBtn = new Elem(By.cssSelector(".pop-over-header-close-btn"));
    private Elem commentFld = new Elem(By.cssSelector(".comment-frame .comment-box textarea"));
    public Elem lastAddedComment = new Elem(By.cssSelector(".js-list-actions div:nth-child(1)  .comment-container .current-comment"));
    private Elem saveBtn = new Elem(By.cssSelector("input.confirm"));
    private Elem textFld = new Elem(By.cssSelector("input.js-search-mem"));


    private Conditions condition = new Conditions();

    public void selectNotAddedMember(){
        notAddedMembers.finds().get(0).click();
    }

    public void unselectMember(){
        addedMembersOnBoard.finds().get(0).click();
    }

    public void closeMemberWindow(){
        closeMemberWndBtn.click();
    }

    public int getAddedMembers(){
        return addedMembers.finds().size();
    }

    public void fillCommentFld(String text){
        condition.waitForElementToBeShown(commentFld);
        commentFld.type(text);
    }

    public void openMembersWindow(){
        condition.waitForElementToBeShown(addMemberBtn);
        addMemberBtn.click();
    }

    public void save(){
        saveBtn.click();
    }

    public void fignya(){
        textFld.type("sdfsdf");
    }
}
