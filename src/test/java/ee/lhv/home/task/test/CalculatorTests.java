package ee.lhv.home.task.test;

import com.codeborne.selenide.Selenide;
import ee.lhv.home.task.BaseSetup;
import org.junit.jupiter.api.*;

public class CalculatorTests  extends BaseSetup {

    @BeforeEach
    void setupEETests() {
        Selenide.clearBrowserCookies();
        openTestApplication(ET_LEASING_MONTHLY_PAYMENT);
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check private customer with monthly instalment")
    void checkDefaultCalculationForPrivateCustomer() {
        leasingPage
                .checkRadioButtonPrivatePersonHaveValueChecked()
                .checkRadioButtonFinancialLeaseChecked()
                .checkDefaultPriceValue()
                .checkCheckBoxForVATSelected(true)
                .checkDownpayment("10","1500")
                .checkLeasingPeriod("6", "0")
                .checkInterestRate("4")
                .checkResidualValue("10","1500")
                .checkMonthlyPaymentValue("192.74");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check legal customer with selected operational lease and final monthly instalment")
    void checkDefaultCalculationForLegalCustomerForOperationalLease() {
        leasingPage
                .clickOnRadioButtonLegalPerson()
                .clickOnRadioButtonOperationalLease()
                .checkDefaultPriceValue()
                .checkCheckBoxForVATSelected(true)
                .checkDownpayment("10","1500")
                .checkLeasingPeriod("6","")
                .checkInterestRate("4")
                .checkResidualValue("10","1500")
                .checkMonthlyPaymentValue("188.28");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check fields size of inputs and using dots and comma in double numbers")
    void checkFieldsInputSizeAndUsingDotAndComma() {
        leasingPage
                .clickOnRadioButtonOperationalLease()
                .setPriceValueAndCheckIt("10000,0559005","10000,055")
                .setInitialValueAndCheckIt("001.05","0.01")
                .setResidualValue("123,1234")
                .checkResidualValue("1.23","123,12")
                .checkMonthlyPaymentValue("151.87");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check operational lease with price includes VAT and not")
    void checkVATCheckboxInOperationalLeaseForPrivateCustomer() {
        leasingPage
                .clickOnRadioButtonOperationalLease()
                .checkMonthlyPaymentValue("188.28")
                .clickOnCheckBoxForVAT()
                .checkCheckBoxForVATSelected(false)
                .checkMonthlyPaymentValue("225.94");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check leasing period less than 6 month")
    void checkMinimalLeasingPeriodFinancialLease() {
        leasingPage
                .setLeasingPeriod("0","2")
                .checkMonthlyPaymentValue("0.00")
                .setLeasingPeriod("0","4")
                //For 4 and 5 month with 0 years should be monthly payment "0", but result shown.
                .checkMonthlyPaymentValue("3030.04");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check payment schedule list on new page")
    void checkPaymentScheduleButtonOpenNewPageWithData() {
        leasingPage
                .setLeasingPeriod("0","6")
                .clickOnPaymentScheduleAndCheck()
                .checkPaymentSchedulePageAndLastRowData(
                        "Näidismaksegraafik",
                        6,
                        "Kokku",
                        "15000.00");
    }

    @Test
    @Tag("EE")
    @Tag("calculator")
    @DisplayName("Check click on apply here button and redirect to leasing application page")
    void checkClickApplyApplicationAndRedirect() {
        leasingPage.clickOnApplyHereButtonAndCheckRedirectForEE();
    }

    //possible tests
    //price from min 7500
    //amount of taken min 5000
    //if operational lease from 1m - 6 y
    //input length check
    // fieldPriceOfTheVehicle
    // fieldInitialPercentage
    // fieldInitial
    // fieldInterestRate
    // fieldReminderPercentage
    // fieldReminder
    //period 7y
}
