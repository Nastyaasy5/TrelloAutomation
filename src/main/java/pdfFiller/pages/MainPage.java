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
    private Elem form = new Elem(By.cssSelector(".modal-container.myforms-modal"));
    private Elem duplicate = new Elem(By.cssSelector(".modal-actions-btns.text-right > button.btn.-sm.-orange"));
    private Elem docs = new Elem(By.cssSelector(".react-contextmenu-wrapper"));
    private Elem folders = new Elem(By.cssSelector(".mf-sb-folders-list ul li"));
    private Elem createFolder = new Elem(By.cssSelector("[data-test-context-button=ADD_FOLDER][data-tip=\"Create Folder\""));
    private Elem createFolderBtn = new Elem(By.cssSelector(".text-right > button.btn.-sm.-orange"));

    public int getAllDocsOnPage(){
        return docs.finds().size();
    }
    public int getAllFoldersOnPage(){
        return folders.finds().size();
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
        wait.until(ExpectedConditions.visibilityOf(form.find()));
        duplicate.click();
    }

    public void createFolder(){
        WebDriverWait wait = new WebDriverWait(driver(), 6, 300);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".g-loader__circle")));
        createFolder.click();
        wait.until(ExpectedConditions.visibilityOf(form.find()));
        createFolderBtn.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".g-loader__circle")));
    }
}
