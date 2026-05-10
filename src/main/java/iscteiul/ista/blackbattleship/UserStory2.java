package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class para a User Story 2.
 *
 * <p>US02: Como jogador, quero iniciar uma partida com um amigo através de um
 * link único, para que possamos jogar em tempo real sem necessitar de conta.</p>
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
public class UserStory2 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Tempo máximo de espera por elementos, em segundos. */
    private static final int TIMEOUT_SECONDS = 30;

    /**
     * Botão "Play with a friend" — primeiro botão de ação na página do Battleship.
     * Seletor CSS capturado via Selenium IDE.
     */
    @FindBy(css = ".w-100:nth-child(1) > .btn-lg .flex-grow-1")
    private WebElement playWithFriendButton;

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
     * Contentor do convite ao amigo, visível após o registo do nickname.
     * Contém o link único e/ou QR code para partilhar com o amigo.
     */
    @FindBy(css = ".p-3")
    private WebElement inviteFriendContainer;

    /**
     * Construtor que inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver a ser utilizada
     */
    public UserStory2(WebDriver driver) {
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
     * Clica no botão "Play with a friend" para iniciar o fluxo de convite.
     * Corresponde ao passo "click" com o comentário "Clicar em jogar com amigo".
     */
    public void clicarJogarComAmigo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(playWithFriendButton)).click();
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
     * Aguarda que o contentor com o link/QR code de convite fique visível,
     * confirmando que o link único foi gerado com sucesso.
     * Corresponde ao passo "waitForElementVisible" com o comentário
     * "Aguardar que o link/QR code apareça".
     *
     * @return {@code true} se o contentor de convite ficou visível dentro do tempo limite
     */
    public boolean linkConviteEstaVisivel() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
            wait.until(ExpectedConditions.visibilityOf(inviteFriendContainer));
            return inviteFriendContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}