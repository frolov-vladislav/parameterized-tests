package com.vladfrolov.page;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.element;

public class SelectUserPage {

    public static final String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    protected SelenideElement usersMenu = element("#userSelect"),
            loginButton = element(".btn-default");
}