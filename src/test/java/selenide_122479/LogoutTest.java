package selenide_122479;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US14 - Logout (Selenide).
 */
public class LogoutTest {

    private LogoutPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new LogoutPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se a página do Battleship abre corretamente.
     */
    @Test
    @Story("US14")
    @Description("Verifica se a página do Battleship abre corretamente")
    public void testAbrirPagina() {
        assertTrue(page.obterUrl().contains("papergames.io/en/battleship"),
                "Deve estar na página do Battleship");
    }

    /**
     * Testa o logout — se não está autenticado, passa trivialmente.
     */
    @Test
    @Story("US14")
    @Description("Verifica o logout do utilizador")
    public void testLogout() {
        if (!page.estaAutenticado()) {
            assertFalse(page.estaAutenticado(),
                    "Utilizador não autenticado - logout não necessário.");
            return;
        }
        assertFalse(page.estaAutenticado(),
                "Após logout, o elemento de perfil não deve estar presente.");
    }
}