package com.pageObjects;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



public class UserRegistrationTest {


        StellarBurgersMainPage mainPage = open(StellarBurgersMainPage.BURGERS_MAIN_PAGE_URL, StellarBurgersMainPage.class);
        StellarBurgersLoginPage loginPage = page(StellarBurgersLoginPage.class);
        StellarBurgersRegistrationPage registrationPage = page(StellarBurgersRegistrationPage.class);

    @Before
    public void setUp(){
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Тест на валидную регистрацию пользователя")
    public void userRegistrationIsPossible() {

        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationButton();
        String userEmail = registrationPage.getUserEmail();
        String userPassword = registrationPage.getUserPassword();
        registrationPage.fillUserCredentialsAndClickRegister(
                registrationPage.getUserName(),
                userEmail,
                userPassword);
        sleep(1000);
        //вынужденный слип, без него тест проскакивает, поле Email не становятся активными
        //ни при каких ожиданиях и проверках типа visible/enabled и тд
        loginPage.enterCredentialsAndClickEnter(userEmail, userPassword);
        mainPage.isMakeOrderButtonVisible();
    }

    @Test
    @DisplayName("Тест на регистрацию пользователя с паролем короче 6 символов")
    public void userRegistrationWithIncorrectPassword(){

        mainPage.clickEnterAccountButton();
        loginPage.clickRegistrationButton();
        registrationPage.fillUserCredentialsAndClickRegister(
                registrationPage.getUserName(),
                registrationPage.getUserEmail(),
                registrationPage.getIncorrectUserPassword());
        registrationPage.checkErrorTextPopUp();
    }

    @After
    public void terminate(){
        getWebDriver().quit();
    }
}


