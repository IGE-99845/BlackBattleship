package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Page Test Class para US11 - Loja de avatares.
 * Testa a funcionalidade de acesso à loja de avatares
 * em https://papergames.io/en/shop.
 */
public class UserStoryTest10Test {

    private WebDriver driver;
    private UserStoryTest10Page page;

    /**
     * Configuração antes de cada teste.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        page = new UserStoryTest10Page(driver);
        page.open();
    }

    /**
     * Encerra o WebDriver após cada teste.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Testa se é possível aceder à loja.
     * US11: Como jogador, quero aceder à loja de avatares.
     */
    @Test
    public void testAccessShop() {
        page.clickShop();
        assertTrue(page.isShopPageVisible(),
                "Deve navegar para a página da loja");
    }

    /**
     * Testa se é possível aceder à secção de avatares.
     */
    @Test
    public void testAccessAvatars() {
        page.clickShop();
        page.clickAvatars();
        assertTrue(page.isAvatarsPageVisible(),
                "Deve navegar para a página de avatares");
    }

    /**
     * Testa se é possível aceder à secção de emojis.
     */
    @Test
    public void testAccessEmojis() {
        page.clickShop();
        page.clickEmojis();
        assertTrue(driver.getCurrentUrl().contains("/en/shop"),
                "Deve navegar para a página de emojis");
    }
}