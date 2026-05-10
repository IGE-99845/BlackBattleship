package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class para a User Story 4.
 *
 * <p>US04: Como jogador, quero selecionar uma coordenada no tabuleiro adversário
 * para disparar um míssil e tentar atingir um navio inimigo.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de disparo no tabuleiro adversário do papergames.io,
 * utilizando os métodos definidos em {@link UserStory4}.</p>
 *
 * <p>Critério de aceitação: após clicar numa célula do tabuleiro adversário,
 * deve aparecer uma resposta visual (SVG de acerto ou erro) nessa célula,
 * confirmando que o disparo foi registado pelo jogo.</p>
 *
 * <p>Nota: a partida é iniciada contra o robot (setup) para garantir que
 * o tabuleiro adversário está disponível sem depender de outro jogador humano.</p>
 *
 * @author 99328
 * @version 1.0
 * @see UserStory4
 */
public class UserStory4Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory4 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * navega para a página de Batalha Naval e inicia uma partida contra
     * o robot para que o tabuleiro adversário fique disponível.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory4(driver);
        battleshipPage.abrirPaginaBattleship();
        // Setup: iniciar partida contra robot para ter tabuleiro adversário disponível
        Thread.sleep(2000);
        battleshipPage.clicarJogarContraRobot();
        Thread.sleep(2000);
        battleshipPage.aguardarDialogoNickname();
        Thread.sleep(2000);
        battleshipPage.preencherNicknameEContinuar("asd");
    }

    /**
     * Fecha o browser após cada método de teste,
     * libertando os recursos utilizados.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Testa que ao clicar numa célula do tabuleiro adversário é efetuado
     * um disparo e aparece uma resposta visual (acerto ou erro).
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest4):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Iniciar partida contra robot e preencher nickname (feito no setUp)</li>
     *   <li>Clicar na célula (0,0) do tabuleiro adversário para disparar</li>
     *   <li>Aguardar a resposta visual do disparo</li>
     *   <li>Verificar que o disparo foi registado</li>
     * </ol>
     */
    @Test
    public void testDispararMissilNoTabuleiro() throws InterruptedException {
        Thread.sleep(2000);
        battleshipPage.dispararMissilNaCelulaAdversario();
        Thread.sleep(5000);
        assertTrue(
                battleshipPage.disparoFoiRegistado(),
                "Deveria aparecer resposta visual (acerto ou erro) após disparar na célula do adversário"
        );
        Thread.sleep(2000);
    }
}