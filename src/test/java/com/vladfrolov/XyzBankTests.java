package com.vladfrolov;

import com.vladfrolov.actions.Actions;
import com.vladfrolov.asserts.Asserts;
import com.vladfrolov.page.AccountHistoryButtons;
import com.vladfrolov.page.BankManagerButtons;
import com.vladfrolov.page.SelectUserPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import static com.vladfrolov.TestData.*;
import java.util.stream.Stream;
import static com.codeborne.selenide.Selenide.open;

public class XyzBankTests {

    Asserts assertion = new Asserts();
    Actions action = new Actions();

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
        action.mainPage.clickOnCustomerLogin();
        action.selectUserPage.login(login);
        assertion.accountPage.loginInTitleIs(login);
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
        action.mainPage.clickOnCustomerLogin();
        action.selectUserPage.login(login);
        assertion.accountPage.accountNumberIs(accountNumber);
    }

    @ParameterizedTest
    @EnumSource(value = AccountHistoryButtons.class, names = {"TRANSACTIONS"}, mode = EnumSource.Mode.EXCLUDE)
    public void arraysUnderAccountButtonsTest(AccountHistoryButtons accountHistoryButton) {
        action.mainPage.clickOnCustomerLogin();
        action.selectUserPage.login("Hermoine Granger");
        action.accountPage.clickOnAccountButton(accountHistoryButton);
        assertion.accountPage.arrayUnderButtonIsVisible(accountHistoryButton);
    }

    @ParameterizedTest
    @EnumSource(value = BankManagerButtons.class, mode = EnumSource.Mode.EXCLUDE)
    public void arraysUnderBankManagerButtonsTest(BankManagerButtons bankManagerButtons) {
        action.mainPage.clickOnBankManagerLogin();
        action.bankManagerPage.clickOnBankManagerButton(bankManagerButtons);
        assertion.bankManagerPage.arrayUnderButtonIsVisible(bankManagerButtons);
    }

    static Stream<Arguments> customer() {
        return Stream.of(
                Arguments.of(FIRST_NAME, LAST_NAME, POST_CODE, "Customer added successfully")
        );
    }

    @ParameterizedTest
    @MethodSource("customer")
    public void addCustomerTest(String firstName, String lastName, String postCode, String alertMessage) {
        action.mainPage.clickOnBankManagerLogin();
        action.bankManagerPage.clickOnBankManagerButton(BankManagerButtons.ADD_CUSTOMER);
        action.bankManagerPage.fillFirstNameField(firstName);
        action.bankManagerPage.fillLastNameField(lastName);
        action.bankManagerPage.fillPostCodeField(postCode);
        action.bankManagerPage.submitCustomer();
        assertion.bankManagerPage.alertIs(alertMessage);
    }
}