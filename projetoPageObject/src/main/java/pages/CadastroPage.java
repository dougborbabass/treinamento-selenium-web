package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage extends BasePage {


    @FindBy(id = "elementosForm:nome")
    WebElement nomeTextField;
    @FindBy(id = "elementosForm:sobrenome")
    WebElement sobrenomeTextField;
    @FindBy(id = "elementosForm:sexo:0")
    WebElement SexoRadioButton;
    @FindBy(id = "elementosForm:comidaFavorita:0")
    WebElement comidaCheck;
    @FindBy(id = "elementosForm:escolaridade")
    WebElement escolaridadeComboBox;
    @FindBy(id = "elementosForm:esportes")
    WebElement esporteComboBox;
    @FindBy(id = "elementosForm:sugestoes")
    WebElement sugestoesTextArea;
    @FindBy(id = "elementosForm:cadastrar")
    WebElement cadastrarButton;
    @FindBy(xpath = "//*[@id='resultado']/span")
    WebElement msgSucesso;
    @FindBy(xpath = "//*[@id='descNome']/span")
    WebElement nomeResultado;
    @FindBy(xpath = "//*[@id='descSobrenome']/span")
    WebElement sobreNomeResultado;
    @FindBy(xpath = "//*[@id='descSexo']/span")
    WebElement sexoResultado;
    @FindBy(xpath = "//*[@id='descComida']/span")
    WebElement comidaFavoritaResultado;
    @FindBy(xpath = "//*[@id='descEscolaridade']/span")
    WebElement escolaridadeResultado;
    @FindBy(xpath = "//*[@id='descEsportes']/span")
    WebElement esporteResultado;
    @FindBy(xpath = "//*[@id='descSugestoes']/span")
    WebElement sugestoesResultado;


    public CadastroPage(WebDriver navegador) {
        super(navegador);
    }

    public CadastroPage preencherNome(String nome) {
        nomeTextField.sendKeys(nome);
        return this;
    }

    public CadastroPage preencherSobrenome(String sobrenome) {
        sobrenomeTextField.sendKeys(sobrenome);
        return this;
    }

    public CadastroPage informarSexo() {
        SexoRadioButton.click();
        return this;
    }

    public CadastroPage informarComida() {
        comidaCheck.click();
        return this;
    }

    public CadastroPage selecionarEscolaridade(String escolaridade) {
        new Select(escolaridadeComboBox).selectByVisibleText(escolaridade);
        return this;
    }

    public CadastroPage selecionarEsporte(String esporte) {
        new Select(esporteComboBox).selectByVisibleText(esporte);
        return this;
    }

    public CadastroPage preenchersugestoes(String sugestao) {
        sugestoesTextArea.sendKeys(sugestao);
        return this;
    }

    public CadastroPage clicarCadastrar() {
        cadastrarButton.click();
        return this;
    }

    public String verificaCadastrado() {
        return mWait(msgSucesso).getText();
    }

    public String verificaNomeCadastrado() {
        return mWait(nomeResultado).getText();
    }

    public String verificaSobreNomeCadastrado() {
        return mWait(sobreNomeResultado).getText();
    }

    public String verificaSexoCadastrado() {
        return mWait(sexoResultado).getText();
    }

    public String verificaComidaCadastrada() {
        return mWait(comidaFavoritaResultado).getText();
    }

    public String verificaescolariadaCadastrada() {
        return mWait(escolaridadeResultado).getText();
    }

    public String verificaEsporteCadastrado() {
        return mWait(esporteResultado).getText();
    }

    public String verificasugestaoCadastrada() {
        return mWait(sugestoesResultado).getText();
    }

    public String capturarTextoAlerta() {
        return navegador.switchTo().alert().getText();
    }

    public CadastroPage aceitarAlerta() {
        navegador.switchTo().alert().accept();
        return this;
    }
}