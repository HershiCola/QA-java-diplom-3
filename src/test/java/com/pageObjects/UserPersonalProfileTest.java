package com.pageObjects;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserPersonalProfileTest {

    UserOperations userHelper;
    StellarBurgersMainPage mainPage = open(StellarBurgersMainPage.BURGERS_MAIN_PAGE_URL, StellarBurgersMainPage.class);
    StellarBurgersUserProfilePage profilePage = page(StellarBurgersUserProfilePage.class);
    StellarBurgersLoginPage loginPage = page(StellarBurgersLoginPage.class);

    @Before
    public void setUp(){
        userHelper = new UserOperations();
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Тест на работоспособность перехода в Личный кабинет")
    public void isPersonalCabinetReachable(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.clickPersonalCabinetButton();
        profilePage.checkUserIsInPersonalCabinet();
    }

    @Test
    @DisplayName("Тест на переход из Личного кабинета по кнопке конструктор")
    public void isMainPageReachableByConstructorButton(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.clickPersonalCabinetButton();
        profilePage.clickConstructorButton();
        mainPage.isMakeOrderButtonVisible();
    }

    @Test
    @DisplayName("Тест на переход из Личного кабинета по Логотипу")
    public void isMainPageReachableByLogoClick(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.clickPersonalCabinetButton();
        profilePage.clickMainLogo();
        mainPage.isMakeOrderButtonVisible();
    }

    @Test
    @DisplayName("Тест на выход из Личного кабинета по кнопке Выход")
    public void isExitButtonWorks(){

        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.clickPersonalCabinetButton();
        profilePage.clickExitButton();
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
    }

    @After
    public void terminate(){
        userHelper.delete();
        getWebDriver().quit();
    }
}
