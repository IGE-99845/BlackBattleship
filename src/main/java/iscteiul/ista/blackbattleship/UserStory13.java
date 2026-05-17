package iscteiul.ista.blackbattleship;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
/**
 * Page Object Class para a UserStory 13.
 *
 * <p>Esta classe encapsula todos os localizadores CSS e XPath, bem como as
 * operações de interação com a página web do jogo Battleship em
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>O cenário cobre a navegação até à loja de moedas virtuais a partir do
 * menu principal.
 *
 * @author TestSuite_122479
 * @version 1.0
 */
public class UserStory13 {

    /** Instância do WebDriver utilizada para interagir com o browser. */
    private final WebDriver driver;

    // -------------------------------------------------------------------------
    // Localizadores
    // -------------------------------------------------------------------------

    /** XPath do ícone do menu (botão hamburger). */
    private static final By MENU_ICON =
            By.xpath("//span/button/span[3]");

    /** Link de texto para aceder à secção Shop. */
    private static final By SHOP_LINK =
            By.linkText("Shop");

    /** Link de texto para aceder à secção de moedas virtuais (Coins). */
    private static final By COINS_LINK =
            By.linkText("Coins");

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma instância de {@code UserStory13} com o driver fornecido.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado
     */
    public UserStory13(WebDriver driver) {
        this.driver = driver;
    }

    // -------------------------------------------------------------------------
    // Métodos de página
    // -------------------------------------------------------------------------

    /**
     * Abre a página inicial do Battleship e define o tamanho da janela.
     *
     * <p>O tamanho 870×692 corresponde à configuração utilizada no teste
     * gravado com o Selenium IDE.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().setSize(new Dimension(870, 692));
    }

    /**
     * Clica no ícone do menu hamburger para abrir o menu de navegação lateral.
     *
     * <p>Localizador utilizado: {@code xpath=//span/button/span[3]}
     */
    /**
     * Aguarda até o ícone do menu estar clicável e clica nele.
     * Usa espera explícita de 10 segundos para evitar ElementNotInteractableException.
     */
    public void clicarMenuIcon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement menu = wait.until(
                ExpectedConditions.elementToBeClickable(MENU_ICON)
        );
        menu.click();
    }

    /**
     * Clica no link "Shop" no menu de navegação.
     *
     * <p>Localizador utilizado: {@code linkText=Shop}
     */
    public void clicarShop() {
        driver.findElement(SHOP_LINK).click();
    }

    /**
     * Clica no link "Coins" para aceder à loja de moedas virtuais.
     *
     * <p>Localizador utilizado: {@code linkText=Coins}
     */
    public void clicarCoins() {
        driver.findElement(COINS_LINK).click();
    }

    /**
     * Retorna o URL atual do browser.
     *
     * @return {@link String} com o URL corrente
     */
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }
}

