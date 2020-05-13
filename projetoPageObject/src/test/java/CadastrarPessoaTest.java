import entities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CadastroPage;

public class CadastrarPessoaTest extends BaseTest {


    @Test()
    public void deveCadastrarPessoa() {

        String nome = "Douglas";
        String sobreNome = "Borba";
        String escolaridade = "Mestrado";
        String esporte = "Futebol";
        String sugestao = "Realizar um nivelamento";

        CadastroPage cp = new CadastroPage(getNavegador());

        cp.preencherNome(nome)
                .preencherSobrenome(sobreNome)
                .informarSexo()
                .informarComida()
                .selecionarEscolaridade(escolaridade)
                .selecionarEsporte(esporte)
                .preenchersugestoes(sugestao)
                .clicarCadastrar();

        Assert.assertEquals(cp.verificaCadastrado().toString(), "Cadastrado!");
        Assert.assertEquals(cp.verificaNomeCadastrado().toString(), nome);
        Assert.assertEquals(cp.verificaSobreNomeCadastrado().toString(), sobreNome);
        Assert.assertEquals(cp.verificaSexoCadastrado().toString(), "Masculino");
        Assert.assertEquals(cp.verificaComidaCadastrada().toString(), "Carne");
        Assert.assertEquals(cp.verificaescolariadaCadastrada().toString(), escolaridade.toLowerCase());
        Assert.assertEquals(cp.verificaEsporteCadastrado().toString(), esporte);
        Assert.assertEquals(cp.verificasugestaoCadastrada().toString(), sugestao);
    }
}
