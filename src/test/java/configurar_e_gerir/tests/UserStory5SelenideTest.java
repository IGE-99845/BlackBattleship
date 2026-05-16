package configurar_e_gerir.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import configurar_e_gerir.page.GameSettingsPage;
import iniciar_partidas.pages.BattleshipPage;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

public class UserStory5SelenideTest extends BaseTest {
    /**
     * Testa que é possível abrir as definições do jogo, activar as opções
     * personalizadas, selecionar 15 segundos como tempo de turno e guardar.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest5):</p>
     * <ol>
     *   <li>Abrir a página e aceitar cookies (via {@link BattleshipPage#abrir()})</li>
     *   <li>Clicar no botão de definições (ícone de engrenagem)</li>
     *   <li>Clicar em "Custom options"</li>
     *   <li>Abrir o dropdown de tempo de turno</li>
     *   <li>Selecionar "15 seconds"</li>
     *   <li>Clicar em "Save settings"</li>
     * </ol>
     *
     * <p>Critério de aceitação: o fluxo completa sem erros, confirmando que
     * as definições foram guardadas com sucesso.</p>
     */
    @Test
    @Description("Abrir definições, activar custom options, selecionar 15 s de turno e guardar")
    void testConfigurarTempoDeTurno() throws InterruptedException {
        BattleshipPage battleshipPage = new BattleshipPage();
        GameSettingsPage settingsPage = new GameSettingsPage();

        battleshipPage.abrir();
        Selenide.sleep(2000);
        settingsPage.abrirDefinicoes();
        Selenide.sleep(2000);
        settingsPage.clicarCustomOptions();
        Selenide.sleep(2000);
        settingsPage.abrirDropdownTempo();
        Selenide.sleep(2000);
        settingsPage.selecionarTempo15Segundos();
        Selenide.sleep(2000);
        settingsPage.guardarDefinicoes();
        Selenide.sleep(2000);
        settingsPage.getSaveSettingsButton().shouldNotBe(Condition.visible);
    }
}
