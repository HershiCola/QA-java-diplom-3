package com.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StellarBurgersPasswordRecoveryPage {

    @FindBy(how = How.XPATH,using = "//a[text()='Войти']")
    private SelenideElement enterButton;

    @Step("Переход по кнопке Войти")
    public void clickEnterButton(){enterButton.click();}
}
