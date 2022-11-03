package ee.lhv.home.task.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class LeasingPage extends BasePage {

    //    Sample monthly instalment content
    SelenideElement radioButtonPrivatePerson = $("input#account_type-0");
    SelenideElement radioButtonLegalPerson = $("label[for=account_type-1]");
    SelenideElement radioButtonFinancialLease = $("input#kap_rent");
    SelenideElement radioButtonOperationalLease = $("label[for=kas_rent]");
    SelenideElement fieldPriceOfTheVehicle = $("input#price");
    SelenideElement checkBoxPriceIncludesVAT = $("input#vat_included");
    SelenideElement checkBoxPriceIncludesVATLabel = $("label[for=\"vat_included\"]");
    SelenideElement fieldInitialPercentage  = $("input#initial_percentage");
    SelenideElement fieldInitial  = $("input#initial");
    SelenideElement selectLeasingPeriodYears  = $("#period [name=years]");
    SelenideElement selectLeasingPeriodMonths  = $("#period [name=months]");
    SelenideElement fieldInterestRate = $("input#interest_rate");
    SelenideElement fieldReminderPercentage = $("input#reminder_percentage");
    SelenideElement fieldReminder = $("input#reminder");
    SelenideElement textMonthlyPaymentResult = $("#monthly-payment .calculator-result div.payment");
    SelenideElement buttonApplyHere = $("#monthly-payment a.btn-dark");
    SelenideElement buttonPaymentSchedule = $("#monthly-payment a.payment-graph-link");

    //    Maximum monthly instalment content
    SelenideElement buttonToggleMaximumPayment = $("[href=\"#max-payment\"]");
    SelenideElement fieldNetIncome = $("input#monthly-income");
    SelenideElement textWarningMessage = $("div#max-payment .calculator-error");

    //    Payment schedule page
    ElementsCollection paymentTableRowsCollection = $$("tbody tr");
    ElementsCollection paymentTableFooterRowCollection = $$("tfoot td");

    public LeasingPage checkRadioButtonPrivatePersonHaveValueChecked() {
        radioButtonPrivatePerson.shouldHave(attribute("checked"));
        return this;
    }

    public LeasingPage clickOnRadioButtonLegalPerson() {
        radioButtonLegalPerson
                .should(appear)
                .click();
        return this;
    }

    public LeasingPage checkRadioButtonFinancialLeaseChecked() {
        radioButtonFinancialLease.shouldHave(attribute("checked"));
        return this;
    }

    public LeasingPage clickOnRadioButtonOperationalLease() {
        radioButtonOperationalLease.should(appear).click();
        return this;
    }

    public LeasingPage checkCheckBoxForVATSelected(boolean selected) {
        if(selected){
            checkBoxPriceIncludesVAT.shouldBe(checked);
        } else {
            checkBoxPriceIncludesVAT.shouldNotBe(checked);
        }
        return this;
    }

    public LeasingPage clickOnCheckBoxForVAT() {
        checkBoxPriceIncludesVATLabel.click();
        return this;
    }


    public LeasingPage setPriceValueAndCheckIt(String setValue, String expectedValue) {
        fieldPriceOfTheVehicle
                .should(appear)
                .setValue(setValue)
                .shouldHave(value(expectedValue));
        return this;
    }

    public LeasingPage checkDefaultPriceValue() {
        fieldPriceOfTheVehicle
                .should(appear)
                .shouldHave(attribute("value","15 000"));
        return this;
    }

    public LeasingPage checkDownpayment(String initialPercentageValue,String initialValue) {
        fieldInitialPercentage.shouldHave(attribute("value",initialPercentageValue));
        fieldInitial.shouldHave(attribute("value", initialValue));
        return this;
    }

    /**
     * Check selected years and months
     * @param years could be selected from 1-7 for financial lease, and 1-6 for operational lease.
     *        for maximum value of year month selector will be hidden.
     * @param month could be selected from 1-12
     */
    public LeasingPage checkLeasingPeriod(String years, String month) {
        selectLeasingPeriodYears.getSelectedOptionText().equals(years);
        selectLeasingPeriodMonths.getSelectedOptionValue().equals(month);
        return this;
    }

    /**
     * Set in option years and months
     * @param years could be selected from 1-7 for financial lease, and 1-6 for operational lease.
     *        for maximum value of year month selector will be hidden.
     * @param month could be selected from 1-12
     */
    public LeasingPage setLeasingPeriod(String years, String month) {
        selectLeasingPeriodYears.selectOptionContainingText(years);
        selectLeasingPeriodMonths.selectOptionContainingText(month);
        return this;
    }

    public LeasingPage checkInterestRate(String interestRateValue) {
        fieldInterestRate.should(appear).shouldHave(attribute("value", interestRateValue));
        return this;
    }

    public LeasingPage checkResidualValue(String reminderPercentage, String reminderValue) {
        fieldReminderPercentage.shouldHave(attribute("value",reminderPercentage));
        fieldReminder.shouldHave(attribute("value", reminderValue));
        return this;
    }

    public LeasingPage setResidualValue(String reminderValue) {
        fieldReminder.should(appear).setValue(reminderValue);
        return this;
    }

    public LeasingPage checkMonthlyPaymentValue(String expectedValue) {
        textMonthlyPaymentResult
                .should(appear)
                .shouldHave(text(expectedValue));
        return this;
    }

    public LeasingPage setInitialValueAndCheckIt(String initialValue,String initialPercentageValue ) {
        fieldInitial
                .should(appear)
                .setValue(initialValue)
                .shouldHave(value(initialValue));
        fieldInitialPercentage.shouldHave(value(initialPercentageValue));
        return this;
    }

    public LeasingPage clickOnPaymentScheduleAndCheck() {
        buttonPaymentSchedule.should(appear).click();
        return this;
    }

    /**
     * Check move to new open tab with payment schedule table
     *
     * @param topic            depend on language should be changed "Payment schedule", "График платежей" , "Näidismaksegraafik";
     * @param monthsOfPayments n number of month of payments, used to guess number of rows in main part of table.
     *                         Expected sum of rows = n+2, additional 1st row is title of table, last row is
     *                         residual value row.
     *                         If day of request on end of month, or calculated only with fixed first day payment,
     *                         could me move to one more month. Checked by sizeLessThan <n+4.
     * @param totalText        depend on language could be "Total", "Итого", "Kokku";
     * @param principalValue   principal amount taken as price;
     */
    public void checkPaymentSchedulePageAndLastRowData(String topic, int monthsOfPayments, String totalText, String principalValue) {
        // Selenide switch focus to new tab
        switchTo().window(1);
        $("h1").should(appear).shouldHave(text(topic));
        paymentTableRowsCollection
                .shouldHave(sizeGreaterThanOrEqual(monthsOfPayments + 2))
                .shouldHave(sizeLessThan(monthsOfPayments + 4));
        // Check last row data in table
        paymentTableFooterRowCollection
                .shouldHave(size(5))
                .get(0).shouldHave(text(totalText));
        paymentTableFooterRowCollection
                .get(3).shouldHave(text(principalValue));
    }

    public LeasingPage clickOnMaximumMonthlyInstalmentToggle() {
        buttonToggleMaximumPayment.should(appear).click();
        return this;
    }

    public LeasingPage setNetIncomeAndCheck(String incomeValue) {
        fieldNetIncome
                .should(appear)
                .setValue(incomeValue)
                .shouldHave(attribute("value",incomeValue));
        return this;
    }

    public LeasingPage checkIfWarningMessageForNetIncomeTooSmallVisible(boolean status) {
        if(status){
            textWarningMessage
                    .should(appear)
                    .shouldHave(text("Maksimaalse kuumakse arvutamiseks on netosissetulek liiga väike."));
        } else {
            textWarningMessage.should(disappear);
        }
        return this;
    }

    public void clickOnApplyHereButtonAndCheckRedirectForEE() {
        buttonApplyHere.should(appear).click();
        webdriver().shouldHave(url("https://www.lhv.ee/et/liising/taotlus"));
    }

}
