package com.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class StellarBurgersRegistrationPage {

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[1]")
    private SelenideElement userNameField;

    @FindBy(how = How.XPATH,using = "(//div[@class='input__container']//div/input[@type='text'])[2]")
    private SelenideElement userEmailField;

    @FindBy(how = How.XPATH,using = "//div/input[@type='password']")
    private SelenideElement userPasswordField;

    @FindBy(how = How.XPATH,using = "//form//button[text()='Зарегистрироваться']")
    private SelenideElement registerUserButton;

    @FindBy(how = How.XPATH,using = "//p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordErrorLabel;

    @FindBy(how = How.XPATH, using = "//a[text()='Войти']")
    private SelenideElement enterButton;



    @Step("Генерация имени для регистрации")
    public String getUserName () {
        return RandomStringUtils.randomAlphabetic(7);
    }

    @Step("Генерация  почты для регистрации")
    public String getUserEmail () {
        return RandomStringUtils.randomAlphabetic(7) + "@sorokamail.com";
    }

    @Step("Генерация пароля для регистрации")
    public String getUserPassword () {
        return RandomStringUtils.randomAlphabetic(7);

    }

    @Step("Нажимаем на кнопку Войти")
    public void clickEnterAccountButton(){
        enterButton.click();
    }

    @Step("Ввод данных для регистрация и нажатие кнопки Зарегистрироваться")
    public void fillUserCredentialsAndClickRegister(String name, String email, String password){
        userNameField.setValue(name);
        userEmailField.setValue(email);
        userPasswordField.setValue(password);
        registerUserButton.click();
    }

    @Step("Генерация невалидного пароля")
    public String getIncorrectUserPassword () {
        return RandomStringUtils.randomAlphabetic(5);
    }

    @Step("Проверка что пароль не соответствует требованиям")
    public void checkErrorTextPopUp(){
        incorrectPasswordErrorLabel.shouldBe(visible);
    }


}
