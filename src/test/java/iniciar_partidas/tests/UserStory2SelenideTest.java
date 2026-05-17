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
 * Testes Selenide para a User Story 2.
 *
 * <p>US02: Como jogador, quero iniciar uma partida com um amigo através de um
 * link único, para que possamos jogar em tempo real sem necessitar de conta.</p>
 *
 * <p><b>Comparação Selenium vs Selenide:</b></p>
 * <ul>
 *   <li>Selenium: método {@code linkConviteEstaVisivel()} com try/catch e WebDriverWait</li>
 *   <li>Selenide: {@code shouldBe(Condition.visible)} numa linha, sem try/catch</li>
 * </ul>
 *
 * @author 99328
 * @version 1.0
 */
@Story("US02 - Iniciar partida com amigo via link")
class UserStory2SelenideTest extends BaseTest {

    /**
     * Testa que ao clicar em "Play with a friend", preencher o nickname e confirmar,
     * o contentor com o link/QR code de convite fica visível.
     *
     * <p>Critério de aceitação: o contentor {@code .p-3} com o link está visível.</p>
     */
    @Test
    @Description("Clicar em Play with a friend, preencher nickname e verificar que o link/QR code aparece")
    void testGerarLinkConviteParaAmigo() throws InterruptedException {
        BattleshipPage page = new BattleshipPage();
        NicknamePage nicknamePage = new NicknamePage();

        page.abrir();
        Thread.sleep(2000);
        page.clicarJogarComAmigo();
        Thread.sleep(2000);
        nicknamePage.preencherEContinuar("asd");
        Thread.sleep(2000);
        page.getInviteFriendContainer().shouldBe(Condition.visible);
    }
}