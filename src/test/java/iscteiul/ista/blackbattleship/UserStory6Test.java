package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class para a User Story 6.
 *
 * <p>US06: Como jogador, quero jogar contra o robô como convidado,
 * selecionar uma arma especial (míssil) e disparar sobre uma célula
 * do tabuleiro adversário, para que possa experimentar as mecânicas
 * de combate do jogo.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de jogar contra o robô no papergames.io,
 * utilizando os métodos definidos em {@link UserStory6}.</p>
 *
 * <p>Critério de aceitação: após clicar em "Play vs Bot", preencher o
 * username, selecionar a arma míssil e disparar na célula 5-3, o SVG
 * de resultado do tiro deve ficar visível nessa célula, confirmando
 * que o disparo foi registado com sucesso.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory6
 */
public class UserStory6Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory6 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory6(driver);
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
     * Testa que ao jogar contra o robô como convidado, selecionar o míssil
     * e disparar na célula 5-3, o resultado do tiro fica visível.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest6):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar em "Play vs Bot"</li>
     *   <li>Inserir o username "ASD" e clicar em "Continue"</li>
     *   <li>Selecionar a arma especial míssil</li>
     *   <li>Aguardar que o tabuleiro adversário fique visível (turno do jogador)</li>
     *   <li>Disparar na célula 5-3</li>
     *   <li>Verificar que o SVG de resultado aparece na célula 5-3</li>
     * </ol>
     */
    @Test
    public void testJogarContraRoboEDisparar() throws InterruptedException {
        Thread.sleep(3000);
        battleshipPage.selecionarJogarContraRobo();
        Thread.sleep(3000);
        battleshipPage.inserirUsername("ASD");
        battleshipPage.clicarContinuar();
        Thread.sleep(3000);
        battleshipPage.selecionarArmaMissil();
        Thread.sleep(3000);
        battleshipPage.aguardarTurnoJogador();
        Thread.sleep(3000);
        battleshipPage.dispararNaCelula5_3();

        assertTrue(
                battleshipPage.tiroNaCelula5_3Confirmado(),
                "O SVG de resultado deveria estar visível na célula 5-3 após o disparo"
        );
        Thread.sleep(3000);
    }
}