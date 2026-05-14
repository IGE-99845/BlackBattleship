package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US16 - Daily Leaderboard.
 * Testa a funcionalidade de consulta do leaderboard diário
 * em https://papergames.io/en/battleship.
 */
public class UserStoryTest9Test {

    private WebDriver driver;
    private UserStoryTest9Page page;

    /**
     * Configuração antes de cada teste.
     * Inicializa o WebDriver e abre a página.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new UserStoryTest9Page(driver);
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
     * Testa se o leaderboard está visível na página do Battleship.
     * US16: Como jogador, quero consultar o daily leaderboard.
     */
    @Test
    public void testLeaderboardVisible() {
        assertTrue(page.isLeaderboardVisible(),
                "O leaderboard deve estar visível na página");
    }

    /**
     * Testa se é possível clicar em "Learn more" do leaderboard.
     */
    @Test
    public void testLearnMoreLink() {
        page.clickLearnMore();
        String url = driver.getCurrentUrl();
        assertTrue(url.contains("ranka") || url.contains("blog") || url.contains("papergames"),
                "Deve navegar para a página RANKA ou blog");
    }

    /**
     * Testa se é possível interagir com as posições do leaderboard.
     */
    @Test
    public void testLeaderboardPositions() {
        assertTrue(page.isLeaderboardVisible());
        page.clickFirstPlace();
        page.clickSecondPlace();
        page.clickThirdPlace();
    }
}