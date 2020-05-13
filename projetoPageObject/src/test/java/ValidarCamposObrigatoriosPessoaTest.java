import entities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CadastroPage;

public class ValidarCamposObrigatoriosPessoaTest extends BaseTest {

    String nome = "Douglas";
    String sobreNome = "Borba";;

    @Test
    public void deveValidarCamposObrigatoriosCadastroPessoa() {

        CadastroPage page = new CadastroPage(getNavegador());

        page.clicarCadastrar();
        Assert.assertEquals(page.capturarTextoAlerta(), "Nome eh obrigatorio");

        page.aceitarAlerta()
                .preencherNome(nome)
                .clicarCadastrar();
        Assert.assertEquals(page.capturarTextoAlerta(), "Sobrenome eh obrigatorio");

        page.aceitarAlerta()
                .preencherSobrenome(sobreNome)
                .clicarCadastrar();
        Assert.assertEquals(page.capturarTextoAlerta(), "Sexo eh obrigatorio");

        page.aceitarAlerta()
                .informarSexo()
                .clicarCadastrar();

        Assert.assertEquals(page.verificaCadastrado().toString(), "Cadastrado!");
        Assert.assertEquals(page.verificaNomeCadastrado().toString(), nome);
        Assert.assertEquals(page.verificaSobreNomeCadastrado().toString(), sobreNome);
        Assert.assertEquals(page.verificaSexoCadastrado().toString(), "Masculino");

    }
}
