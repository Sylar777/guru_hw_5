import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionsEnterpriseTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="3840x2160";
        Configuration.timeout = 10000;
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }

    @Test
    void enterpriseLoadedTest() {
        open("https://github.com");
        $x("//button[contains(text(), 'Solutions')]").hover();
        $x("//span[@id='solutions-for-heading']/..//a[contains(text(),'Enterprise')]").click();
        $("#hero-section-brand-heading").shouldBe(visible);
    }
}
