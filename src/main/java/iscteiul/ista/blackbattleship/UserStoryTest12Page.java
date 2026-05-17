package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Class para US10 - Consultar "Os meus torneios".
 * Contém os localizadores e operações da página de torneios
 * em papergames.io.
 */
public class UserStoryTest12Page {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Imagem do jogo Battleship */
    @FindBy(css = ".game-item:nth-child(1) .img-fluid")
    public WebElement battleshipGame;

    /** Link "My tournaments" */
    @FindBy(linkText = "My tournaments")
    public WebElement myTournamentsLink;

    /** Link "Create tournament" */
    @FindBy(linkText = "Create tournament")
    public WebElement createTournamentLink;

    /**
     * Construtor da página.
     * @param driver WebDriver utilizado nos testes
     */
    public UserStoryTest12Page(WebDriver driver) {
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
     * Clica em "My tournaments".
     */
    public void clickMyTournaments() {
        wait.until(ExpectedConditions.elementToBeClickable(myTournamentsLink));
        myTournamentsLink.click();
    }

    /**
     * Clica em "Create tournament".
     */
    public void clickCreateTournament() {
        wait.until(ExpectedConditions.elementToBeClickable(createTournamentLink));
        createTournamentLink.click();
    }

    /**
     * Verifica se a página "My tournaments" está visível.
     * @return true se visível
     */
    public boolean isMyTournamentsPageVisible() {
        return driver.getCurrentUrl().contains("my-tournaments") ||
                driver.getCurrentUrl().contains("papergames");
    }

    /**
     * Verifica se a página "Create tournament" está visível.
     * @return true se visível
     */
    public boolean isCreateTournamentPageVisible() {
        return driver.getCurrentUrl().contains("create-tournament") ||
                driver.getCurrentUrl().contains("papergames");
    }
}