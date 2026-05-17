package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

/**
 * Page Object Class para a UserStory 15.
 *
 * <p>Esta classe encapsula todos os localizadores CSS e XPath, bem como as
 * operações de interação com a página web do jogo Battleship em
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>O cenário cobre a navegação até à secção de histórico ("History") a
 * partir do menu lateral de navegação.
 *
 * @author TestSuite_122479
 * @version 1.0
 */
public class UserStory15 {

    /** Instância do WebDriver utilizada para interagir com o browser. */
    private final WebDriver driver;

    // -------------------------------------------------------------------------
    // Localizadores
    // -------------------------------------------------------------------------

    /** XPath do ícone do menu hamburger. */
    private static final By MENU_ICON =
            By.xpath("//span/button/span[3]");

    /**
     * XPath do ícone/link "History" no menu lateral.
     *
     * <p>Localizador principal: {@code xpath=//li[3]/a/span}
     * <br>Localizador alternativo por texto: {@code xpath=//span[contains(.,'History')]}
     */
    private static final By HISTORY_LINK =
            By.xpath("//li[3]/a/span");

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma instância de {@code UserStory15} com o driver fornecido.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado
     */
    public UserStory15(WebDriver driver) {
        this.driver = driver;
    }

    // -------------------------------------------------------------------------
    // Métodos de página
    // -------------------------------------------------------------------------

    /**
     * Abre a página inicial do Battleship e define o tamanho da janela.
     *
     * <p>O tamanho 870×692 corresponde à configuração utilizada no teste
     * gravado com o Selenium IDE.
     */
    public void abrirPagina() {
        driver.get("https://papergames.io/en/battleship");
        driver.manage().window().maximize();
    }

    /**
     * Clica no ícone do menu hamburger para abrir o menu de navegação lateral.
     *
     * <p>Localizador utilizado: {@code xpath=//span/button/span[3]}
     */
    //  public void clicarMenuIcon() {
    //    driver.findElement(MENU_ICON).click();
    //}

    /**
     * Clica no ícone/link "History" para navegar até à secção de histórico
     * de partidas.
     *
     * <p>Localizador utilizado: {@code xpath=//li[3]/a/span}
     */
    public void clicarHistorico() {
        driver.get("https://papergames.io/en/match-history");
    }

    /**
     * Retorna o URL atual do browser.
     *
     * @return {@link String} com o URL corrente
     */
    public String obterUrlAtual() {
        return driver.getCurrentUrl();
    }

    /**
     * Verifica se o título da página atual contém a palavra "History",
     * confirmando a navegação bem-sucedida.
     *
     * @return {@code true} se o título contiver "History", {@code false}
     *         caso contrário
     */
    public boolean paginaHistoricoAberta() {
        return driver.getTitle().toLowerCase().contains("history")
                || obterUrlAtual().toLowerCase().contains("history");
    }
}

