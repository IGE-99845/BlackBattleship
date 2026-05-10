package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class para a User Story 3.
 *
 * <p>US03: Como jogador, quero iniciar uma partida contra um jogador aleatório
 * online, para que possa competir com desconhecidos a qualquer momento.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de matchmaking do papergames.io,
 * utilizando os métodos definidos em {@link UserStory3}.</p>
 *
 * <p>Critério de aceitação: após clicar em "Play online with a random player" e
 * preencher o nickname e clicar em "Continue", o contentor principal do jogo deve
 * ficar visível, confirmando que o processo de matchmaking foi iniciado e o jogador
 * entrou na fila de espera.</p>
 *
 * @author 99328
 * @version 1.0
 * @see UserStory3
 */
public class UserStory3Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory3 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory3(driver);
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
     * Testa que ao clicar em "Play online with a random player", preencher
     * o nickname e confirmar, o processo de matchmaking é iniciado.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest3):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar no botão "Play online with a random player"</li>
     *   <li>Aguardar o diálogo de nickname</li>
     *   <li>Preencher o nickname e clicar em "Continue"</li>
     *   <li>Verificar que o contentor do jogo está visível</li>
     * </ol>
     */
    @Test
    public void testIniciarMatchmakingContraJogadorAleatorio() throws InterruptedException {
        Thread.sleep(2000);
        battleshipPage.clicarJogarContraJogadorAleatorio();
        Thread.sleep(2000);
        battleshipPage.aguardarDialogoNickname();
        Thread.sleep(2000);
        battleshipPage.preencherNicknameEContinuar("asd");
        Thread.sleep(2000);

        assertTrue(
                battleshipPage.jogoEstaVisivel(),
                "O contentor do jogo deveria estar visível após iniciar matchmaking"
        );
        Thread.sleep(2000);
    }
}