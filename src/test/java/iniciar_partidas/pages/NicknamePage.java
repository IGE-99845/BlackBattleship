package iniciar_partidas.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

/**
 * Page Object Class que representa o diálogo de registo de nickname.
 *
 * <p>Este diálogo aparece em todos os cenários quando o utilizador ainda
 * não tem sessão iniciada no papergames.io. Encapsula os localizadores
 * e ações sobre este diálogo, seguindo o padrão Page Object Model.</p>
 *
 * <p>Comparação com Selenium WebDriver: o método {@code preencherEContinuar}
 * substitui 3 métodos separados ({@code aguardarDialogoNickname},
 * {@code preencherNicknameEContinuar}) — o Selenide torna o código mais conciso
 * porque as esperas são implícitas.</p>
 *
 * @author 99328
 * @version 1.0
 */
public class NicknamePage {

    /**
     * Secção principal do diálogo de registo de nickname.
     * A sua visibilidade confirma que o diálogo está aberto.
     */
    private final SelenideElement dialogSection = $(".pt-4");

    /**
     * Campo de texto para introduzir o nickname.
     */
    private final SelenideElement nicknameInput = $(".input-xl");

    /**
     * Botão "Continue" para submeter o nickname.
     */
    private final SelenideElement continueButton = $(".p-3 > .btn");

    /**
     * Preenche o nickname e clica em "Continue" APENAS se o diálogo estiver visível.
     *
     * <p>Quando os testes correm em sequência na mesma sessão do browser,
     * o utilizador já está autenticado após o primeiro teste — o diálogo
     * não volta a aparecer. Este método trata ambos os casos sem erro.</p>
     *
     * @param nickname o nome de utilizador a introduzir
     */
    public void preencherEContinuar(String nickname) {
        if (dialogSection.exists() && dialogSection.isDisplayed()) {
            nicknameInput.click();
            nicknameInput.setValue(nickname);
            continueButton.click();
        }
    }
}