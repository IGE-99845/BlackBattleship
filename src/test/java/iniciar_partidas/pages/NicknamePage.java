package iniciar_partidas.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

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
     * Preenche o nickname no campo de texto e clica em "Continue" para avançar.
     *
     * <p>Este método aguarda até 5 segundos que o diálogo de registo apareça.
     * Caso o diálogo não apareça dentro desse período, o método
     * termina silenciosamente sem erro, permitindo que o teste continue.</p>
     *
     * @param nickname o nome de utilizador a introduzir no campo de texto
     */
    public void preencherEContinuar(String nickname) {
        try {
            dialogSection.shouldBe(Condition.visible, Duration.ofSeconds(5));
            nicknameInput.shouldBe(Condition.visible).setValue(nickname);
            continueButton.shouldBe(Condition.visible).click();
        } catch (Exception e) {
            // O diálogo não apareceu dentro do timeout — provavelmente já estamos autenticados
        }
    }
}