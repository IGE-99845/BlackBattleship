package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class para a User Story 3.
 *
 * <p>US03: Como jogador, quero iniciar uma partida contra um jogador aleatório
 * online, para que possa competir com desconhecidos a qualquer momento.</p>
 *
 * <p>Esta classe encapsula todos os localizadores e operações sobre a página
 * de Batalha Naval do papergames.io, seguindo o padrão Page Object Model.
 * Alterações na estrutura da página apenas requerem modificações nesta classe,
 * sem impacto nos testes.</p>
 *
 * <p>URL base: https://papergames.io/en/battleship</p>
 *
 * @author 99328
 * @version 1.0
 */
public class UserStory3 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Tempo máximo de espera por elementos, em segundos. */
    private static final int TIMEOUT_SECONDS = 30;

    /**
     * Botão "Play online with a random player" — botão secundário na página do Battleship.
     * Seletor CSS capturado via Selenium IDE.
     */
    @FindBy(css = ".btn-secondary:nth-child(2)")
    private WebElement playOnlineButton;

    /**
     * Secção do diálogo de registo de nickname (guest registration).
     * Visível após clicar em qualquer botão de jogo quando o utilizador
     * ainda não tem sessão iniciada.
     */
    @FindBy(css = ".pt-4")
    private WebElement nicknameDialogSection;

    /**
     * Campo de texto para introduzir o nickname do jogador.
     */
    @FindBy(css = ".input-xl")
    private WebElement nicknameInput;

    /**
     * Botão "Continue" para submeter o nickname e avançar para o jogo.
     */
    @FindBy(css = ".p-3 > .btn")
    private WebElement continueButton;

    /**
     * Contentor principal do jogo, visível após entrar na fila de matchmaking.
     * A sua visibilidade confirma que o processo foi iniciado com sucesso.
     */
    @FindBy(css = ".scrollable-flex")
    private WebElement gameContainer;

    /**
     * Construtor que inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver a ser utilizada
     */
    public UserStory3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Navega para a página de Batalha Naval e maximiza a janela.
     * Corresponde aos passos "open" e "setWindowSize" do Selenium IDE.
     */
    public void abrirPaginaBattleship() {
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().maximize();
    }

    /**
     * Clica no botão "Play online with a random player" para iniciar matchmaking.
     * Corresponde ao passo "click" com o comentário "Clicar em jogar com um player online".
     */
    public void clicarJogarContraJogadorAleatorio() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(playOnlineButton)).click();
    }

    /**
     * Aguarda que o diálogo de escolha de nickname apareça.
     * Corresponde ao passo "waitForElementVisible" com o comentário
     * "Aguardar pela tela do nickname".
     */
    public void aguardarDialogoNickname() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.visibilityOf(nicknameDialogSection));
    }

    /**
     * Preenche o campo de nickname e clica em "Continue" para avançar.
     * Corresponde aos passos "click" + "type" + "click" com os comentários
     * "Clicar para escrever o nickname", "Escrever o nickname" e "Clicar em continuar".
     *
     * @param nickname o nome de utilizador a introduzir
     */
    public void preencherNicknameEContinuar(String nickname) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(nicknameInput)).click();
        nicknameInput.sendKeys(nickname);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    /**
     * Aguarda que o contentor principal do jogo fique visível, confirmando
     * que o matchmaking foi iniciado com sucesso.
     * Corresponde ao passo "waitForElementVisible" com o comentário
     * "Aguardar que o jogo carregue".
     *
     * @return {@code true} se o contentor do jogo ficou visível dentro do tempo limite
     */
    public boolean jogoEstaVisivel() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
            wait.until(ExpectedConditions.visibilityOf(gameContainer));
            return gameContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
