package iniciar_partidas.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object Class que representa a página principal de Batalha Naval.
 *
 * <p>Encapsula todos os localizadores e ações sobre a página
 * {@code https://papergames.io/en/battleship}, seguindo o padrão
 * Page Object Model com Selenide.</p>
 *
 * <p>Comparação com Selenium WebDriver: em vez de {@code WebElement} com
 * {@code WebDriverWait}, o Selenide usa {@code SelenideElement} que já
 * inclui esperas automáticas — o código é significativamente mais curto.</p>
 *
 * @author 99328
 * @version 1.0
 */
public class BattleshipPage {

    /**
     * Botão "Play with a friend" — primeiro botão de ação.
     */
    private final SelenideElement playWithFriendButton =
            $(".w-100:nth-child(1) > .btn-lg .flex-grow-1");

    /**
     * Botão "Play vs robot" — segundo botão de ação.
     */
    private final SelenideElement playVsRobotButton =
            $(".w-100:nth-child(2) > .btn .flex-grow-1");

    /**
     * Botão "Play vs robot" — seletor alternativo usado no cenário de disparo.
     */
    private final SelenideElement playVsRobotButtonAlt =
            $(".w-100:nth-child(2) > .btn > .front");

    /**
     * Botão "Play online with a random player".
     */
    private final SelenideElement playOnlineButton =
            $(".btn-secondary:nth-child(2)");

    /**
     * Contentor principal do jogo, visível após o tabuleiro carregar.
     */
    private final SelenideElement gameContainer =
            $(".scrollable-flex");

    /**
     * Contentor do convite ao amigo com link/QR code.
     */
    private final SelenideElement inviteFriendContainer =
            $(".p-3");

    /**
     * Célula (0,0) do tabuleiro adversário.
     * Usa {@code div.opponent} para distinguir do tabuleiro do jogador.
     */
    private final SelenideElement celulaAdversario =
            $("div.opponent table.table-board td.cell-0-0");

    /**
     * SVG de resposta visual na célula (0,0) do tabuleiro adversário,
     * visível após um disparo (acerto ou erro).
     */
    private final SelenideElement respostaVisualDisparo =
            $("div.opponent table.table-board td.cell-0-0 svg");

    /**
     * Botão "Consent" do popup de cookies.
     * Identificado pela classe CSS {@code fc-cta-consent}, que é única
     * para o botão de aceitação do framework de consentimento.
     */
    private final SelenideElement btnCookies =
            $("button.fc-cta-consent");

    /**
     * Overlay/container principal do popup de cookies.
     * Aguardado para desaparecer após clicar em "Consent".
     */
    private final SelenideElement overlayCookies =
            $(".fc-consent-root");

    /**
     * Abre a página de Batalha Naval no browser.
     * Corresponde ao passo "open" do Selenium IDE.
     */
    public void abrir() throws InterruptedException {
        open("https://papergames.io/en/battleship");
        Thread.sleep(3000);
        aceitarCookies();
    }

    /**
     * Clica no botão "Play with a friend".
     * O Selenide aguarda automaticamente que o elemento seja clicável.
     */
    public void clicarJogarComAmigo() {
        playWithFriendButton.click();
    }

    /**
     * Clica no botão "Play vs robot".
     * O Selenide aguarda automaticamente que o elemento seja clicável.
     */
    public void clicarJogarContraRobot() {
        playVsRobotButton.click();
    }

    /**
     * Clica no botão "Play vs robot" (seletor alternativo usado no US04).
     */
    public void clicarJogarContraRobotAlt() {
        playVsRobotButtonAlt.click();
    }

    /**
     * Clica no botão "Play online with a random player".
     */
    public void clicarJogarOnline() {
        playOnlineButton.click();
    }

    /**
     * Devolve o contentor principal do jogo para verificações.
     *
     * @return elemento do contentor do jogo
     */
    public SelenideElement getGameContainer() {
        return gameContainer;
    }

    /**
     * Devolve o contentor de convite ao amigo para verificações.
     *
     * @return elemento do contentor de convite
     */
    public SelenideElement getInviteFriendContainer() {
        return inviteFriendContainer;
    }


    /**
     * Clica na célula (0,0) do tabuleiro adversário para efetuar um disparo.
     */
    public void dispararNaCelulaAdversario() {
        celulaAdversario.click();
    }

    /**
     * Devolve o SVG de resposta visual ao disparo para verificações.
     *
     * @return elemento SVG da célula adversária após disparo
     */
    public SelenideElement getRespostaVisualDisparo() {
        return respostaVisualDisparo;
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
    public void aceitarCookies() {
        if (btnCookies.exists() && btnCookies.isDisplayed()) {
            btnCookies.click();
            overlayCookies.shouldNotBe(Condition.visible);
        }
    }

}