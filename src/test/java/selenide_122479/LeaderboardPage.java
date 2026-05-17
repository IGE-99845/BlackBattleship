package selenide_122479;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US16 - Daily Leaderboard (Selenide).
 */
public class LeaderboardPage {

    private SelenideElement seeAllLink = $("a.ms-1");
    private SelenideElement leaderboardElement = $(".position-relative");

    /**
     * Abre a página do Battleship.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/battleship");
    }

    /**
     * Clica em See all no leaderboard.
     */
    public void clicarSeeAll() {
        seeAllLink.shouldBe(visible).click();
    }

    /**
     * Verifica se o leaderboard está visível.
     */
    public boolean leaderboardVisivel() {
        try {
            leaderboardElement.shouldBe(visible);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna o URL atual.
     */
    public String obterUrl() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl();
    }
}