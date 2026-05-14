package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US10 - Consultar "Os meus torneios".
 * Testa a funcionalidade de consulta dos torneios do utilizador
 * em https://papergames.io.
 */
public class UserStoryTest12Test {

    private WebDriver driver;
    private UserStoryTest12Page page;

    /**
     * Configuração antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new UserStoryTest12Page(driver);
        page.open();
    }

    /**
     * Encerra o WebDriver após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa se é possível navegar para "My tournaments".
     * US10: Como utilizador, quero consultar os meus torneios.
     */
    @Test
    public void testAccessMyTournaments() {
        page.clickBattleshipGame();
        page.clickMyTournaments();
        assertTrue(page.isMyTournamentsPageVisible(),
                "Deve navegar para a página dos meus torneios");
    }

    /**
     * Testa se é possível navegar para "Create tournament"
     * a partir da página de torneios.
     */
    @Test
    public void testAccessCreateTournamentFromMyTournaments() {
        page.clickBattleshipGame();
        page.clickMyTournaments();
        page.clickCreateTournament();
        assertTrue(page.isCreateTournamentPageVisible(),
                "Deve navegar para a página de criação de torneio");
    }
}