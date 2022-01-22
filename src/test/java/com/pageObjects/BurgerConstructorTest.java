package com.pageObjects;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BurgerConstructorTest {

    StellarBurgersMainPage mainPage = open(StellarBurgersMainPage.BURGERS_MAIN_PAGE_URL, StellarBurgersMainPage.class);

    @Test
    @DisplayName("Проверка работы конструктора")
    public void isBurgerConstructorWorks(){

        Configuration.startMaximized = true;
        mainPage.checkConstructorTabsWork();
    }

    @After
    public void terminate(){
        getWebDriver().quit();
    }
}
