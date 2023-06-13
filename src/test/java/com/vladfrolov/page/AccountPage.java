package com.vladfrolov.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class AccountPage {

    protected ElementsCollection accountInfo = elements(".center .ng-binding");
    protected SelenideElement loginInTitle = element(".fontBig.ng-binding");

    public void clickOnAccountButton(AccountHistoryButtons accountHistoryButtons) {
        element(accountHistoryButtons.getSelector()).click();
    }

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