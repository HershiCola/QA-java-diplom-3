package com.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class StellarBurgersLoginPage {

    @FindBy(how = How.XPATH,using = "//div/input[@type='text']")
    private SelenideElement userEmailField;

    @FindBy(how = How.XPATH,using = "//div/input[@type='password']")
    private SelenideElement userPasswordField;

    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']//form//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH,using = "//a[text()='Зарегистрироваться']")
    private SelenideElement registerAccountButton;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement passwordRecoveryButton;

    @Step("Вход в аккаунт по кнопке Войти")
    public void clickLoginButton(){loginButton.click();}

    @Step("Нажатие кнопки Зарегистрироваться")
    public void clickRegistrationButton(){registerAccountButton.click();}

    @Step("Нажатие кнопки Восстановить пароль")
    public void clickRecoveryButton(){passwordRecoveryButton.click();}

    @Step("Проверка наличия кнопок Войти/Восстановить пароль")
    public void recoveryButtonAndEnterButtonShouldBeVisible() {
        loginButton.shouldBe(visible, enabled);
        passwordRecoveryButton.shouldBe(visible);
    }

    @Step("Ввод данных пользователя и Вход в личный кабинет через кнопку Войти")
    public void enterCredentialsAndClickEnter(String email, String password){
        userEmailField.setValue(email);
        userPasswordField.setValue(password);
        clickLoginButton();
    }

}
