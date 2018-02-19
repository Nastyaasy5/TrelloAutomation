package pages.windows;

import core.Elem;
import core.MethodsFactory;
import helpers.DateHelper;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListActionsWnd extends MethodsFactory {

    private Elem copyListBtn = new Elem(By.cssSelector(".js-copy-list"));
    private Elem nameFld = new Elem(By.cssSelector("textarea[name='name']"));
    private Elem createListBtn = new Elem(By.cssSelector("input.js-submit"));
    private Elem archiveListBtn = new Elem(By.cssSelector(".js-close-list"));

    DateHelper dateHelper = new DateHelper();

    public void copyList(){
        copyListBtn.click();
        nameFld.type("CopiedList " + dateHelper.getCurrentDateTime());
        createListBtn.click();
    }

    public void archiveList(){
        archiveListBtn.click();
    }
}
