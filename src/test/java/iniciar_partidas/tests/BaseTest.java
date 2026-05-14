package iniciar_partidas.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// page_url = about:blank?wi_0
/**
 * Classe base de configuração partilhada por todos os testes Selenide.
 *
 * <p>Centraliza a configuração do browser e da integração com o Allure Report,
 * evitando repetição de código em cada classe de teste.</p>
 *
 * <p>Comparação com Selenium WebDriver: não é necessário instanciar nem fechar
 * o WebDriver manualmente — o Selenide gere o ciclo de vida do browser
 * automaticamente.</p>
 *
 * @author 99328
 * @version 1.0
 */
public class BaseTest {

    /**
     * Configura o Selenide e o listener do Allure antes de todos os testes.
     *
     * <ul>
     *   <li>Browser: Edge com driver local em {@code drivers/msedgedriver.exe}</li>
     *   <li>Timeout: 30 segundos para esperas implícitas</li>
     *   <li>Allure: registo automático de screenshots e logs de cada passo</li>
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

    @AfterEach
    void fecharBrowser() {
        Selenide.closeWebDriver(); // ← fecha o browser após cada teste
    }
}