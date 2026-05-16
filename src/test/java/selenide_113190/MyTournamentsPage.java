package selenide_113190;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US10 - Consultar "Os meus torneios" (Selenide).
 */
public class MyTournamentsPage {

    private SelenideElement battleshipGame = $(".game-item:nth-child(1) .img-fluid");
    private SelenideElement myTournamentsLink = $("a[href='/en/t/my-tournaments']");
    private SelenideElement createTournamentLink = $("a[href='/en/t/create-tournament']");

    /**
     * Abre a página inicial.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/");
    }

    /**
     * Clica no jogo Battleship.
     */
    public void clickBattleshipGame() {
        battleshipGame.shouldBe(visible).click();
    }

    /**
     * Clica em My tournaments.
     */
    public void clickMyTournaments() {
        myTournamentsLink.shouldBe(visible).click();
    }

    /**
     * Clica em Create tournament.
     */
    public void clickCreateTournament() {
        createTournamentLink.shouldBe(visible).click();
    }

    /**
     * Verifica se a página My tournaments está visível.
     */
    public boolean isMyTournamentsPageVisible() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("my-tournaments") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("papergames");
    }

    /**
     * Verifica se a página Create tournament está visível.
     */
    public boolean isCreateTournamentPageVisible() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("create-tournament") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("papergames");
    }
}