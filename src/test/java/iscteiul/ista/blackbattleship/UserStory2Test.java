package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Page Test Class para a User Story 2.
 *
 * <p>US02: Como jogador, quero iniciar uma partida com um amigo através de um
 * link único, para que possamos jogar em tempo real sem necessitar de conta.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de gerar um link único de convite no papergames.io,
 * utilizando os métodos definidos em {@link UserStory2}.</p>
 *
 * <p>Critério de aceitação: após clicar em "Play with a friend" e preencher o nickname e clicar em "Continue", o contentor
 * com o link/QR code de convite deve ficar visível, confirmando que o link
 * único foi gerado e pode ser partilhado.</p>
 *
 * @author 99328
 * @version 1.0
 * @see UserStory2
 */
public class UserStory2Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory2 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory2(driver);
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
     * Testa que ao clicar em "Play with a friend", preencher o nickname e
     * confirmar, é gerado um link único de convite visível na página.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest2):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Clicar no botão "Play with a friend"</li>
     *   <li>Aguardar o diálogo de nickname</li>
     *   <li>Preencher o nickname e clicar em "Continue"</li>
     *   <li>Verificar que o link/QR code de convite está visível</li>
     * </ol>
     */
    @Test
    public void testGerarLinkConviteParaAmigo() throws InterruptedException {
        Thread.sleep(2000);
        battleshipPage.clicarJogarComAmigo();
        Thread.sleep(2000);
        battleshipPage.aguardarDialogoNickname();
        Thread.sleep(2000);
        battleshipPage.preencherNicknameEContinuar("asd");
        Thread.sleep(2000);

        assertTrue(
                battleshipPage.linkConviteEstaVisivel(),
                "O link/QR code de convite deveria estar visível após preencher o nickname"
        );
        Thread.sleep(2000);
    }
}