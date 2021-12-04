package ru.netology.test;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import ru.netology.data.DataGenerator;


import java.time.Duration;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryTest {
    @Test
    void shouldTestFormCardDeliveryOrdering() {

        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue(DataGenerator.generateCity());
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date'] input").setValue(DataGenerator.generateData(4));
        $("[data-test-id='name'] input").setValue(DataGenerator.generateName());
        $("[data-test-id='phone'] input").setValue(DataGenerator.generatePhone());
        $("[data-test-id='agreement']").click();
        $(".grid-row [role='button' ]").click();
        $(withText("Встреча успешно")).shouldBe(Condition.visible);
        $(".grid-row [role='button' ]").click();
        $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String newMeetingDate = DataGenerator.generateData(7);
        $("[data-test-id='date'] input").setValue(newMeetingDate);
        $(withText("Необходимо подтверждение")).shouldBe(Condition.visible);
        $(".notification_status_error .button").click();
        $(withText("Успешно!")).shouldBe(Condition.visible);
        $("[data-test-id='success-notification'] .notification__content").shouldBe(Condition.visible).shouldHave
                (Condition.exactText("Встреча успешно запланирована на " + newMeetingDate));;


    }
}
