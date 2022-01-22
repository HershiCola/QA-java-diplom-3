package com.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;

public class StellarBurgersMainPage {

    public final static String BURGERS_MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH, using = "//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH, using = "//p[text()='Личный Кабинет']")
    private SelenideElement personalCabinetButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Булки']")
    private SelenideElement bunsLabel;

    @FindBy(how = How.XPATH, using = "//span[text()='Соусы']")
    private SelenideElement saucesLabel;

    @FindBy(how = How.XPATH, using = "//span[text()='Начинки']")
    private SelenideElement fillingsLabel;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'current')]/span[text()='Булки']")
    private SelenideElement bunsTab;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'current')]/span[text()='Соусы']")
    private SelenideElement saucesTab;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'current')]/span[text()='Начинки']")
    private SelenideElement fillingsTab;

    @FindBy(how = How.XPATH,using = "//button[text()='Оформить заказ']")
    private SelenideElement makeOrderButton;



    @Step("Метод входа в аккаунт по кнопке Войти в аккаунт")
    public void clickEnterAccountButton() {
        enterAccountButton.click();
    }

    @Step("Метод входа в аккаунт по кнопке Личный кабинет")
    public void clickPersonalCabinetButton() {
        personalCabinetButton.click();
    }


    @Step("Метод проверки работоспособности вкладок Конструктора")
    public void checkConstructorTabsWork() {
        fillingsLabel.click();
        fillingsTab.shouldBe(visible);
        saucesLabel.click();
        saucesTab.shouldBe(visible);
        bunsLabel.click();
        bunsTab.shouldBe(visible);
    }

    @Step("Проверка видимости кнопки Оформить заказ")
    public void isMakeOrderButtonVisible(){
        makeOrderButton.shouldBe(visible, enabled);
    }
}


