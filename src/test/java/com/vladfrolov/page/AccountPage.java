package com.vladfrolov.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class AccountPage {

    protected ElementsCollection accountInfo = elements(".center .ng-binding");
    protected SelenideElement loginInTitle = element(".fontBig.ng-binding");
}