package pages;

import core.Elem;
import org.openqa.selenium.By;

public class AccountPage {

    private Elem changeEmailFreqBtn = new Elem(By.cssSelector(".js-change-email-freq"));
    private Elem selecteFreq = new Elem(By.xpath("//span[contains(@class, 'icon-check')]/.."));
    private Elem notSelectedFreq = new Elem(By.xpath("//ul[@class='pop-over-list']" +
            "//span[1][not(contains(@class, 'icon-check'))]/.."));

    public void openSendEmailWnd(){
        changeEmailFreqBtn.click();
    }

    public String getSelectedEmailFreq(){
        return selecteFreq.getText();
    }

    public void changeEmailFreq(){
        notSelectedFreq.finds().get(0).click();
    }
}
