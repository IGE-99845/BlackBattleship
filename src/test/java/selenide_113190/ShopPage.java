package selenide_113190;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US11 - Loja de avatares (Selenide).
 */
public class ShopPage {

    private SelenideElement avatarsLink = $(".box-shadow-1:nth-child(2) .w-75");
    private SelenideElement emojisLink = $(".box-shadow-1:nth-child(3) .w-75");

    /**
     * Abre a página da loja diretamente.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/shop");
    }

    /**
     * Clica na secção de avatares.
     */
    public void clickAvatars() {
        avatarsLink.shouldBe(visible).click();
    }

    /**
     * Clica na secção de emojis.
     */
    public void clickEmojis() {
        emojisLink.shouldBe(visible).click();
    }

    /**
     * Verifica se a página da loja está visível.
     */
    public boolean isShopPageVisible() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("shop") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("papergames");
    }
}