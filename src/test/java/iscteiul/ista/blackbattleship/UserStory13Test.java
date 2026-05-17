package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory 13.
 *
 * <p>Esta classe contém os testes JUnit 5 que validam a navegação até à
 * loja de moedas virtuais ("Coins") a partir do menu principal do site
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>Fluxo do teste:
 * <ol>
 *   <li>Abrir a página do Battleship;</li>
 *   <li>Clicar no ícone do menu hamburger;</li>
 *   <li>Clicar no link "Shop";</li>
 *   <li>Clicar no link "Coins";</li>
 *   <li>Verificar que o URL contém {@code /en/shop/virtual-coins}.</li>
 * </ol>
 *
 * @author TestSuite_122479
 * @version 1.0
 * @see UserStory13
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserStory13Test {

    /** Driver partilhado por todos os métodos de teste da classe. */
    private static WebDriver driver;

    /** Page Object que encapsula as operações de página. */
    private static UserStory13 page;

    // -------------------------------------------------------------------------
    // Configuração e teardown
    // -------------------------------------------------------------------------

    /**
     * Inicializa o WebDriver (Chrome em modo headless) e o Page Object antes
     * de todos os testes da classe.
     */
    @BeforeAll
    static void setup() {
        //ChromeOptions options = new ChromeOptions();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox");
        //driver = new ChromeDriver(options);
        driver = new FirefoxDriver();
        page = new UserStory13(driver);
    }

    /**
     * Encerra o WebDriver após a execução de todos os testes da classe,
     * libertando os recursos do browser.
     */
    @AfterAll
    static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // -------------------------------------------------------------------------
    // Testes
    // -------------------------------------------------------------------------

    /**
     * Verifica que a página inicial do Battleship é aberta corretamente e que
     * o URL corresponde ao esperado.
     */
    @Test
    @Order(1)
    @DisplayName("US13-T1: Abertura da página do Battleship")
    void testAbrirPagina() {
        page.abrirPagina();
        assertTrue(
                page.obterUrlAtual().contains("papergames.io/en/battleship"),
                "O URL deve conter 'papergames.io/en/battleship'."
        );
    }

    /**
     * Verifica que, após clicar no ícone do menu, no link "Shop" e no link
     * "Coins", o URL final contém o caminho da loja de moedas virtuais.
     */
    @Test
    @Order(2)
    @DisplayName("US13-T2: Navegação até à loja de moedas (Coins)")
    void testNavegacaoAteCoins() throws InterruptedException {
        page.abrirPagina();
        Thread.sleep(4000);
        //page.clicarMenuIcon();
        page.clicarShop();
        Thread.sleep(1000);
        page.clicarCoins();
        assertTrue(
                page.obterUrlAtual().contains("/en/shop/virtual-coins"),
                "O URL deve conter '/en/shop/virtual-coins' após navegar para a loja de moedas."
        );
    }
}
