package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory 15.
 *
 * <p>Esta classe contém os testes JUnit 5 que validam a navegação até à
 * secção de histórico de partidas ("History") a partir do menu lateral do
 * site <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>Fluxo do teste:
 * <ol>
 *   <li>Abrir a página do Battleship;</li>
 *   <li>Clicar no ícone do menu hamburger;</li>
 *   <li>Clicar no ícone/link "History";</li>
 *   <li>Verificar que a navegação para a secção de histórico foi bem-sucedida.</li>
 * </ol>
 *
 * @author TestSuite_122479
 * @version 1.0
 * @see UserStory15
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserStory15Test {

    /** Driver partilhado por todos os métodos de teste da classe. */
    private static WebDriver driver;

    /** Page Object que encapsula as operações de página. */
    private static UserStory15 page;

    // -------------------------------------------------------------------------
    // Configuração e teardown
    // -------------------------------------------------------------------------

    /**
     * Inicializa o WebDriver (Chrome em modo headless) e o Page Object antes
     * de todos os testes da classe.
     */
    @BeforeAll
    static void setup() {

        driver = new FirefoxDriver();
        page = new UserStory15(driver);
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
    @DisplayName("US15-T1: Abertura da página do Battleship")
    void testAbrirPagina() {
        page.abrirPagina();
        assertTrue(
                page.obterUrlAtual().contains("papergames.io/en/battleship"),
                "O URL deve conter 'papergames.io/en/battleship'."
        );
    }

    /**
     * Verifica que, após clicar no ícone do menu e no link "History", o
     * utilizador é redirecionado para a secção de histórico de partidas.
     *
     * <p>A asserção confirma que o URL ou o título da página contém
     * a referência ao histórico.
     */
    @Test
    @Order(2)
    @DisplayName("US15-T2: Navegação até à secção de histórico (History)")
    void testNavegacaoAteHistorico() {
        page.abrirPagina();
        //   page.clicarMenuIcon();
        page.clicarHistorico();
        assertTrue(
                page.paginaHistoricoAberta(),
                "O URL ou título da página deve indicar a secção 'History' após a navegação."
        );
    }
}

