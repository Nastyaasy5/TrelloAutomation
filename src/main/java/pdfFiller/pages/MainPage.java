package pdfFiller.pages;

import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends MethodsFactory{
    public Elem AddDocBtn = new Elem(By.cssSelector(".mf-btn-add-doc"));
    public Elem personIcon = new Elem(By.cssSelector(".h-ac__toggle"));
    public Elem logoutBtn = new Elem(By.cssSelector(".h-ac__dropdown > a:nth-child(5)"));
    public Elem duplicateBtn = new Elem(By.cssSelector("[data-test-manage-button=DUPLICATE]"));
    private Elem duplicateForm = new Elem(By.cssSelector(".modal-container.myforms-modal"));
    private Elem duplicate = new Elem(By.cssSelector(".modal-actions-btns.text-right > button.btn.-sm.-orange"));
    private Elem docs = new Elem(By.cssSelector(".react-contextmenu-wrapper"));

    public int getAllDocsOnPage(){
        return docs.finds().size();
    }

    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver(), 6, 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".g-loader__circle")));
        personIcon.click();
        logoutBtn.click();
    }

    public void duplicate(){
        WebDriverWait wait = new WebDriverWait(driver(), 6, 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".g-loader__circle")));
        duplicateBtn.click();
        wait.until(ExpectedConditions.visibilityOf(duplicateForm.find()));
        duplicate.click();
    }


}
