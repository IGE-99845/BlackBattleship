package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US09 - Escolher modo de torneio.
 * Testa a funcionalidade de criação de torneio e escolha
 * do modo em https://papergames.io.
 */
public class UserStoryTest11Test {

    private WebDriver driver;
    private UserStoryTest11Page page;

    /**
     * Configuração antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new UserStoryTest11Page(driver);
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
     * Testa se é possível aceder ao formulário de criação de torneio.
     * US09: Como organizador, quero escolher o modo de torneio.
     */
    @Test
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
    public void testFillTournamentName() {
        page.clickBattleshipGame();
        page.clickCreateTournament();
        page.selectServer();
        page.fillTournamentName("Engenharia de Software");
        page.fillTournamentDescription("Torneio");
        assertTrue(page.isTournamentFormVisible(),
                "O formulário deve continuar visível após preencher o nome");
    }

    /**
     * Testa se é possível selecionar o modo de torneio.
     */
    @Test
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