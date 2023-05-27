package com.vladfrolov.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.element;

public class BankManagerPage {
    protected SelenideElement addCustomerButton = element("button[ng-click='addCust()']"),
    firstNameField = element("input[ng-model='fName']"),
    lastNameField = element("input[ng-model='lName']"),
    postCodeField = element("input[ng-model='postCd']"),
    submitCustomerButton = element("button.btn-default");
}
