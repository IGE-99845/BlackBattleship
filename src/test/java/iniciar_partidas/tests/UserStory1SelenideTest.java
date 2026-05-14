package iniciar_partidas.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import iniciar_partidas.pages.BattleshipPage;
import iniciar_partidas.pages.NicknamePage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank?wi_0
/**
 * Testes Selenide para a User Story 1.
 *
 * <p>US01: Como jogador, quero iniciar uma partida contra um robot,
 * para que possa jogar sozinho sem depender de outro jogador disponível.</p>
 *
 * <p><b>Comparação Selenium vs Selenide:</b></p>
 * <ul>
 *   <li>Selenium: 130+ linhas entre Page Object e Test Class, com WebDriverWait explícito</li>
 *   <li>Selenide: ~30 linhas, sem gestão de driver, esperas automáticas</li>
 * </ul>
 *
 * @author 99328
 * @version 1.0
 */
@Story("US01 - Iniciar partida contra robot")
class UserStory1SelenideTest extends BaseTest {

    /**
     * Testa que ao clicar em "Play vs robot", preencher o nickname e confirmar,
     * o tabuleiro do jogo fica visível.
     *
     * <p>Critério de aceitação: o contentor {@code .scrollable-flex} está visível.</p>
     */
    @Test
    @Description("Clicar em Play vs robot, preencher nickname e verificar que o tabuleiro carrega")
    void testIniciarPartidaContraRobot() throws InterruptedException {
        BattleshipPage page = new BattleshipPage();
        NicknamePage nicknamePage = new NicknamePage();

        page.abrir();
        Thread.sleep(2000);
        page.clicarJogarContraRobot();
        Thread.sleep(2000);
        nicknamePage.preencherEContinuar("asd");
        Thread.sleep(2000);
        page.getGameContainer().shouldBe(Condition.visible);
    }
}