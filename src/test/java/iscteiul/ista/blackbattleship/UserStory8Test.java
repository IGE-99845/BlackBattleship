package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Page Test Class para a User Story 8.
 *
 * <p>US08: Como organizador, quero criar um torneio de Battleship
 * com um nome personalizado e partilhá-lo, para que outros jogadores
 * possam participar através de um link.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de criação de torneios no papergames.io,
 * utilizando os métodos definidos em {@link UserStory8}.</p>
 *
 * <p>Critério de aceitação: após navegar para "Create tournament",
 * selecionar Battleship como tipo de jogo, inserir o nome "asd" e
 * clicar em "Create and share", o fluxo deve concluir sem erros,
 * confirmando que o torneio foi criado e a ligação de partilha
 * foi gerada.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory8
 */
public class UserStory8Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory8 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory8(driver);
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
     * Testa que é possível criar um torneio de Battleship com o nome "asd"
     * e clicar em "Create and share" sem erros.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest8):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar em "Create tournament" no menu lateral</li>
     *   <li>Abrir o selector de tipo de jogo</li>
     *   <li>Selecionar "Battleship"</li>
     *   <li>Clicar no campo de nome e inserir "asd"</li>
     *   <li>Clicar em "Create and share"</li>
     * </ol>
     */
    @Test
    public void testCriarTorneio() throws InterruptedException {
        Thread.sleep(3000);
        battleshipPage.navegarParaCriarTorneio();
        Thread.sleep(3000);
        battleshipPage.abrirSelectorTipoJogo();
        Thread.sleep(2000);
        battleshipPage.selecionarBattleship();
        Thread.sleep(2000);
        battleshipPage.clicarCampoNomeTorneio();
        battleshipPage.inserirNomeTorneio("asd");
        Thread.sleep(2000);
        battleshipPage.clicarCriarEPartilhar();
        Thread.sleep(2000);
    }
}