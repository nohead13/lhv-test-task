package ee.lhv.home.task.test;

import com.codeborne.selenide.Selenide;
import ee.lhv.home.task.BaseSetup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class maxPaymentTests extends BaseSetup {

    @BeforeEach
    void setupEETests() {
        Selenide.clearBrowserCookies();
        openTestApplication(ET_LEASING_MONTHLY_PAYMENT);
    }

    @Test
    @Tag("EE")
    @Tag("max-payment")
    @DisplayName("Check warning message for small income")
    void checkWarningMessageForSmallIncome() {
        leasingPage
                .clickOnMaximumMonthlyInstalmentToggle()
                .setNetIncomeAndCheck("800")
                .checkIfWarningMessageForNetIncomeTooSmallVisible(false)
                .setNetIncomeAndCheck("799")
                .checkIfWarningMessageForNetIncomeTooSmallVisible(true);
    }

}
