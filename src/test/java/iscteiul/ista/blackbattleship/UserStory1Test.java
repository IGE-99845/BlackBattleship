package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class para a User Story 1.
 *
 * <p>US01: Como jogador, quero iniciar uma partida contra um robot,
 * para que possa jogar sozinho sem depender de outro jogador disponível.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de iniciar uma partida contra o robot no papergames.io,
 * utilizando os métodos definidos em {@link UserStory1}.</p>
 *
 * <p>Critério de aceitação: após clicar em "Play vs robot" e preencher o
 * nickname e clicar em "Continue", o tabuleiro
 * do jogo deve ficar visível, confirmando que a partida foi iniciada.</p>
 *
 * @author 99328
 * @version 1.0
 * @see UserStory1
 */
public class UserStory1Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory1 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory1(driver);
        battleshipPage.abrirPaginaBattleship();
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
     * Testa que ao clicar em "Play vs robot", preencher o nickname e
     * confirmar, o tabuleiro do jogo fica visível.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest1):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar no botão "Play vs robot"</li>
     *   <li>Aguardar o diálogo de nickname</li>
     *   <li>Preencher o nickname e clicar em "Continue"</li>
     *   <li>Verificar que o tabuleiro está visível</li>
     * </ol>
     */
    @Test
    public void testIniciarPartidaContraRobot() throws InterruptedException {
        Thread.sleep(2000);
        battleshipPage.clicarJogarContraRobot();
        Thread.sleep(2000);
        battleshipPage.aguardarDialogoNickname();
        Thread.sleep(2000);
        battleshipPage.preencherNicknameEContinuar("asd");
        Thread.sleep(2000);

        assertTrue(
                battleshipPage.tabuleiroEstaVisivel(),
                "O tabuleiro do jogo deveria estar visível após iniciar partida contra o robot"
        );
        Thread.sleep(2000);
    }
}