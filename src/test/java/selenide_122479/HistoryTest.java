package selenide_122479;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US15 - Histórico de partidas (Selenide).
 */
public class HistoryTest {

    private HistoryPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new HistoryPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se a página de histórico está visível.
     */
    @Test
    @Story("US15")
    @Description("Verifica se a página de histórico está visível")
    public void testPaginaHistoricoVisivel() {
        assertTrue(page.paginaHistoricoVisivel(),
                "Deve estar na página de histórico");
    }

    /**
     * Testa se existe conteúdo na página de histórico.
     */
    @Test
    @Story("US15")
    @Description("Verifica se existe conteúdo na página de histórico")
    public void testTemConteudo() {
        assertTrue(page.temConteudo(),
                "A página de histórico deve ter conteúdo visível");
    }
}