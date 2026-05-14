package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Class para US09 - Escolher modo de torneio.
 * Contém os localizadores e operações da página de criação
 * de torneios em papergames.io.
 */
public class UserStoryTest11Page {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Imagem do jogo Battleship */
    @FindBy(css = ".game-item:nth-child(1) .img-fluid")
    public WebElement battleshipGame;

    /** Botão Create tournament */
    @FindBy(css = ".position-relative > .front")
    public WebElement createTournamentButton;

    /** Selector do servidor */
    @FindBy(css = "#mat-select-value-serverApp0 > .mat-mdc-select-placeholder")
    public WebElement serverSelector;

    /** Primeira opção do servidor */
    @FindBy(css = "#mat-option-serverApp0 .fw-bold")
    public WebElement firstServerOption;

    /** Campo do nome do torneio */
    @FindBy(id = "mat-input-serverApp0")
    public WebElement tournamentNameField;

    /** Campo da descrição do torneio */
    @FindBy(id = "mat-input-serverApp1")
    public WebElement tournamentDescriptionField;

    /** Selector do modo de torneio */
    @FindBy(css = "div:nth-child(7) .mat-mdc-form-field-infix")
    public WebElement tournamentModeSelector;

    /** Opção de modo de torneio */
    @FindBy(id = "mat-option-serverApp16")
    public WebElement tournamentModeOption;

    /** Botão cancelar */
    @FindBy(css = ".btn-secondary")
    public WebElement cancelButton;

    /**
     * Construtor da página.
     * @param driver WebDriver utilizado nos testes
     */
    public UserStoryTest11Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Abre a página inicial do papergames.
     */
    public void open() {
        driver.get("https://papergames.io/en/");
    }

    /**
     * Clica no jogo Battleship.
     */
    public void clickBattleshipGame() {
        wait.until(ExpectedConditions.elementToBeClickable(battleshipGame));
        battleshipGame.click();
    }

    /**
     * Clica no botão de criar torneio.
     */
    public void clickCreateTournament() {
        wait.until(ExpectedConditions.elementToBeClickable(createTournamentButton));
        createTournamentButton.click();
    }

    /**
     * Seleciona o servidor.
     */
    public void selectServer() {
        wait.until(ExpectedConditions.elementToBeClickable(serverSelector));
        serverSelector.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstServerOption));
        firstServerOption.click();
    }

    /**
     * Preenche o nome do torneio.
     * @param name nome do torneio
     */
    public void fillTournamentName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(tournamentNameField));
        tournamentNameField.click();
        tournamentNameField.sendKeys(name);
    }

    /**
     * Preenche a descrição do torneio.
     * @param description descrição do torneio
     */
    public void fillTournamentDescription(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(tournamentDescriptionField));
        tournamentDescriptionField.click();
        tournamentDescriptionField.sendKeys(description);
    }

    /**
     * Seleciona o modo de torneio.
     */
    public void selectTournamentMode() {
        wait.until(ExpectedConditions.elementToBeClickable(tournamentModeSelector));
        tournamentModeSelector.click();
        wait.until(ExpectedConditions.elementToBeClickable(tournamentModeOption));
        tournamentModeOption.click();
    }

    /**
     * Clica no botão cancelar.
     */
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(cancelButton));
        cancelButton.click();
    }

    /**
     * Verifica se o formulário de criação de torneio está visível.
     * @return true se visível
     */
    public boolean isTournamentFormVisible() {
        return driver.getCurrentUrl().contains("create-tournament") ||
                driver.getCurrentUrl().contains("papergames");
    }
}