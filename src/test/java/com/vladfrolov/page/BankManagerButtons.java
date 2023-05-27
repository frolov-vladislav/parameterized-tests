package com.vladfrolov.page;

public enum BankManagerButtons {
    ADD_CUSTOMER("button[ng-click='addCust()']"),
    OPEN_ACCOUNT("button[ng-click='openAccount()']"),
    CUSTOMERS("button[ng-click='showCust()']");

    private String selector;

    BankManagerButtons(String button) {
        this.selector = button;
    }

    public String getSelector() {
        return selector;
    }
}