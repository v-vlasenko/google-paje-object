package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver =  driver;
    }
    /**
     * определение локатора кнопки логина на начальном экране
     */
    @FindBy(xpath = "//div[@id='gb']/div/div[2]/a")
    private WebElement signInButton;

    /**
     * определение локатора поля логина
     */
    @FindBy(css = "#identifierId")
    private WebElement loginField;

    /**
     * определение локатора кнопки "Далі"
     */
    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement emailNextButton;

    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement passwordNextButton;

    /**
     * определение локатора поля пароля
     */
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    /**
     * метод для ввода логина
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    /**
     * метод для ввода пароля
     */
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
    /**
     * метод клика кнопки "Далі"
     */
    public void clickEmailNextButton() {
        emailNextButton.click();
    }

    public void clickPasswordNextButton() {
        passwordNextButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

}

