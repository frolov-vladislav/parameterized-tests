package com.vladfrolov;

import com.vladfrolov.page.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.open;
import static com.vladfrolov.TestData.*;

public class XyzBankTests {

    AccountPage accountPage = new AccountPage();
    BankManagerPage bankManagerPage = new BankManagerPage();
    MainPage mainPage = new MainPage();
    SelectUserPage selectUserPage = new SelectUserPage();

    @BeforeEach
    void before() {
        open(SelectUserPage.URL);
    }

    @ParameterizedTest(name = "{index} - Login as {0}")
    @ValueSource(strings = {
            "Hermoine Granger",
            "Harry Potter",
            "Ron Weasly",
            "Albus Dumbledore",
            "Neville Longbottom"
    })
    public void loginTest(String login) {
        mainPage.clickOnCustomerLogin();
        selectUserPage.login(login);
        accountPage.loginInTitleIs(login);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Hermoine Granger, 1001",
            "Harry Potter, 1004",
            "Ron Weasly, 1007",
            "Albus Dumbledore, 1010",
            "Neville Longbottom, 1013"
    })
    public void accountNumberTest(String login, int accountNumber) {
        mainPage.clickOnCustomerLogin();
        selectUserPage.login(login);
        accountPage.accountNumberIs(accountNumber);
    }

    @ParameterizedTest
    @EnumSource(value = AccountHistoryButtons.class, names = {"TRANSACTIONS"}, mode = EnumSource.Mode.EXCLUDE)
    public void arraysUnderAccountButtonsTest(AccountHistoryButtons accountHistoryButton) {
        mainPage.clickOnCustomerLogin();
        selectUserPage.login("Hermoine Granger");
        accountPage.clickOnAccountButton(accountHistoryButton);
        accountPage.arrayUnderButtonIsVisible(accountHistoryButton);
    }

    @ParameterizedTest
    @EnumSource(value = BankManagerButtons.class, mode = EnumSource.Mode.EXCLUDE)
    public void arraysUnderBankManagerButtonsTest(BankManagerButtons bankManagerButtons) {
        mainPage.clickOnBankManagerLogin();
        bankManagerPage.clickOnBankManagerButton(bankManagerButtons);
        bankManagerPage.arrayUnderButtonIsVisible(bankManagerButtons);
    }

    static Stream<Arguments> customer() {
        return Stream.of(
                Arguments.of(FIRST_NAME, LAST_NAME, POST_CODE, "Customer added successfully")
        );
    }

    @ParameterizedTest
    @MethodSource("customer")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alertMessage) {
        mainPage.clickOnBankManagerLogin();
        bankManagerPage.clickOnBankManagerButton(BankManagerButtons.ADD_CUSTOMER);
        bankManagerPage.fillFirstNameField(firstName);
        bankManagerPage.fillLastNameField(lastName);
        bankManagerPage.fillPostCodeField(postCode);
        bankManagerPage.submitCustomer();
        bankManagerPage.alertIs(alertMessage);
    }
}