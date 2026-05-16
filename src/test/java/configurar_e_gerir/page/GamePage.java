package configurar_e_gerir.page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object Class que representa o jogo de Batalha Naval em curso.
 *
 * <p>Encapsula apenas os localizadores e ações exclusivos do jogo em curso:
 * seleção de arma especial e disparo numa célula do tabuleiro adversário.</p>
 *
 * <p>Para abrir a página usar {@link BattleshipPage#abrir()}.
 * Para iniciar a partida usar {@link BattleshipPage#clicarJogarContraRobot()}.
 * Para preencher o nickname usar {@link NicknamePage#preencherEContinuar(String)}.</p>
 *
 * @author 99845
 * @version 1.0
 */
public class GamePage {

    /**
     * Segunda arma especial disponível (missile) na barra de armas.
     */
    private final SelenideElement weaponButton =
            $(".weapon-button:nth-child(2) > img");

    /**
     * Tabuleiro adversário — usado para aguardar que esteja visível.
     */
    private final SelenideElement opponentBoard =
            $("div.opponent table.table-board");

    /**
     * Célula (5,3) do tabuleiro adversário — alvo do disparo.
     */
    private final SelenideElement celulaAlvo =
            $("div.opponent table.table-board td.cell-5-3");

    /**
     * SVG de resposta visual na célula (5,3) após o disparo (acerto ou erro).
     * Capturado via Selenium IDE com o comentário
     * "Aguarda para verificar que o tiro foi efetuado".
     */
    private final SelenideElement respostaVisualDisparo =
            $("div.opponent table.table-board td.cell-5-3 svg");

    /**
     * Clica na segunda arma especial disponível (missile).
     */
    public void selecionarArmaEspecial() {
        weaponButton.click();
    }

    /**
     * Devolve o tabuleiro adversário para verificações de visibilidade.
     *
     * @return elemento do tabuleiro adversário
     */
    public SelenideElement getOpponentBoard() {
        return opponentBoard;
    }

    /**
     * Clica na célula (5,3) do tabuleiro adversário para disparar.
     * Corresponde ao passo "click" com o comentário "Dispara contra o adversario".
     */
    public void dispararNaCelula() {
        celulaAlvo.click();
    }

    /**
     * Devolve o SVG de resposta visual ao disparo para verificações.
     *
     * @return elemento SVG da célula (5,3) após disparo
     */
    public SelenideElement getRespostaVisualDisparo() {
        return respostaVisualDisparo;
    }
}