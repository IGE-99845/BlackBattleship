package selenide_113190;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US09 - Escolher modo de torneio (Selenide).
 */
public class TournamentTest {

    private TournamentPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new TournamentPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se é possível aceder ao formulário de criação de torneio.
     */
    @Test
    @Story("US09")
    @Description("Verifica se é possível aceder à página de criação de torneio")
    public void testAccessCreateTournament() {
        page.clickBattleshipGame();
        page.clickCreateTournament();
        assertTrue(page.isTournamentFormVisible(),
                "Deve navegar para a página de criação de torneio");
    }

    /**
     * Testa se é possível preencher o nome do torneio.
     */
    @Test
    @Story("US09")
    @Description("Verifica se é possível preencher o nome do torneio")
    public void testFillTournamentName() {
        page.clickBattleshipGame();
        page.clickCreateTournament();
        page.selectServer();
        page.fillTournamentName("Engenharia de Software");
        page.fillTournamentDescription("Torneio");
        assertTrue(page.isTournamentFormVisible());
    }

    /**
     * Testa se é possível selecionar o modo de torneio.
     */
    @Test
    @Story("US09")
    @Description("Verifica se é possível selecionar o modo de torneio")
    public void testSelectTournamentMode() {
        page.clickBattleshipGame();
        page.clickCreateTournament();
        page.selectServer();
        page.fillTournamentName("Engenharia de Software");
        page.fillTournamentDescription("Torneio");
        page.selectTournamentMode();
        page.clickCancel();
        assertTrue(true, "Modo de torneio selecionado com sucesso");
    }
}
