package selenide_113190;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US09 - Escolher modo de torneio (Selenide).
 */
public class TournamentPage {

    private SelenideElement battleshipGame = $(".game-item:nth-child(1) .img-fluid");
    private SelenideElement createTournamentButton = $(".position-relative > .front");
    private SelenideElement serverSelector = $("#mat-select-value-serverApp0 > .mat-mdc-select-placeholder");
    private SelenideElement firstServerOption = $("#mat-option-serverApp0 .fw-bold");
    private SelenideElement tournamentNameField = $("#mat-input-serverApp0");
    private SelenideElement tournamentDescriptionField = $("#mat-input-serverApp1");
    private SelenideElement tournamentModeSelector = $("div:nth-child(7) .mat-mdc-form-field-infix");
    private SelenideElement tournamentModeOption = $("#mat-option-serverApp16");
    private SelenideElement cancelButton = $(".btn-secondary");

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
     * Clica no botão de criar torneio.
     */
    public void clickCreateTournament() {
        createTournamentButton.shouldBe(visible).click();
    }

    /**
     * Seleciona o servidor.
     */
    public void selectServer() {
        serverSelector.shouldBe(visible).click();
        firstServerOption.shouldBe(visible).click();
    }

    /**
     * Preenche o nome do torneio.
     * @param name nome do torneio
     */
    public void fillTournamentName(String name) {
        tournamentNameField.shouldBe(visible).click();
        tournamentNameField.setValue(name);
    }

    /**
     * Preenche a descrição do torneio.
     * @param description descrição
     */
    public void fillTournamentDescription(String description) {
        tournamentDescriptionField.shouldBe(visible).click();
        tournamentDescriptionField.setValue(description);
    }

    /**
     * Seleciona o modo de torneio.
     */
    public void selectTournamentMode() {
        tournamentModeSelector.shouldBe(visible).click();
        tournamentModeOption.shouldBe(visible).click();
    }

    /**
     * Clica no botão cancelar.
     */
    public void clickCancel() {
        cancelButton.shouldBe(visible).click();
    }

    /**
     * Verifica se o formulário de criação está visível.
     */
    public boolean isTournamentFormVisible() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("create-tournament") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("papergames");
    }
}
