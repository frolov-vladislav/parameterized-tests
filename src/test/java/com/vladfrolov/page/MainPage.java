package com.vladfrolov.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class MainPage {
    protected SelenideElement customerLoginButton = element("button[ng-click='customer()']"),
            bankManagerLoginButton = element("button[ng-click='manager()']");

    public void clickOnCustomerLogin() {
        customerLoginButton.click();
    }

    public void clickOnBankManagerLogin() {
        bankManagerLoginButton.click();
    }
}
