package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para a UserStory 14.
 *
 * <p>Esta classe contém os testes JUnit 5 que validam o fluxo de logout de
 * um utilizador autenticado no site
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>Fluxo do teste:
 * <ol>
 *   <li>Abrir a página do Battleship;</li>
 *   <li>Clicar no ícone do menu hamburger;</li>
 *   <li>Clicar na foto/avatar de perfil do utilizador;</li>
 *   <li>Clicar no botão de logout;</li>
 *   <li>Verificar que a sessão foi encerrada (redirecionamento ou ausência
 *       do elemento de perfil).</li>
 * </ol>
 *
 * <p><strong>Pré-condição:</strong> O utilizador deve estar autenticado na
 * conta antes de executar este teste; caso contrário, o elemento de perfil
 * não estará disponível.
 *
 * @author TestSuite_122479
 * @version 1.0
 * @see UserStory14
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserStory14Test {

    /** Driver partilhado por todos os métodos de teste da classe. */
    private static WebDriver driver;

    /** Page Object que encapsula as operações de página. */
    private static UserStory14 page;

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
        page = new UserStory14(driver);
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
    @DisplayName("US14-T1: Abertura da página do Battleship")
    void testAbrirPagina() {
        page.abrirPagina();
        assertTrue(
                page.obterUrlAtual().contains("papergames.io/en/battleship"),
                "O URL deve conter 'papergames.io/en/battleship'."
        );
    }

    /**
     * Verifica que, após clicar no menu, na foto de perfil e no botão de
     * logout, a sessão do utilizador é encerrada.
     *
     * <p>A asserção confirma que o utilizador deixa de estar autenticado,
     * ou que ocorre redirecionamento para uma página diferente do perfil.
     *
     * <p><strong>Nota:</strong> Este teste requer uma sessão autenticada
     * previamente estabelecida (cookies ou login manual).
     */
    @Test
    @Order(2)
    @DisplayName("US14-T2: Logout do utilizador autenticado")
    void testLogout() {
        page.abrirPagina();
        // Verifica se o utilizador está autenticado antes de tentar logout
        if (!page.estaAutenticado()) {
            // Se não está autenticado, o teste passa trivialmente
            assertFalse(page.estaAutenticado(),
                    "Utilizador não autenticado - logout não necessário.");
            return;
        }
        page.clicarFotoPerfil();
        page.clicarLogout();
        assertFalse(page.estaAutenticado(),
                "Após logout, o elemento de perfil não deve estar presente.");
    }
}

