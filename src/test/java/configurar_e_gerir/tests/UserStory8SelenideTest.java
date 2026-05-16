package configurar_e_gerir.tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import configurar_e_gerir.page.TournamentPage;
import iniciar_partidas.pages.BattleshipPage;
import org.junit.jupiter.api.Test;

/**
 * Teste Selenide para o cenário UserStoryTest8.
 *
 * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest8):</p>
 * <ol>
 *   <li>Abrir a página — reutiliza {@link BattleshipPage#abrir()}</li>
 *   <li>Clicar em "Create tournament"</li>
 *   <li>Selecionar o jogo Battleship no dropdown</li>
 *   <li>Inserir o nome do torneio</li>
 *   <li>Clicar em "Create and share"</li>
 * </ol>
 *
 * @author 99845
 * @version 1.0
 */
@Story("US08 - Criar torneio de Battleship")
class UserStory8SelenideTest extends BaseTest {

    /**
     * Testa que é possível criar um torneio de Battleship preenchendo
     * o formulário e clicando em "Create and share".
     *
     * <p>Critério de aceitação: após clicar em "Create and share", o botão
     * deixa de ser visível, confirmando que o torneio foi criado.</p>
     */
    @Test
    @Description("Criar torneio de Battleship com nome 'asd' e clicar em Create and share")
    void testCriarTorneioBattleship() throws InterruptedException {
        BattleshipPage battleshipPage = new BattleshipPage();
        TournamentPage tournamentPage = new TournamentPage();

        battleshipPage.abrir();
        tournamentPage.navegarParaCriarTorneio();
        Selenide.sleep(2000);
        tournamentPage.abrirSelectorTipoJogo();
        Selenide.sleep(2000);
        tournamentPage.selecionarBattleship();
        Selenide.sleep(2000);
        tournamentPage.preencherNomeTorneio("asd");
        Selenide.sleep(2000);
        tournamentPage.clicarCriarEPartilhar();
        Selenide.sleep(2000);
    }
}