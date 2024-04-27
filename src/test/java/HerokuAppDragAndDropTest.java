import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppDragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "3840x2160";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.timeout = 10000;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void dragAndDropTest() {
        open("/drag_and_drop");
        $("#column-a").$x(".//header[text()='A']").shouldBe(enabled);
        $("#column-a").dragAndDrop(to("#column-b"));
        $("#column-b").$x(".//header[text()='A']").shouldBe(enabled);
    }

    @Test
    void dragAndDropByActionTest() {
        open("/drag_and_drop");
        $("#column-a").$x(".//header[text()='A']").shouldBe(enabled);
        actions()
                .dragAndDrop($("#column-a"), $("#column-b"))
                .perform();
        $("#column-b").$x(".//header[text()='A']").shouldBe(enabled);
    }
}
