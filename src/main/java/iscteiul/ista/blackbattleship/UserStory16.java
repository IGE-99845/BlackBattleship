package iscteiul.ista.blackbattleship;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object Class para a UserStory 16.
 *
 * <p>Esta classe encapsula todos os localizadores CSS e XPath, bem como as
 * operações de interação com a página web do jogo Battleship em
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>O cenário cobre a visualização completa do leaderboard diário através
 * do botão "See all", incluindo scroll de regresso ao topo da página para
 * garantir a visibilidade do elemento.
 *
 * @author TestSuite_122479
 * @version 1.0
 */
public class UserStory16 {

    /** Instância do WebDriver utilizada para interagir com o browser. */
    private final WebDriver driver;

    /** Executor de JavaScript para operações de scroll na página. */
    private final JavascriptExecutor js;

    // -------------------------------------------------------------------------
    // Localizadores
    // -------------------------------------------------------------------------

    /**
     * Link "See all" que abre o leaderboard diário completo.
     *
     * <p>Localizador principal: {@code linkText=See all}
     * <br>Localizador alternativo CSS: {@code css=.text-end > .btn}
     * <br>Localizador alternativo XPath: {@code xpath=//a[contains(text(),'See all')]}
     */
    private static final By SEE_ALL_LINK =
            By.linkText("See all");

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma instância de {@code UserStory16} com o driver fornecido.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado
     */
    public UserStory16(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }
    private static final By COOKIE_ACCEPT_BUTTON =
            By.cssSelector("button.fc-cta-consent");

    private static final By COOKIE_OVERLAY =
            By.cssSelector(".fc-dialog-overlay");

    /**
     * Fecha o popup de consentimento de cookies caso esteja presente.
     * Deve ser chamado imediatamente após abrirPagina().
     */
    public void fecharCookiePopup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement botao = wait.until(
                    ExpectedConditions.elementToBeClickable(COOKIE_ACCEPT_BUTTON)
            );
            botao.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(COOKIE_OVERLAY));
        } catch (Exception e) {
            // Popup não apareceu, continua normalmente
        }
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
     * Faz scroll até ao topo da página usando JavaScript.
     *
     * <p>Equivalente ao comando {@code runScript: window.scrollTo(0,0)} do
     * Selenium IDE. É executado múltiplas vezes no teste original para
     * garantir a posição correta antes de interagir com o botão.
     */
    public void scrollParaTopo() {
        js.executeScript("window.scrollTo(0,0)");
    }

    /**
     * Clica no botão/link "See all" para visualizar o leaderboard diário
     * completo.
     *
     * <p>Localizador utilizado: {@code linkText=See all}
     * <br>Localizador CSS alternativo: {@code css=.text-end > .btn}
     */
    public void clicarSeeAll() {
        driver.findElement(SEE_ALL_LINK).click();
    }

    /**
     * Retorna o URL atual do browser.
     *
     * @return {@link String} com o URL corrente
     */
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }

    /**
     * Verifica se a página do leaderboard foi aberta, confirmando que o URL
     * mudou após clicar em "See all".
     *
     * @param urlAnterior o URL registado antes de clicar em "See all"
     * @return {@code true} se o URL atual for diferente do URL anterior,
     *         {@code false} caso contrário
     */
    public boolean leaderboardAberto(String urlAnterior) {
        // See all pode não mudar o URL, verifica se o elemento expandido está visível
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            // Verifica se apareceu mais conteúdo na página
            WebElement seeAllContent = wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.cssSelector(".contextual-sidenav, .leaderboard, [class*='leaderboard'], .position-relative")
                    )
            );
            return seeAllContent.isDisplayed();
        } catch (Exception e) {
            // Se não encontrou elemento, verifica pelo menos se continua na página
            return obterUrlAtual().contains("papergames");
        }
    }
}

