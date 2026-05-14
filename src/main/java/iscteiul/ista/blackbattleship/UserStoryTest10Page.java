package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object Class para US11 - Loja de avatares.
 * Contém os localizadores e operações da página da loja
 * de avatares em papergames.io.
 */
public class UserStoryTest10Page {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Link do menu Shop */
    @FindBy(linkText = "Shop")
    public WebElement shopLink;

    /** Link da secção de avatares (Monsters) */
    @FindBy(css = ".box-shadow-1:nth-child(2) .w-75")
    public WebElement avatarsLink;

    /** Link da secção de emojis */
    @FindBy(css = ".box-shadow-1:nth-child(3) .w-75")
    public WebElement emojisLink;

    /** Link da secção de moedas */
    @FindBy(linkText = "Coins")
    public WebElement coinsLink;

    /**
     * Construtor da página.
     * @param driver WebDriver utilizado nos testes
     */
    public UserStoryTest10Page(WebDriver driver) {
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
     * Clica no menu Shop.
     */
    public void clickShop() {
        wait.until(ExpectedConditions.elementToBeClickable(shopLink));
        shopLink.click();
    }

    /**
     * Clica na secção de avatares.
     */
    public void clickAvatars() {
        wait.until(ExpectedConditions.elementToBeClickable(avatarsLink));
        avatarsLink.click();
    }

    /**
     * Clica na secção de emojis.
     */
    public void clickEmojis() {
        wait.until(ExpectedConditions.elementToBeClickable(emojisLink));
        emojisLink.click();
    }

    /**
     * Verifica se a página da loja está visível.
     * @return true se visível
     */
    public boolean isShopPageVisible() {
        return driver.getCurrentUrl().contains("shop") ||
                driver.getCurrentUrl().contains("papergames");
    }

    /**
     * Verifica se a página de avatares está visível.
     * @return true se visível
     */
    public boolean isAvatarsPageVisible() {
        return driver.getCurrentUrl().contains("/en/shop");
    }
}