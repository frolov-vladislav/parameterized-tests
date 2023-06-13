package com.vladfrolov.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.element;

public class BankManagerPage {
    protected SelenideElement addCustomerButton = element("button[ng-click='addCust()']"),
    firstNameField = element("input[ng-model='fName']"),
    lastNameField = element("input[ng-model='lName']"),
    postCodeField = element("input[ng-model='postCd']"),
    submitCustomerButton = element("button.btn-default");

    public void fillFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void fillLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillPostCodeField(String postCode) {
        postCodeField.sendKeys(postCode);
    }

    public void submitCustomer() {
        submitCustomerButton.click();
    }

    public void clickOnBankManagerButton(BankManagerButtons bankManagerButtons) {
        element(bankManagerButtons.getSelector()).click();
    }

    public void arrayUnderButtonIsVisible(BankManagerButtons bankManagerButtons) {
        element(bankManagerButtons.getSelector()).$("#notch").shouldBe(visible);
    }

    public void alertIs(String expected) {
        String actual = Selenide.switchTo().alert().getText();
        Assertions.assertTrue(actual.contains(expected));
    }
}
