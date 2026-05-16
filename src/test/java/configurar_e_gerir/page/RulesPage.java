package configurar_e_gerir.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
public class RulesPage {

    /**
     * Título da secção de regras do jogo.
     */
    private final SelenideElement tituloRegras =
            $("h2:nth-child(2)");

    /**
     * Faz scroll suave até ao primeiro {@code <h2>} da página (secção de regras).
     *
     * @throws InterruptedException se a thread for interrompida durante a pausa pós-scroll
     */
    public void scrollAteRegras() throws InterruptedException {
        executeJavaScript(
                "document.querySelector('h2').scrollIntoView({behavior: 'smooth', block: 'start'})");
        Thread.sleep(1000);
    }

    /**
     * Devolve o elemento do título das regras para verificação no teste.
     *
     * @return {@link SelenideElement} do {@code h2:nth-child(2)}
     */
    public SelenideElement getTituloRegras() {
        return tituloRegras;
    }

    /**
     * Devolve o texto actual do título das regras do jogo.
     *
     * <p>O Selenide aguarda automaticamente que o elemento esteja visível
     * antes de extrair o texto, dispensando a {@code WebDriverWait} do Selenium.</p>
     *
     * @return texto do título das regras
     */
    public String obterTextoTituloRegras() {
        tituloRegras.shouldBe(Condition.visible);
        return tituloRegras.getText();
    }
}