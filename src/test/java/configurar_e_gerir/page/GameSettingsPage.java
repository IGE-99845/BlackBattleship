package configurar_e_gerir.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Page Object Class que representa o diálogo de definições do jogo.
 *
 * <p>Encapsula os localizadores e ações para o cenário UserStoryTest5:
 * abrir as definições do jogo, selecionar "Custom options",
 * configurar o tempo de turno e guardar as alterações.</p>
 *
 * <p>Para abrir a página usar {@link BattleshipPage#abrir()}.</p>
 *
 * @author 99845
 * @version 1.0
 */

public class GameSettingsPage {
    /**
     * Botão de abertura das definições do jogo (ícone de engrenagem).
     * Localizador XPath retirado do Selenium IDE: {@code xpath=//span[2]/button/span[3]}.
     */
    private final SelenideElement btnSettings =
            $(By.xpath("//span[2]/button/span[3]"));

    /**
     * Botão "Custom options" no diálogo de configurações.
     */
    private final SelenideElement btnCustomOptions =
            $(".btn-sm:nth-child(2)");

    /**
     * Ícone SVG do dropdown de seleção do tempo de turno.
     */
    private final SelenideElement dropdownTempo =
            $("#mat-select-serverApp1 svg");

    /**
     * Opção "15 seconds" no dropdown de tempo de turno.
     */
    private final SelenideElement opcao15Segundos =
            $("#mat-option-serverApp10");

    /**
     * Botão "Save settings" para guardar as configurações.
     */
    private final SelenideElement btnGuardar =
            $(".gap-1:nth-child(2)");

    /**
     * Clica no botão de engrenagem para abrir o diálogo de configurações do jogo.
     */
    public void abrirDefinicoes() {
        btnSettings.click();
    }

    /**
     * Clica no botão "Custom options" para activar as opções avançadas do jogo.
     */
    public void clicarCustomOptions() {
        btnCustomOptions.click();
    }

    /**
     * Abre o dropdown de seleção do tempo de turno clicando no ícone SVG
     * do componente Angular Material {@code mat-select}.
     */
    public void abrirDropdownTempo() {
        dropdownTempo.click();
    }

    /**
     * Seleciona a opção "15 seconds" no dropdown de tempo de turno.
     */
    public void selecionarTempo15Segundos() {
        opcao15Segundos.click();
    }

    /**
     * Clica no botão "Save settings" para persistir as configurações.
     */
    public void guardarDefinicoes() {
        btnGuardar.click();
    }

    public SelenideElement getSaveSettingsButton() {
        return btnGuardar;
    }
}
