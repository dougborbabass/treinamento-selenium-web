package entities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver navegador;
    public String url;
    public WebDriver driver;

    @BeforeClass
    public void preCond() {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        navegador = new ChromeDriver(chromeOptions);
        navegador.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        url = "C:\\Users\\douglas.borba\\Desktop\\prova_testes\\QA\\projetoPageObject\\src\\main\\resources\\componentes.html";
        navegador.get(url);
    }

    @AfterClass
    public void posCond() {
        navegador.quit();
    }

    protected WebDriver getNavegador() {
        return navegador;
    }
}
