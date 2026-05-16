package configurar_e_gerir.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * Classe base de configuração partilhada por todos os testes Selenide
 * do package {@code configurar_e_gerir}.
 *
 * <p>Centraliza a configuração do browser e da integração com o Allure Report,
 * evitando repetição de código em cada classe de teste.</p>
 *
 * <p>Comparação com Selenium WebDriver: não é necessário instanciar nem fechar
 * o WebDriver manualmente — o Selenide gere o ciclo de vida do browser
 * automaticamente através de {@code Selenide.closeWebDriver()}.</p>
 *
 * @author 99845
 * @version 1.0
 */
public class BaseTest {

    /**
     * Configura o Selenide e o listener do Allure antes de todos os testes.
     *
     * <ul>
     *   <li>Browser: Chrome gerido automaticamente pelo Selenide</li>
     *   <li>Timeout: 30 segundos para esperas implícitas</li>
     *   <li>Allure: registo automático de screenshots e page source em cada passo</li>
     * </ul>
     */
    @BeforeAll
    static void configurar() {
        Configuration.browser = "chrome";
        Configuration.timeout = 30000;
        Configuration.browserSize = "1552x928";

        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    /**
     * Fecha o browser após cada método de teste, libertando os recursos.
     */
    @AfterEach
    void fecharBrowser() {
        Selenide.closeWebDriver();
    }
}