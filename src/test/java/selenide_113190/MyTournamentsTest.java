package selenide_113190;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US10 - Consultar "Os meus torneios" (Selenide).
 */
public class MyTournamentsTest {

    private MyTournamentsPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new MyTournamentsPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se é possível navegar para My tournaments.
     */
    @Test
    @Story("US10")
    @Description("Verifica se é possível aceder à página dos meus torneios")
    public void testAccessMyTournaments() {
        page.clickBattleshipGame();
        page.clickMyTournaments();
        assertTrue(page.isMyTournamentsPageVisible(),
                "Deve navegar para a página dos meus torneios");
    }

    /**
     * Testa se é possível navegar para Create tournament.
     */
    @Test
    @Story("US10")
    @Description("Verifica se é possível aceder à página de criação de torneio")
    public void testAccessCreateTournament() {
        page.clickBattleshipGame();
        page.clickMyTournaments();
        page.clickCreateTournament();
        assertTrue(page.isCreateTournamentPageVisible(),
                "Deve navegar para a página de criação de torneio");
    }
}
