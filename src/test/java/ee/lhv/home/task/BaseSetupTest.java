package ee.lhv.home.task;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.System.setProperty;

@ExtendWith({TextReportExtension.class})
public class BaseSetupTest {

    public static final String ET_LEASING_MONTHLY_PAYMENT = "et/liising#kalkulaator";
    public static final String EN_LEASING_MONTHLY_PAYMENT = "en/leasing#Calculate";
    public static final String RU_LEASING_MONTHLY_PAYMENT = "ru/lizing#kalkuljator";

    protected static void getBaseUrl() {
        baseUrl = "https://www.lhv.ee/";
    }

    public static void openTestApplication() {
        getBaseUrl();
//        if (language.equals(ET_LANGUAGE) || language.equals(EN_LANGUAGE)
//                || language.equals(RU_LANGUAGE)) {
//            open("https://www.lhv.ee/"+language+"/");
//        } else {
//            System.err.println("Wrong language selected");
//        }
    }

    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    private static void initBrowser() {
        setProperty("selenide.browser", "chrome");
        Configuration.headless = false;
    }

    @BeforeAll
    static void init() {
        setupAllureReports();
        openTestApplication();
        initBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }

}
