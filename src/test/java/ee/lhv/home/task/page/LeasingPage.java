package ee.lhv.home.task.page;

import com.codeborne.selenide.SelenideElement;
import ee.lhv.home.task.BaseSetupTest;

import static com.codeborne.selenide.Selenide.$;

public class LeasingPage extends BaseSetupTest {

    //Sample monthly instalment content
    SelenideElement radioButtonPrivatePerson = $("input#account_type-0");
    SelenideElement radioButtonLegalPerson = $("input#account_type-1");
    SelenideElement radioButtonFinancialLease = $("input#kap_rent");
    SelenideElement radioButtonOperationalLease = $("input#kas_rent");
    SelenideElement fieldPriceOfTheVehicle = $("input#price"); //maxlength = 9;
    SelenideElement checkBoxPriceIncludesVAT = $("input#vat_included");
    SelenideElement fieldInitialPercentage  = $("input#initial_percentage"); //maxlength = 5;
    SelenideElement fieldInitial  = $("input#initial"); // maxlength = 6;
    SelenideElement selectLeasingPeriodYears  = $("#period [name=years]");
    SelenideElement selectLeasingPeriodMonths  = $("#period [name=months]");
    SelenideElement fieldInterestRate = $("input#interest_rate"); //maxlength = 4;
    SelenideElement fieldReminderPercentage = $("input#reminder_percentage"); //maxlength = 5;
    SelenideElement fieldReminder = $("input#reminder"); //maxlength = 6;
    SelenideElement textMonthlyPaymentResult = $("#monthly-payment .calculator-result div.payment");
    SelenideElement buttonApplyHere = $("#monthly-payment a.btn-dark");
    SelenideElement buttonPaymentSchedule = $("#monthly-payment a.payment-graph-link");

    //Maximum monthly instalment content
    SelenideElement textMaximumLimitOffered = $("#max-payment div.payment");
}
