package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Class para US16 - Daily Leaderboard.
 * Contém os localizadores e operações da página do Battleship
 * relacionadas com o leaderboard diário.
 */
public class UserStoryTest9Page {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Link "Learn more" do leaderboard */
    @FindBy(linkText = "Learn more")
    public WebElement learnMoreLink;

    /** Primeira posição do leaderboard */
    @FindBy(css = ".item:nth-child(1) .d-flex")
    public WebElement firstPlace;

    /** Segunda posição do leaderboard */
    @FindBy(css = ".position-relative > .item:nth-child(2) .d-flex")
    public WebElement secondPlace;

    /** Terceira posição do leaderboard */
    @FindBy(css = ".position-relative > .item:nth-child(3) .d-flex")
    public WebElement thirdPlace;

    /**
     * Construtor da página.
     * @param driver WebDriver utilizado nos testes
     */
    public UserStoryTest9Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Abre a página do Battleship.
     */
    public void open() {
        driver.get("https://papergames.io/en/battleship");
    }

    /**
     * Clica em "Learn more" no leaderboard.
     */
    public void clickLearnMore() {
        wait.until(ExpectedConditions.elementToBeClickable(learnMoreLink));
        learnMoreLink.click();
    }

    /**
     * Clica na primeira posição do leaderboard.
     */
    public void clickFirstPlace() {
        wait.until(ExpectedConditions.elementToBeClickable(firstPlace));
        firstPlace.click();
    }

    /**
     * Clica na segunda posição do leaderboard.
     */
    public void clickSecondPlace() {
        wait.until(ExpectedConditions.elementToBeClickable(secondPlace));
        secondPlace.click();
    }

    /**
     * Clica na terceira posição do leaderboard.
     */
    public void clickThirdPlace() {
        wait.until(ExpectedConditions.elementToBeClickable(thirdPlace));
        thirdPlace.click();
    }

    /**
     * Verifica se o leaderboard está visível na página.
     * @return true se visível
     */
    public boolean isLeaderboardVisible() {
        try {
            WebElement leaderboard = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector(".position-relative > .item:nth-child(1)")
                    )
            );
            return leaderboard.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}