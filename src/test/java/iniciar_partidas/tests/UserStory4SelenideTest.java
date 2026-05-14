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
 * Testes Selenide para a User Story 4.
 *
 * <p>US04: Como jogador, quero selecionar uma coordenada no tabuleiro adversário
 * para disparar um míssil e tentar atingir um navio inimigo.</p>
 *
 * <p><b>Comparação Selenium vs Selenide:</b></p>
 * <ul>
 *   <li>Selenium: setup no {@code @BeforeEach} com 3 chamadas separadas,
 *       {@code assertTrue(disparoFoiRegistado())} com try/catch interno</li>
 *   <li>Selenide: tudo no {@code @Test} em sequência linear, sem {@code @BeforeEach},
 *       sem try/catch, sem gestão de driver</li>
 * </ul>
 *
 * @author 99328
 * @version 1.0
 */
@Story("US04 - Disparar míssil no tabuleiro adversário")
class UserStory4SelenideTest extends BaseTest {

    /**
     * Testa que ao clicar numa célula do tabuleiro adversário após iniciar
     * uma partida contra o robot, aparece uma resposta visual (SVG de acerto ou erro).
     *
     * <p>Critério de aceitação: o SVG dentro de
     * {@code div.opponent table.table-board td.cell-0-0} está visível após o disparo.</p>
     */
    @Test
    @Description("Iniciar partida vs robot, disparar na célula (0,0) e verificar resposta visual")
    void testDispararMissilNoTabuleiro() throws InterruptedException {
        BattleshipPage page = new BattleshipPage();
        NicknamePage nicknamePage = new NicknamePage();

        // Setup: abrir página, iniciar partida contra robot e registar nickname
        page.abrir();
        Thread.sleep(2000);
        page.clicarJogarContraRobotAlt();
        Thread.sleep(2000);
        nicknamePage.preencherEContinuar("asd");
        Thread.sleep(2000);
        // Disparar na célula (0,0) do tabuleiro adversário
        page.dispararNaCelulaAdversario();
        Thread.sleep(2000);
        // Verificar que apareceu resposta visual — disparo registado
        page.getRespostaVisualDisparo().shouldBe(Condition.visible);
    }
}