package com.stellarBurgers;

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
import static org.junit.Assert.assertTrue;

public class UserPersonalProfileTest {

    UserOperations userHelper;
    MainPage mainPage = open(MainPage.BURGERS_MAIN_PAGE_URL, MainPage.class);
    UserProfilePage profilePage = page(UserProfilePage.class);
    LoginPage loginPage = page(LoginPage.class);

    @Before
    public void setUp(){

        Configuration.startMaximized = true;
        userHelper = new UserOperations();
        Map<String, String> userData = userHelper.register();
        mainPage.clickPersonalCabinetButton();
        loginPage.enterCredentialsAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.clickPersonalCabinetButton();

    }

    @Test
    @DisplayName("Проверка работоспособности перехода в Личный кабинет")
    public void isPersonalCabinetReachable(){
        profilePage.checkUserIsInPersonalCabinet();
    }

    @Test
    @DisplayName("Переход на главную страницу из Личного кабинета по кнопке конструктор")
    public void isMainPageReachableByConstructorButton(){

        profilePage.clickConstructorButton();
        assertTrue(mainPage.isMainPageLoggedAuthorised());
    }

    @Test
    @DisplayName("Переход на главную страницу из Личного кабинета по Логотипу")
    public void isMainPageReachableByLogoClick(){

        profilePage.clickMainLogo();
        assertTrue(mainPage.isMainPageLoggedAuthorised());
    }

    @Test
    @DisplayName("Переход на страницу логина из Личного кабинета по кнопке Выход")
    public void isLoginPageReachableByExitButton(){

        profilePage.clickExitButton();
        assertTrue(loginPage.isOpen());
    }

    @After
    public void terminate(){
        userHelper.delete();
        getWebDriver().quit();
    }
}
