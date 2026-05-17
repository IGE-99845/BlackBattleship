package selenide_122479;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

/**
 * Page Object Class para US14 - Logout (Selenide).
 */
public class LogoutPage {

    private SelenideElement profileImage = $(".user-profile img");

    /**
     * Abre a página do Battleship.
     */
    public void open() {
        com.codeborne.selenide.Selenide.open("https://papergames.io/en/battleship");
    }

    /**
     * Verifica se o utilizador está autenticado.
     */
    public boolean estaAutenticado() {
        try {
            return $(".user-profile img").exists();
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