package com.vladfrolov.page;

public enum AccountHistoryButtons {
    TRANSACTIONS("button[ng-click='transactions()']"),
    DEPOSIT("button[ng-click='deposit()']"),
    WITHDRAWL("button[ng-click='withdrawl()']");

    private String selector;

    AccountHistoryButtons(String button) {
        this.selector = button;
    }

    public String getSelector() {
        return selector;
    }
}