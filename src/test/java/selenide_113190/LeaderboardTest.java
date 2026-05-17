package selenide_113190;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
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
    @Description("Verifica se o leaderboard diário está visível na página")
    public void testLeaderboardVisible() {
        assertTrue(page.isLeaderboardVisible(),
                "O leaderboard deve estar visível");
    }

    /**
     * Testa o link Learn more do leaderboard.
     */
    @Test
    @Story("US16")
    @Description("Verifica se o link Learn more navega corretamente")
    public void testLearnMoreLink() {
        page.clickLearnMore();
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl()
                        .contains("ranka") ||
                        WebDriverRunner.getWebDriver().getCurrentUrl()
                                .contains("papergames"),
                "Deve navegar para a página RANKA");
    }
}
