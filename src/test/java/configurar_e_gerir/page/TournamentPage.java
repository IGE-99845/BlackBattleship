package configurar_e_gerir.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TournamentPage {
    /**
     * Link "Create tournament" no menu lateral de navegação.
     */
    private final SelenideElement linkCriarTorneio =
            $x("//ul[2]/li/a/span");

    /**
     * Componente {@code mat-select} de seleção do tipo de jogo.
     * CSS: {@code #mat-select-serverApp0}.
     * O clique é feito via JavaScript porque o elemento começa vazio.
     */
    private final SelenideElement matSelectTipoJogo =
            $("#mat-select-serverApp0");

    /**
     * Opção "Battleship" no painel de opções expandido.
     */
    private final SelenideElement opcaoBattleship =
            $("#mat-option-serverApp0 .c-gray-700");

    /**
     * Campo de texto do nome do torneio.
     */
    private final SelenideElement inputNomeTorneio =
            $("#mat-input-serverApp0");

    /**
     * Botão "Create and share" para criar e partilhar o torneio.
     */
    private final SelenideElement btnCriarEPartilhar =
            $(".btn-secondary");

    /**
     * Clica no link "Create tournament" no menu lateral de navegação.
     */
    public void navegarParaCriarTorneio() {
        linkCriarTorneio.click();
    }

    /**
     * Abre o dropdown de seleção do tipo de jogo via JavaScript.
     *
     * <p>O {@code mat-select} começa vazio ({@code mat-mdc-select-empty}) e
     * o Selenide não consegue clicar nele directamente. O clique via
     * {@code executeJavaScript()} contorna esta limitação do Angular Material,
     * confirmado na consola do Chrome com
     * {@code document.querySelector('mat-select').click()}.</p>
     */
    public void abrirSelectorTipoJogo() {
        matSelectTipoJogo.shouldBe(Condition.exist);
        executeJavaScript("arguments[0].click();", matSelectTipoJogo);
    }

    /**
     * Seleciona "Battleship" na lista de tipos de jogo expandida.
     */
    public void selecionarBattleship() {
        opcaoBattleship.shouldBe(Condition.visible);
        opcaoBattleship.click();
    }

    /**
     * Clica no campo de nome do torneio e insere o nome fornecido.
     *
     * @param nome nome a atribuir ao torneio (ex.: {@code "asd"})
     */
    public void preencherNomeTorneio(String nome) {
        inputNomeTorneio.click();
        inputNomeTorneio.setValue(nome);
    }

    /**
     * Clica no botão "Create and share" para criar o torneio e gerar a ligação de partilha.
     */
    public void clicarCriarEPartilhar() {
        btnCriarEPartilhar.click();
    }
}
