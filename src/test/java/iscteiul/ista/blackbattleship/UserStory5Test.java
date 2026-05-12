package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Page Test Class para a User Story 5.
 *
 * <p>US05: Como jogador, quero configurar opções personalizadas do jogo,
 * nomeadamente definir o tempo de turno para 15 segundos e guardar as
 * alterações, para que a partida decorra com as minhas preferências.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de configuração do jogo no papergames.io,
 * utilizando os métodos definidos em {@link UserStory5}.</p>
 *
 * <p>Critério de aceitação: após abrir as definições, selecionar
 * "Custom options", escolher 15 segundos como tempo de turno e clicar
 * em "Save settings", o diálogo deve fechar sem erros, confirmando que
 * as definições foram guardadas.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory5
 */
public class UserStory5Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory5 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory5(driver);
        battleshipPage.abrirJogo();
        battleshipPage.aceitarCookies();
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
     * Testa que é possível configurar o tempo de turno para 15 segundos
     * e guardar as definições sem erros.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest5):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar no botão de definições do jogo</li>
     *   <li>Clicar em "Custom options"</li>
     *   <li>Abrir o dropdown de tempo de turno</li>
     *   <li>Selecionar a opção "15 seconds"</li>
     *   <li>Clicar em "Save settings"</li>
     * </ol>
     */
    @Test
    public void testConfigurarTempoDeTurno() throws InterruptedException {
        Thread.sleep(3000);
        battleshipPage.abrirDefinicoes();
        Thread.sleep(2000);
        battleshipPage.clicarCustomOptions();
        Thread.sleep(2000);
        battleshipPage.abrirDropdownTempo();
        Thread.sleep(2000);
        battleshipPage.selecionarTempo15Segundos();
        Thread.sleep(2000);
        battleshipPage.guardarDefinicoes();
        Thread.sleep(2000);
    }
}