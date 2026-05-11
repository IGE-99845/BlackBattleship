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
 * Page Object Class para a User Story 6.
 *
 * <p>US06: Como jogador, quero jogar contra o robô como convidado,
 * selecionar uma arma especial (míssil) e disparar sobre uma célula
 * do tabuleiro adversário, para que possa experimentar as mecânicas
 * de combate do jogo.</p>
 *
 * <p>Esta classe segue o padrão <em>Page Object Model (POM)</em> e
 * encapsula todos os localizadores CSS / XPath e as acções sobre os
 * elementos da página do Battleship no papergames.io, mantendo o código
 * de teste ({@link UserStory6Test}) limpo e independente dos detalhes
 * de implementação da UI.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory6Test
 */
public class UserStory6 {

    // ---------------------------------------------------------------
    // WebDriver e esperas explícitas
    // ---------------------------------------------------------------

    /** Driver Selenium usado para interagir com o browser. */
    private final WebDriver driver;

    /** Espera explícita padrão (10 segundos) para interacções rápidas de UI. */
    private final WebDriverWait wait;

    /**
     * Espera explícita longa (30 segundos) usada nos {@code waitForElementVisible}
     * do cenário original do Selenium IDE.
     */
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
     * Aguardado para desaparecer após clicar em "Consent".
     */
    private static final By OVERLAY_COOKIES =
            By.cssSelector(".fc-consent-root");

    /**
     * Botão "Play vs Bot" na página inicial.
     * CSS: {@code .w-100:nth-child(2) > .btn .flex-grow-1}.
     */
    private static final By BTN_JOGAR_CONTRA_ROBO =
            By.cssSelector(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Campo de texto do username no diálogo de registo de convidado.
     * CSS: {@code .input-xl}.
     */
    private static final By INPUT_USERNAME =
            By.cssSelector(".input-xl");

    /**
     * Botão "Continue" no diálogo de registo de convidado.
     * CSS: {@code .p-3 > .btn}.
     */
    private static final By BTN_CONTINUAR =
            By.cssSelector(".p-3 > .btn");

    /**
     * Ícone da arma especial "míssil" no painel de armas do jogador.
     * CSS: {@code .weapon-button:nth-child(2) > img}.
     */
    private static final By IMG_MISSIL =
            By.cssSelector(".weapon-button:nth-child(2) > img");

    /**
     * Tabuleiro do adversário. Aguardado para confirmar que é o turno
     * do jogador antes de disparar.
     * CSS: {@code div.opponent table.table-board}.
     */
    private static final By TABULEIRO_ADVERSARIO =
            By.cssSelector("div.opponent table.table-board");

    /**
     * Célula 5-3 do tabuleiro adversário onde será efectuado o disparo.
     * CSS: {@code div.opponent table.table-board td.cell-5-3}.
     */
    private static final By CELULA_5_3 =
            By.cssSelector("div.opponent table.table-board td.cell-5-3");

    /**
     * SVG resultante do disparo na célula 5-3 (indicador de tiro).
     * Aguardado para confirmar que o disparo foi registado.
     * CSS: {@code div.opponent table.table-board td.cell-5-3 svg}.
     */
    private static final By SVG_TIRO_CELULA_5_3 =
            By.cssSelector("div.opponent table.table-board td.cell-5-3 svg");

    // ---------------------------------------------------------------
    // Construtor
    // ---------------------------------------------------------------

    /**
     * Cria uma instância de {@code UserStory6} associada ao driver fornecido.
     *
     * @param driver instância activa do {@link WebDriver}
     */
    public UserStory6(WebDriver driver) {
        this.driver   = driver;
        this.wait     = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.longWait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
     * Clica no botão "Play vs Bot" para iniciar uma partida contra o robô.
     */
    public void selecionarJogarContraRobo() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_JOGAR_CONTRA_ROBO));
        btn.click();
    }

    /**
     * Insere o username fornecido no campo de texto do diálogo de
     * registo de convidado.
     *
     * @param username nome de utilizador a inserir (ex.: {@code "ASD"})
     */
    public void inserirUsername(String username) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(INPUT_USERNAME));
        input.clear();
        input.sendKeys(username);
    }

    /**
     * Clica no botão "Continue" para confirmar o registo do convidado
     * e avançar para o jogo.
     */
    public void clicarContinuar() {
        WebElement btn = wait.until(
                ExpectedConditions.elementToBeClickable(BTN_CONTINUAR));
        btn.click();
    }

    /**
     * Seleciona a arma especial "míssil" clicando no respectivo ícone
     * no painel de armas do jogador.
     */
    public void selecionarArmaMissil() {
        WebElement img = wait.until(
                ExpectedConditions.elementToBeClickable(IMG_MISSIL));
        img.click();
    }

    /**
     * Aguarda até o tabuleiro do adversário ficar visível (máx. 30 s),
     * indicando que é o turno do jogador para disparar.
     */
    public void aguardarTurnoJogador() {
        longWait.until(
                ExpectedConditions.visibilityOfElementLocated(TABULEIRO_ADVERSARIO));
    }

    /**
     * Clica na célula {@code 5-3} do tabuleiro adversário para efectuar
     * o disparo nessa posição.
     */
    public void dispararNaCelula5_3() {
        WebElement celula = wait.until(
                ExpectedConditions.elementToBeClickable(CELULA_5_3));
        celula.click();
    }

    /**
     * Verifica se o SVG de resultado do tiro está visível na célula {@code 5-3}.
     *
     * <p>Aguarda até 30 segundos pela aparição do elemento SVG. Devolve
     * {@code true} se o elemento aparecer dentro do tempo limite,
     * {@code false} caso contrário.</p>
     *
     * @return {@code true} se o tiro na célula 5-3 foi confirmado visualmente
     */
    public boolean tiroNaCelula5_3Confirmado() {
        try {
            longWait.until(
                    ExpectedConditions.visibilityOfElementLocated(SVG_TIRO_CELULA_5_3));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}