package configurar_e_gerir.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import configurar_e_gerir.page.RulesPage;
import iniciar_partidas.pages.BattleshipPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Teste Selenide para o cenário UserStoryTest7.
 *
 * <p>Passos do cenário (baseados no Selenium IDE UserStoryTest7):</p>
 * <ol>
 *   <li>Abrir a página — reutiliza {@link BattleshipPage#abrir()}</li>
 *   <li>Fazer scroll até ao título das regras</li>
 *   <li>Verificar o texto "Rules of Battleship game online"</li>
 * </ol>
 *
 * <p>Nota: o {@code pause} do Selenium IDE não é necessário —
 * o Selenide aguarda automaticamente a visibilidade dos elementos.</p>
 *
 * @author 99845
 * @version 1.0
 */
@Story("US07 - Verificar regras do jogo visíveis")
class UserStory7SelenideTest extends BaseTest {

    /**
     * Testa que a secção de regras do jogo existe na página e contém
     * o título correto "Rules of Battleship game online".
     *
     * <p>Critério de aceitação: o elemento h2 com o texto correto está visível.</p>
     */
    @Test
    @Description("Fazer scroll até às regras e verificar o título da secção")
    void testVerificarRegrasDojogo() throws InterruptedException {
        BattleshipPage battleshipPage = new BattleshipPage();
        RulesPage rulesPage = new RulesPage();

        battleshipPage.abrir();
        rulesPage.scrollAteRegras();
        rulesPage.getTituloRegras().shouldBe(Condition.visible);
        assertEquals("Rules of Battleship game online", rulesPage.obterTextoTituloRegras());
    }
}