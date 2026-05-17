package configurar_e_gerir.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configurar_e_gerir.page.GamePage;
import iniciar_partidas.pages.BattleshipPage;
import iniciar_partidas.pages.NicknamePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

/**
 * Teste Selenide para o cenário UserStoryTest6.
 *
 * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest6):</p>
 * <ol>
 *   <li>Abrir a página — reutiliza {@link BattleshipPage#abrir()}</li>
 *   <li>Clicar em "Play vs robot" — reutiliza {@link BattleshipPage#clicarJogarContraRobot()}</li>
 *   <li>Inserir o username — reutiliza {@link NicknamePage#preencherEContinuar(String)}</li>
 *   <li>Selecionar a arma especial (missile)</li>
 *   <li>Aguardar o tabuleiro adversário — espera automática do Selenide</li>
 *   <li>Disparar na célula (5,3)</li>
 *   <li>Verificar a resposta visual</li>
 * </ol>
 *
 * @author 99845
 * @version 1.0
 */
@Story("US06 - Selecionar arma especial e disparar")
class UserStory6SelenideTest extends BaseTest {

    /**
     * Testa que após selecionar uma arma especial e disparar numa célula
     * do tabuleiro adversário, aparece uma resposta visual (SVG).
     *
     * <p>Critério de aceitação: o SVG dentro da célula (5,3) do tabuleiro
     * adversário fica visível após o disparo.</p>
     */
    @Test
    @Description("Selecionar arma especial missile e disparar na célula (5,3) do adversário")
    void testSelecionarArmaEDisparar() throws InterruptedException {
        BattleshipPage battleshipPage = new BattleshipPage();
        NicknamePage nicknamePage = new NicknamePage();
        GamePage gamePage = new GamePage();

        battleshipPage.abrir();
        battleshipPage.clicarJogarContraRobot();
        nicknamePage.preencherEContinuar("ASD");
        gamePage.selecionarArmaEspecial();
        gamePage.getOpponentBoard().shouldBe(Condition.visible);
        Selenide.sleep(2000);
        gamePage.dispararNaCelula();
        Selenide.sleep(2000);
        gamePage.getRespostaVisualDisparo().shouldBe(Condition.visible);
    }
}