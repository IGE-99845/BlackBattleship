package selenide_122479;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US13 - Loja de moedas virtuais (Selenide).
 */
public class CoinsPage {

    private SelenideElement coinsSection = $(".box-shadow-1:nth-child(1)");

    /**
     * Abre a página da loja de moedas diretamente.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/shop/virtual-coins");
    }

    /**
     * Verifica se a página de moedas está visível.
     */
    public boolean paginaMoedasVisivel() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("virtual-coins") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("shop");
    }

    /**
     * Verifica se existe conteúdo na página de moedas.
     */
    public boolean temConteudo() {
        try {
            coinsSection.shouldBe(visible);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retorna o URL atual.
     */
    public String obterUrl() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl();
    }
}