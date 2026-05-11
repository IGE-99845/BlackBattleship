package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Class para a User Story 5.
 *
 * <p>US05: Como jogador, quero configurar opções personalizadas do jogo,
 * nomeadamente definir o tempo de turno para 15 segundos e guardar as
 * alterações, para que a partida decorra com as minhas preferências.</p>
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e
 * encapsula todos os localizadores CSS / XPath e as acções sobre os
 * elementos da página do Battleship no papergames.io, mantendo o código
 * de teste ({@link UserStory5Test}) limpo e independente dos detalhes
 * de implementação da UI.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory5Test
 */
public class UserStory5 {

    // ---------------------------------------------------------------
    // WebDriver e espera explícita
    // ---------------------------------------------------------------

    /** Driver Selenium usado para interagir com o browser. */
    private final WebDriver driver;

    /** Espera explícita (máximo 10 segundos) para elementos dinâmicos. */
    private final WebDriverWait wait;

    // ---------------------------------------------------------------
    // Localizadores
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
     * Botão de abertura das definições do jogo (ícone de engrenagem).
     * XPath preferido: posição relativa dentro do segundo {@code <span>}.
     */
    private static final By BTN_DEFINICOES =
            By.xpath("//span[2]/button/span[3]");

    /**
     * Botão "Custom options" no diálogo de configurações.
     * CSS: {@code .btn-sm:nth-child(2)}.
     */
    private static final By BTN_CUSTOM_OPTIONS =
            By.cssSelector(".btn-sm:nth-child(2)");

    /**
     * Ícone SVG do dropdown de seleção do tempo de turno.
     * CSS: {@code #mat-select-serverApp1 svg}.
     */
    private static final By DROPDOWN_TEMPO =
            By.cssSelector("#mat-select-serverApp1 svg");

    /**
     * Opção "15 seconds" no dropdown de tempo.
     * Identificada pelo id {@code mat-option-serverApp10}.
     */
    private static final By OPCAO_15_SEGUNDOS =
            By.id("mat-option-serverApp10");

    /**
     * Botão "Save settings" para guardar as configurações.
     * CSS: {@code .gap-1:nth-child(2)}.
     */
    private static final By BTN_GUARDAR =
            By.cssSelector(".gap-1:nth-child(2)");

    // ---------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------

    /**
     * Cria uma instância de {@code UserStory5} associada ao driver fornecido.
     *
     * @param driver instância activa do {@link WebDriver}
     */
    public UserStory5(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------------------------------------------------------------
    // Métodos de acção
    // ---------------------------------------------------------------

    /**
     * Navega para a URL do jogo Battleship e define a janela do browser
     * com a resolução padrão {@code 1051 x 805} px.
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
     * Clica no botão das definições do jogo para abrir o diálogo
     * de configurações.
     */
    public void abrirDefinicoes() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_DEFINICOES));
        btn.click();
    }

    /**
     * Clica no botão "Custom options" dentro do diálogo de configurações,
     * activando as opções avançadas do jogo.
     */
    public void clicarCustomOptions() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_CUSTOM_OPTIONS));
        btn.click();
    }

    /**
     * Abre o dropdown de seleção do tempo de turno clicando no ícone SVG
     * do componente Angular Material {@code mat-select}.
     */
    public void abrirDropdownTempo() {
        WebElement dropdown = wait.until(
                ExpectedConditions.elementToBeClickable(DROPDOWN_TEMPO));
        dropdown.click();
    }

    /**
     * Seleciona a opção "15 seconds" no dropdown de tempo de turno.
     */
    public void selecionarTempo15Segundos() {
        WebElement opcao = wait.until(
                ExpectedConditions.elementToBeClickable(OPCAO_15_SEGUNDOS));
        opcao.click();
    }

    /**
     * Clica no botão "Save settings" para persistir as alterações
     * efectuadas no diálogo de configurações.
     */
    public void guardarDefinicoes() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_GUARDAR));
        btn.click();
    }
}