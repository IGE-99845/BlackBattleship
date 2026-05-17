package selenide_122479;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US16 - Daily Leaderboard (Selenide).
 */
public class LeaderboardTest {

    private LeaderboardPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new LeaderboardPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se o leaderboard está visível.
     */
    @Test
    @Story("US16")
    @Description("Verifica se o leaderboard diário está visível")
    public void testLeaderboardVisivel() {
        assertTrue(page.leaderboardVisivel(),
                "O leaderboard deve estar visível");
    }

    /**
     * Testa o link See all.
     */
    @Test
    @Story("US16")
    @Description("Verifica se o link See all funciona")
    public void testSeeAll() {
        page.clicarSeeAll();
        assertTrue(page.obterUrl().contains("papergames"),
                "Deve continuar no papergames");
    }
}