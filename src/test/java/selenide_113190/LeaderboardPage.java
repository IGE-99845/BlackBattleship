package selenide_113190;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US16 - Daily Leaderboard (Selenide).
 */
public class LeaderboardPage {

    private SelenideElement learnMoreLink = $("a.ms-1");
    private SelenideElement firstPlace = $(".item:nth-child(1) .d-flex");
    private SelenideElement secondPlace = $(".position-relative > .item:nth-child(2) .d-flex");
    private SelenideElement thirdPlace = $(".position-relative > .item:nth-child(3) .d-flex");

    /**
     * Abre a página do Battleship.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/battleship");
    }

    /**
     * Clica em Learn more no leaderboard.
     */
    public void clickLearnMore() {
        learnMoreLink.shouldBe(visible).click();
    }

    /**
     * Clica na primeira posição do leaderboard.
     */
    public void clickFirstPlace() {
        firstPlace.shouldBe(visible).click();
    }

    /**
     * Verifica se o leaderboard está visível.
     * @return true se visível
     */
    public boolean isLeaderboardVisible() {
        try {
            firstPlace.shouldBe(visible);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
