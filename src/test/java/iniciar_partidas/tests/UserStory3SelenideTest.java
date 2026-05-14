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
 * Testes Selenide para a User Story 3.
 *
 * <p>US03: Como jogador, quero iniciar uma partida contra um jogador aleatório
 * online, para que possa competir com desconhecidos a qualquer momento.</p>
 *
 * <p><b>Comparação Selenium vs Selenide:</b></p>
 * <ul>
 *   <li>Selenium: método {@code jogoEstaVisivel()} retorna boolean, requer {@code assertTrue}</li>
 *   <li>Selenide: {@code shouldBe(Condition.visible)} lança exceção descritiva se falhar,
 *       sem necessidade de assert separado</li>
 * </ul>
 *
 * @author 99328
 * @version 1.0
 */
@Story("US03 - Iniciar partida contra jogador aleatório")
class UserStory3SelenideTest extends BaseTest {

    /**
     * Testa que ao clicar em "Play online with a random player", preencher o
     * nickname e confirmar, o contentor do jogo/fila de espera fica visível.
     *
     * <p>Critério de aceitação: o contentor {@code .scrollable-flex} está visível.</p>
     */
    @Test
    @Description("Clicar em Play online, preencher nickname e verificar que o matchmaking inicia")
    void testIniciarMatchmakingContraJogadorAleatorio() throws InterruptedException {
        BattleshipPage page = new BattleshipPage();
        NicknamePage nicknamePage = new NicknamePage();

        page.abrir();
        Thread.sleep(2000);
        page.clicarJogarOnline();
        Thread.sleep(2000);
        nicknamePage.preencherEContinuar("asd");
        Thread.sleep(2000);
        page.getGameContainer().shouldBe(Condition.visible);
    }
}