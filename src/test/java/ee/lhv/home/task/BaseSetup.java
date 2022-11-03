package ee.lhv.home.task;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import ee.lhv.home.task.page.BasePage;
import ee.lhv.home.task.page.LeasingPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.System.setProperty;

@ExtendWith({TextReportExtension.class})
public class BaseSetup {

    protected BasePage basePage = new BasePage();
    protected LeasingPage leasingPage = new LeasingPage();
    public static final String ET_LEASING_MONTHLY_PAYMENT = "/et/liising#kalkulaator";
    /**
     * Possible to use also other links to en, ru localization
     * public static final String EN_LEASING_MONTHLY_PAYMENT = "/en/leasing#Calculate";
     * public static final String RU_LEASING_MONTHLY_PAYMENT = "/ru/lizing#kalkuljator";
     */

    public static void getBaseUrl() {
        baseUrl = "https://www.lhv.ee";
    }

    protected void openTestApplication(String page) {
        getBaseUrl();
        open(page);
        basePage.acceptCookies();
    }

    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    private static void initChromeBrowser() {
        setProperty("selenide.browser", "chrome");
        Configuration.headless = false;
    }

    @BeforeAll
    public static void init() {
        setupAllureReports();
        initChromeBrowser();
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }

}
