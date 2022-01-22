package com.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class StellarBurgersUserProfilePage {

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement stellarBurgersLogo;

    @FindBy(how = How.XPATH,using = "//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH,using = "//button[text()='Выход']")
    private SelenideElement exitButton;

    @Step("Проверка что пользователь находится в профиле")
    public void checkUserIsInPersonalCabinet(){exitButton.shouldBe(visible, enabled);}

    @Step("Клик по кнопке Конструктор")
    public void clickConstructorButton(){constructorButton.click();}

    @Step("Клик по Логотипу")
    public void clickMainLogo(){stellarBurgersLogo.click();}

    @Step("Нажатие кнопки Выход")
    public void clickExitButton(){exitButton.click();}
}
