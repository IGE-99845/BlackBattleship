package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Page Test Class para a User Story 7.
 *
 * <p>US07: Como jogador, quero poder consultar as regras do jogo
 * diretamente na página, para que possa perceber como jogar
 * sem sair do site.</p>
 *
 * <p>Esta classe contém os testes JUnit que verificam o comportamento
 * da funcionalidade de visualização das regras no papergames.io,
 * utilizando os métodos definidos em {@link UserStory7}.</p>
 *
 * <p>Critério de aceitação: após fazer scroll até à secção de regras,
 * o título {@code h2:nth-child(2)} deve conter o texto
 * "Rules of Battleship game online", confirmando que a secção
 * está acessível na página.</p>
 *
 * @author 99845
 * @version 1.0
 * @see UserStory7
 */
public class UserStory7Test {

    /** WebDriver utilizado para controlar o browser durante os testes. */
    private WebDriver driver;

    /** Page Object que encapsula as operações da página do Battleship. */
    private UserStory7 battleshipPage;

    /**
     * Configura o ambiente de teste antes de cada método de teste.
     * Inicializa o ChromeDriver e a Page Object Class,
     * e navega para a página de Batalha Naval.
     */
    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        battleshipPage = new UserStory7(driver);
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
     * Testa que após fazer scroll até às regras do jogo, o título
     * "Rules of Battleship game online" está visível na página.
     *
     * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest7):</p>
     * <ol>
     *   <li>Abrir a página do Battleship (feito no setUp)</li>
     *   <li>Fazer scroll suave até ao primeiro {@code <h2>} da página</li>
     *   <li>Aguardar 1 segundo para a animação de scroll terminar</li>
     *   <li>Verificar que o texto do {@code h2:nth-child(2)} é
     *       "Rules of Battleship game online"</li>
     * </ol>
     */
    @Test
    public void testVerificarTituloRegras() throws InterruptedException {
        Thread.sleep(3000);
        battleshipPage.scrollAteRegras();
        Thread.sleep(2000);

        assertEquals(
                UserStory7.TEXTO_REGRAS_ESPERADO,
                battleshipPage.obterTextoTituloRegras(),
                "O título das regras deveria ser 'Rules of Battleship game online'"
        );
        Thread.sleep(2000);
    }
}
