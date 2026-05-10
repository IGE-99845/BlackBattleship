package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Class para a User Story 4.
 *
 * <p>US04: Como jogador, quero selecionar uma coordenada no tabuleiro adversário
 * para disparar um míssil e tentar atingir um navio inimigo.</p>
 *
 * <p>Esta classe encapsula todos os localizadores e operações sobre a página
 * de Batalha Naval do papergames.io, seguindo o padrão Page Object Model.
 * Alterações na estrutura da página apenas requerem modificações nesta classe,
 * sem impacto nos testes.</p>
 *
 * <p>O tabuleiro adversário é distinguido do tabuleiro do jogador através do
 * contentor pai com a classe {@code opponent}, conforme identificado via
 * inspeção do DOM da página.</p>
 *
 * <p>URL base: https://papergames.io/en/battleship</p>
 *
 * @author 99328
 * @version 1.0
 */
public class UserStory4 {

    /** WebDriver utilizado para interagir com o browser. */
    private final WebDriver driver;

    /** Tempo máximo de espera por elementos, em segundos. */
    private static final int TIMEOUT_SECONDS = 30;

    /**
     * Botão "Play vs robot" — usado como setup para ter um tabuleiro
     * disponível sem depender de outro jogador humano.
     * Seletor CSS capturado via Selenium IDE.
     */
    @FindBy(css = ".w-100:nth-child(2) > .btn > .front")
    private WebElement playVsRobotButton;

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
     * Célula (0,0) do tabuleiro adversário — coordenada alvo do disparo.
     * O seletor usa o contentor pai {@code div.opponent} para distinguir
     * o tabuleiro adversário do tabuleiro do jogador atual.
     */
    @FindBy(css = "div.opponent table.table-board td.cell-0-0")
    private WebElement celulaAdversario;

    /**
     * Elemento SVG dentro da célula (0,0) do tabuleiro adversário,
     * visível após o disparo ser efetuado (acerto ou erro).
     * A sua visibilidade confirma que o disparo foi registado.
     */
    @FindBy(css = "div.opponent table.table-board td.cell-0-0 svg")
    private WebElement respostaVisualDisparo;


    /**
     * Construtor que inicializa os elementos da página via PageFactory.
     *
     * @param driver instância do WebDriver a ser utilizada
     */
    public UserStory4(WebDriver driver) {
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
     * Clica no botão "Play vs robot" para iniciar o fluxo de jogo.
     * Corresponde ao passo "click" com o comentário "Clicar em jogar contra robot".
     */
    public void clicarJogarContraRobot() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(playVsRobotButton)).click();
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
     * Aguarda que o tabuleiro adversário fique visível e clica na célula (0,0)
     * para disparar um míssil nessa coordenada.
     * Corresponde ao passo "click" com o comentário
     * "Selecionar uma coordenada no tabuleiro do adversário e disparar".
     */
    public void dispararMissilNaCelulaAdversario() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
        wait.until(ExpectedConditions.elementToBeClickable(celulaAdversario)).click();
    }

    /**
     * Aguarda que a resposta visual ao disparo (SVG de acerto ou erro)
     * fique visível na célula (0,0) do tabuleiro adversário.
     * Corresponde ao passo "waitForElementVisible" com o comentário
     * "Aguarda para verificar que o tiro foi efetuado".
     *
     * @return {@code true} se a resposta visual ficou visível dentro do tempo limite
     */
    public boolean disparoFoiRegistado() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_SECONDS));
            wait.until(ExpectedConditions.visibilityOf(respostaVisualDisparo));
            return respostaVisualDisparo.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}