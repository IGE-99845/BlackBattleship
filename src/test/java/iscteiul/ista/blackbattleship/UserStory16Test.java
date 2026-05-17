package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory 16.
 *
 * <p>Esta classe contém os testes JUnit 5 que validam a abertura do
 * leaderboard diário completo através do botão "See all" na página do
 * jogo Battleship em
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>Fluxo do teste:
 * <ol>
 *   <li>Abrir a página do Battleship;</li>
 *   <li>Executar scroll para o topo da página (2×);</li>
 *   <li>Clicar no link "See all" do leaderboard diário;</li>
 *   <li>Executar scroll para o topo novamente;</li>
 *   <li>Verificar que o URL mudou para o leaderboard completo.</li>
 * </ol>
 *
 * @author TestSuite_122479
 * @version 1.0
 * @see UserStory16
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserStory16Test {

    /** Driver partilhado por todos os métodos de teste da classe. */
    private static WebDriver driver;

    /** Page Object que encapsula as operações de página. */
    private static UserStory16 page;

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
        page = new UserStory16(driver);
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
    @DisplayName("US16-T1: Abertura da página do Battleship")
    void testAbrirPagina() {
        page.abrirPagina();
        assertTrue(
                page.obterUrlAtual().contains("papergames.io/en/battleship"),
                "O URL deve conter 'papergames.io/en/battleship'."
        );
    }

    /**
     * Verifica que, após efetuar scroll para o topo, clicar em "See all" e
     * fazer novo scroll, o utilizador é redirecionado para a página do
     * leaderboard completo.
     *
     * <p>A asserção confirma que o URL mudou relativamente ao URL inicial,
     * indicando navegação bem-sucedida para o leaderboard diário.
     */
    @Test
    @Order(2)
    @DisplayName("US16-T2: Navegação até ao leaderboard diário completo (See all)")
    void testVerLeaderboardCompleto() {
        page.abrirPagina();
        System.out.println("URL após abrir: " + page.obterUrlAtual());

        page.fecharCookiePopup();
        System.out.println("URL após cookie: " + page.obterUrlAtual());

        page.scrollParaTopo();
        page.scrollParaTopo();

        String urlAntesDeSeeAll = page.obterUrlAtual();
        System.out.println("URL antes de clicar See all: " + urlAntesDeSeeAll);

        page.clicarSeeAll();
        System.out.println("URL após clicar See all: " + page.obterUrlAtual());

        page.scrollParaTopo();

        assertTrue(
                page.leaderboardAberto(urlAntesDeSeeAll),
                "O leaderboard deve estar visível após clicar em 'See all'."
        );
    }
}

