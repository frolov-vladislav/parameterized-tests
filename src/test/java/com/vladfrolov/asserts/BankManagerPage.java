package com.vladfrolov.asserts;

import com.codeborne.selenide.Selenide;
import com.vladfrolov.page.BankManagerButtons;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class BankManagerPage {

    public void arrayUnderButtonIsVisible(BankManagerButtons bankManagerButtons) {
        element(bankManagerButtons.getSelector()).$("#notch").shouldBe(visible);
    }

    public void alertIs(String expected) {
       String actual = Selenide.switchTo().alert().getText();
        Assertions.assertTrue(actual.contains(expected));
    }
}