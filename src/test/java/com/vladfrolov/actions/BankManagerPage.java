package com.vladfrolov.actions;

import com.vladfrolov.page.BankManagerButtons;
import static com.codeborne.selenide.Selenide.element;

public class BankManagerPage extends com.vladfrolov.page.BankManagerPage {

    public void clickOnBankManagerButton(BankManagerButtons bankManagerButtons) {
        element(bankManagerButtons.getSelector()).click();
    }

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
}
