package com.pageObjects;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserLoginTest {

    StellarBurgersMainPage mainPage = open(StellarBurgersMainPage.BURGERS_MAIN_PAGE_URL, StellarBurgersMainPage.class);
    StellarBurgersLoginPage loginPage = page(StellarBurgersLoginPage.class);
    StellarBurgersRegistrationPage registrationPage = page(StellarBurgersRegistrationPage.class);
    StellarBurgersPasswordRecoveryPage recoveryPage = page(StellarBurgersPasswordRecoveryPage.class);
    UserOperations userHelper;


    @Before
    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Configuration.startMaximized = true;
        userHelper = new UserOperations();
    }

    @Test
    @DisplayName("Тест на вход по кнопке Войти в аккаунт")
    public void userLoginByEnterAccountButton(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickEnterAccountButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.isMakeOrderButtonVisible();

    }

    @Test
    @DisplayName("Тест на вход по кнопке Личный кабинет")
    public void userLoginByPersonalCabinetButton(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.isMakeOrderButtonVisible();

    }

    @Test
    @DisplayName("Тест на вход через кнопку на форме регистрации")
    public void userLoginFromRegistrationForm(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.clickEnterAccountButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.isMakeOrderButtonVisible();

    }

    @Test
    @DisplayName("Тест на вход через кнопку на форме восстановления пароля")
    public void userLoginFromPasswordRecoveryForm(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickEnterAccountButton();
        loginPage.clickRecoveryButton();
        recoveryPage.clickEnterButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.isMakeOrderButtonVisible();
    }

    @After
    public void terminate(){
        userHelper.delete();
        getWebDriver().quit();
    }
}
