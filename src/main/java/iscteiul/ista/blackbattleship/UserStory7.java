package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


/**
 * Page Object Class para a User Story 7.
 *
 * <p>US07: Como jogador, quero poder consultar as regras do jogo
 * diretamente na página, para que possa perceber como jogar
 * sem sair do site.</p>
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e
 * encapsula todos os localizadores CSS / XPath e as acções sobre os
 * elementos da página do Battleship no papergames.io, mantendo o código
 * de teste ({@link UserStory7Test}) limpo e independente dos detalhes
 * de implementação da UI.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory7Test
 */
public class UserStory7 {

    // ---------------------------------------------------------------
    // WebDriver e espera explícita
    // ---------------------------------------------------------------

    /** Driver Selenium usado para interagir com o browser. */
    private final WebDriver driver;

    /** Espera explícita (10 segundos) para elementos dinâmicos. */
    private final WebDriverWait wait;

    // ---------------------------------------------------------------
    // Localizadores e constantes
    // ---------------------------------------------------------------

    /** URL base do jogo Battleship. */
    private static final String URL_JOGO = "https://papergames.io/en/battleship";

    /**
     * Botão "Consent" do popup de cookies.
     * Identificado pela classe CSS {@code fc-cta-consent}, que é única
     * para o botão de aceitação do framework de consentimento.
     */
    private static final By BTN_COOKIES =
            By.cssSelector("button.fc-cta-consent");

    /**
     * Overlay/container principal do popup de cookies.
     * Aguardado para desaparecer após clicar em "Consent".
     */
    private static final By OVERLAY_COOKIES =
            By.cssSelector(".fc-consent-root");

    /**
     * Título da secção de regras do jogo.
     * CSS: {@code h2:nth-child(2)}.
     */
    private static final By TITULO_REGRAS =
            By.cssSelector("h2:nth-child(2)");

    /**
     * Texto esperado no elemento {@code h2:nth-child(2)}.
     * Usado na asserção do teste {@link UserStory7Test}.
     */
    public static final String TEXTO_REGRAS_ESPERADO =
            "Rules of Battleship game online";

    /**
     * Tempo de pausa em milissegundos após o scroll, replicando o
     * comando {@code pause} do cenário Selenium IDE original.
     */
    private static final int PAUSA_SCROLL_MS = 1000;

    // ---------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------

    /**
     * Cria uma instância de {@code UserStory7} associada ao driver fornecido.
     *
     * @param driver instância activa do {@link WebDriver}
     */
    public UserStory7(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------------------------------------------------------
    // Métodos de acção
    // ---------------------------------------------------------------

    /**
     * Navega para a URL do jogo Battleship e define a janela do browser
     * com resolução {@code 1051 x 805} px.
     */
    public void abrirJogo() {
        driver.get(URL_JOGO);
        driver.manage().window().setSize(new Dimension(1051, 805));
    }

    /**
     * Aceita o popup de cookies caso este esteja visível.
     *
     * <p>O popup do framework de consentimento (classe {@code fc-cta-consent})
     * aparece na primeira visita à página. Este método verifica se o botão
     * "Consent" está presente e, se estiver, clica nele automaticamente.
     * Caso o popup não apareça (visita seguinte ou já aceite), o método
     * termina sem erro.</p>
     */
    public void aceitarCookies() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> botoes = driver.findElements(BTN_COOKIES);
        if (!botoes.isEmpty() && botoes.get(0).isDisplayed()) {
            botoes.get(0).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(OVERLAY_COOKIES));
        }
    }

    /**
     * Executa um scroll suave até ao primeiro elemento {@code <h2>} da página,
     * que corresponde ao título das regras do jogo.
     *
     * <p>Utiliza {@link JavascriptExecutor} para replicar o comando
     * {@code executeScript} do cenário Selenium IDE original:
     * {@code document.querySelector('h2').scrollIntoView({behavior:'smooth',block:'start'})}.
     * Após o scroll aguarda {@value #PAUSA_SCROLL_MS} ms para garantir
     * que a animação terminou antes da asserção.</p>
     *
     * @throws InterruptedException se a thread for interrompida durante a pausa
     */
    public void scrollAteRegras() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "document.querySelector('h2').scrollIntoView({behavior: 'smooth', block: 'start'})");
        Thread.sleep(PAUSA_SCROLL_MS);
    }

    /**
     * Devolve o texto actual do elemento {@code h2:nth-child(2)} da página.
     *
     * <p>Aguarda até o elemento estar visível (máx. 10 s) antes de
     * extrair o texto, para lidar com possíveis atrasos de renderização.</p>
     *
     * @return texto do título das regras do jogo (nunca {@code null})
     */
    public String obterTextoTituloRegras() {
        WebElement h2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(TITULO_REGRAS));
        return h2.getText();
    }
}