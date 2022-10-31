package ee.lhv.home.task.test;

import com.codeborne.selenide.SelenideElement;
import ee.lhv.home.task.BaseSetupTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CalculatorTests  extends BaseSetupTest {

    @BeforeAll
    static void setupEETests() {
        openA(ET_LANGUAGE);
        open("liising#kalkulaator");
    }

    @Test
    @Tag("EE")
    @DisplayName("Approve cookies")
    void clickOnCalculate() {
        $("div#pirukas").should(appear);
        $("a[id=acceptPirukas]").should(appear).click();
        //Selenide.refresh();
//        open();
        SelenideElement element = $("input[id=\"account_type-0\"]");
        actions().moveToElement(element);
        //$("input[id=\"account_type-0\"]").should(appear).scrollIntoView(true);
        $("input[id=\"account_type-0\"]").shouldBe(checked);
    }

    //every test check month payment, grafic

    //erasik
        //kapital
        //kasutusrent
    //legal
        //kapital
        //kasutusrent
    //max period
    //min period

    //check max paymet by income
}
