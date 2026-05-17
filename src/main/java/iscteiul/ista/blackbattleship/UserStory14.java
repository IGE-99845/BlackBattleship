package iscteiul.ista.blackbattleship;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

/**
 * Page Object Class para a UserStory 14.
 *
 * <p>Esta classe encapsula todos os localizadores CSS e XPath, bem como as
 * operações de interação com a página web do jogo Battleship em
 * <a href="https://papergames.io/en/battleship">papergames.io</a>.
 *
 * <p>O cenário cobre a ação de logout do utilizador autenticado, acedendo
 * às opções de perfil a partir do menu hamburger.
 *
 * @author TestSuite_122479
 * @version 1.0
 */
public class UserStory14 {

    /** Instância do WebDriver utilizada para interagir com o browser. */
    private final WebDriver driver;

    // -------------------------------------------------------------------------
    // Localizadores
    // -------------------------------------------------------------------------

    /** XPath do ícone do menu hamburger. */
    private static final By MENU_ICON =
            By.xpath("//span/button/span[3]");

    /**
     * CSS Selector para a imagem de perfil do utilizador.
     *
     * <p>Localizador: {@code css=.user-profile img}
     */
    private static final By PROFILE_IMAGE =
            By.cssSelector(".user-profile img");

    /**
     * XPath do botão de logout no painel do menu de perfil.
     *
     * <p>Localizador: {@code xpath=//div[@id='mat-menu-panel-serverApp0']/div/button[2]/span/span}
     */
    private static final By LOGOUT_BUTTON =
            By.xpath("//div[@id='mat-menu-panel-serverApp0']/div/button[2]/span/span");

    // -------------------------------------------------------------------------
    // Construtor
    // -------------------------------------------------------------------------

    /**
     * Constrói uma instância de {@code UserStory14} com o driver fornecido.
     *
     * @param driver o {@link WebDriver} já instanciado e configurado
     */
    public UserStory14(WebDriver driver) {
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
        driver.manage().window().setSize(new Dimension(870, 692));
    }

    /**
     * Clica no ícone do menu hamburger para abrir o menu de navegação lateral.
     *
     * <p>Localizador utilizado: {@code xpath=//span/button/span[3]}
     */
    public void clicarMenuIcon() {
        driver.findElement(MENU_ICON).click();
    }

    /**
     * Clica na imagem de avatar/perfil do utilizador para abrir o menu de
     * conta.
     *
     * <p>Localizador utilizado: {@code css=.user-profile img}
     */
    public void clicarFotoPerfil() {
        driver.findElement(PROFILE_IMAGE).click();
    }

    /**
     * Clica no botão de logout presente no menu de perfil do utilizador.
     *
     * <p>Localizador utilizado:
     * {@code xpath=//div[@id='mat-menu-panel-serverApp0']/div/button[2]/span/span}
     */
    public void clicarLogout() {
        driver.findElement(LOGOUT_BUTTON).click();
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
     * Verifica se o elemento de imagem de perfil está presente na página,
     * o que indica que o utilizador ainda está autenticado.
     *
     * @return {@code true} se o elemento de perfil existir, {@code false}
     *         caso contrário
     */
    public boolean estaAutenticado() {
        return !driver.findElements(PROFILE_IMAGE).isEmpty();
    }
}

