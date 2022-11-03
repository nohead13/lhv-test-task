package ee.lhv.home.task.page;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

     public void acceptCookies() {
        $("a[id=acceptPirukas]").should(appear).click();
    }

}
