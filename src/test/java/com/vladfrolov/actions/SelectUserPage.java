package com.vladfrolov.actions;

public class SelectUserPage extends com.vladfrolov.page.SelectUserPage {

    public void login(String login) {
        usersMenu.selectOption(login);
        loginButton.click();
    }
}