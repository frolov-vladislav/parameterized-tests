package com.vladfrolov.asserts;

import com.vladfrolov.page.AccountHistoryButtons;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class AccountPage extends com.vladfrolov.page.AccountPage {
    public void loginInTitleIs(String login) {
        loginInTitle.shouldBe(exactText(login));
    }

    public void accountNumberIs(int accountNumber) {
        this.accountInfo.get(0).shouldBe(exactText(String.valueOf(accountNumber)));
    }

    public void arrayUnderButtonIsVisible(AccountHistoryButtons accountHistoryButtons) {
        element(accountHistoryButtons.getSelector()).$("#notch").shouldBe(visible);
    }

}
