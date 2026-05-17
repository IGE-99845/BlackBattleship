package selenide_113190;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US11 - Loja de avatares (Selenide).
 */
public class ShopTest {

    private ShopPage page;

    @BeforeEach
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
        page = new ShopPage();
        page.open();
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

    /**
     * Testa se a página da loja está visível.
     */
    @Test
    @Story("US11")
    @Description("Verifica se a página da loja está visível")
    public void testAccessShop() {
        assertTrue(page.isShopPageVisible(),
                "Deve estar na página da loja");
    }

    /**
     * Testa se é possível aceder à secção de avatares.
     */
    @Test
    @Story("US11")
    @Description("Verifica se é possível aceder à secção de avatares")
    public void testAccessAvatars() {
        page.clickAvatars();
        assertTrue(page.isShopPageVisible(),
                "Deve navegar para a página de avatares");
    }

    /**
     * Testa se é possível aceder à secção de emojis.
     */
    @Test
    @Story("US11")
    @Description("Verifica se é possível aceder à secção de emojis")
    public void testAccessEmojis() {
        page.clickEmojis();
        assertTrue(page.isShopPageVisible(),
                "Deve navegar para a página de emojis");
    }
}