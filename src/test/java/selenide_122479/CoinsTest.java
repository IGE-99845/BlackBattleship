package selenide_122479;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US13 - Loja de moedas virtuais (Selenide).
 */
public class CoinsTest {

    private CoinsPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new CoinsPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se a página de moedas está visível.
     */
    @Test
    @Story("US13")
    @Description("Verifica se a página de moedas virtuais está visível")
    public void testPaginaMoedasVisivel() {
        assertTrue(page.paginaMoedasVisivel(),
                "Deve estar na página de moedas virtuais");
    }

    /**
     * Testa se existe conteúdo na página de moedas.
     */
    @Test
    @Story("US13")
    @Description("Verifica se existe conteúdo na página de moedas")
    public void testTemConteudo() {
        assertTrue(page.temConteudo(),
                "A página de moedas deve ter conteúdo visível");
    }
}