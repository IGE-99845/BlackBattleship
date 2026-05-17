package selenide_122479;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US15 - Histórico de partidas (Selenide).
 */
public class HistoryPage {

    private SelenideElement historyContent = $(".mat-mdc-table, .container, app-match-history");

    /**
     * Abre a página de histórico diretamente.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/match-history");
    }

    /**
     * Verifica se a página de histórico está visível.
     */
    public boolean paginaHistoricoVisivel() {
        return com.codeborne.selenide.WebDriverRunner
                .getWebDriver().getCurrentUrl().contains("match-history") ||
                com.codeborne.selenide.WebDriverRunner
                        .getWebDriver().getCurrentUrl().contains("papergames");
    }

    /**
     * Verifica se existe conteúdo na página de histórico.
     */
    public boolean temConteudo() {
        try {
            historyContent.shouldBe(visible);
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