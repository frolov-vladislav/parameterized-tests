package com.vladfrolov.actions;
import com.vladfrolov.page.AccountHistoryButtons;
import static com.codeborne.selenide.Selenide.element;

public class AccountPage {

    public void clickOnAccountButton(AccountHistoryButtons accountHistoryButtons) {
        element(accountHistoryButtons.getSelector()).click();
    }
}