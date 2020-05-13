package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {

    protected WebDriver navegador;

    public BasePage(WebDriver navegador) {
        this.navegador = navegador;
        PageFactory.initElements(navegador, this);
    }

    public WebElement mWait(WebElement element) {
        WebDriverWait wait = new WebDriverWait(navegador, 15);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}