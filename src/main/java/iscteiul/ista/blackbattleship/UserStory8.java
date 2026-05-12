package iscteiul.ista.blackbattleship;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Class para a User Story 8.
 *
 * <p>US08: Como organizador, quero criar um torneio de Battleship
 * com um nome personalizado e partilhá-lo, para que outros jogadores
 * possam participar através de um link.</p>
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e
 * encapsula todos os localizadores CSS / XPath e as acções sobre os
 * elementos da página do Battleship no papergames.io, mantendo o código
 * de teste ({@link UserStory8Test}) limpo e independente dos detalhes
 * de implementação da UI.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory8Test
 */
public class UserStory8 {

    // ---------------------------------------------------------------
    // WebDriver e espera explícita
    // ---------------------------------------------------------------

    /** Driver Selenium usado para interagir com o browser. */
    private final WebDriver driver;

    /** Espera explícita (10 segundos) para elementos dinâmicos. */
    private final WebDriverWait wait;

    /** Espera explícita longa (20 segundos) para carregamentos lentos. */
    private final WebDriverWait longWait;

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
     * Aguardado para desaparecer após clicar em "Consent", garantindo
     * que o popup não intercepta cliques nos elementos da página.
     */
    private static final By OVERLAY_COOKIES =
            By.cssSelector(".fc-consent-root");

    /**
     * Link "Create tournament" no menu lateral de navegação.
     * XPath: segundo {@code <ul>} → {@code li/a/span}.
     */
    private static final By LINK_CRIAR_TORNEIO =
            By.xpath("//ul[2]/li/a/span");

    /**
     * Componente {@code mat-select} de seleção do tipo de jogo.
     * Identificado pelo id Angular Material {@code mat-select-serverApp0}.
     *
     * <p>O clique é feito via JavaScript porque o elemento está inicialmente
     * vazio ({@code mat-mdc-select-empty}) e o Selenium não consegue
     * interagir com ele pelo método normal.</p>
     */
    private static final By MAT_SELECT_TIPO_JOGO =
            By.id("mat-select-serverApp0");


    /**
     * Opção "Battleship" no painel de opções expandido.
     * Localizador primário do Selenium IDE:
     * {@code css=#mat-option-serverApp0 .c-gray-700}.
     */
    private static final By OPCAO_BATTLESHIP =
            By.cssSelector("#mat-option-serverApp0 .c-gray-700");

    /**
     * XPath alternativo para a opção Battleship, retirado dos targets:
     * {@code xpath=//mat-option[@id='mat-option-serverApp0']/span/app-game-select-option/div/div/div[2]/div[2]}.
     */
    private static final By OPCAO_BATTLESHIP_XPATH =
            By.xpath("//mat-option[@id='mat-option-serverApp0']/span/app-game-select-option/div/div/div[2]/div[2]");


    /**
     * Campo de texto do nome do torneio.
     * Identificado pelo id Angular Material {@code mat-input-serverApp0}.
     */
    private static final By INPUT_NOME_TORNEIO =
            By.id("mat-input-serverApp0");

    /**
     * Botão "Create and share" para criar e partilhar o torneio.
     * CSS: {@code .btn-secondary}.
     */
    private static final By BTN_CRIAR_E_PARTILHAR =
            By.cssSelector(".btn-secondary");

    // ---------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------

    /**
     * Cria uma instância de {@code UserStory8} associada ao driver fornecido.
     *
     * @param driver instância activa do {@link WebDriver}
     */
    public UserStory8(WebDriver driver){
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(20));
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
        Thread.sleep(4000);
        List<WebElement> botoes = driver.findElements(BTN_COOKIES);
        if (!botoes.isEmpty() && botoes.get(0).isDisplayed()) {
            botoes.get(0).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(OVERLAY_COOKIES));
        }
    }

    /**
     * Clica no link "Create tournament" no menu lateral para navegar
     * para a página de criação de torneios.
     */
    public void navegarParaCriarTorneio() {
        WebElement link = wait.until(
                ExpectedConditions.elementToBeClickable(LINK_CRIAR_TORNEIO));
        link.click();
    }

    /**
     * Abre o dropdown de seleção do tipo de jogo.
     *
     * <p>O Selenium IDE gravou o clique em {@code .d-flex > div > .fw-bold},
     * que é o elemento filho visível dentro do trigger do {@code mat-select}.
     * Clicar neste elemento propaga-se ao componente pai e abre a lista.
     * Se esse clique falhar (ex.: elemento não interactuável), são tentados
     * dois fallbacks em sequência:</p>
     * <ol>
     *   <li>XPath completo para o mesmo elemento filho.</li>
     *   <li>Clique via JavaScript directamente no {@code mat-select} pai.</li>
     * </ol>
     */
    public void abrirSelectorTipoJogo() {
        WebElement matSelect = longWait.until(
                ExpectedConditions.presenceOfElementLocated(MAT_SELECT_TIPO_JOGO));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", matSelect);
    }

    /**
     * Seleciona "Battleship" na lista de tipos de jogo expandida.
     *
     * <p>Tenta primeiro o localizador CSS gravado pelo Selenium IDE;
     * se falhar usa o XPath alternativo dos targets.</p>
     */
    public void selecionarBattleship() {
        try {
            WebElement opcao = wait.until(
                    ExpectedConditions.elementToBeClickable(OPCAO_BATTLESHIP));
            opcao.click();
        } catch (Exception e) {
            WebElement opcao = wait.until(
                    ExpectedConditions.elementToBeClickable(OPCAO_BATTLESHIP_XPATH));
            opcao.click();
        }
    }

    /**
     * Clica no campo de texto do nome do torneio para o focar,
     * preparando-o para receber texto.
     */
    public void clicarCampoNomeTorneio() {
        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(INPUT_NOME_TORNEIO));
        input.click();
    }

    /**
     * Insere o nome especificado no campo de texto do torneio.
     *
     * @param nome nome a atribuir ao torneio (ex.: {@code "asd"})
     */
    public void inserirNomeTorneio(String nome) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(INPUT_NOME_TORNEIO));
        input.clear();
        input.sendKeys(nome);
    }

    /**
     * Clica no botão "Create and share" para criar o torneio e obter
     * a ligação de partilha.
     */
    public void clicarCriarEPartilhar() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_CRIAR_E_PARTILHAR));
        btn.click();
    }
}