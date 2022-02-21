package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver =  driver;
    }

    @FindBy(xpath = "//*[contains(@aria-label, 'Google Account')]")
    private WebElement userMenu;
    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//div[@data-ogamc]/div[4]//a")
    private WebElement signOutBtn;
    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        String userName = driver.findElement(By.xpath("//div[@data-ogamc]/div[2]/div[2]/div[2]")).getText();
        return userName;
    }
    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void clickUserMenu() {
        userMenu.click();
    }
    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void clickSignOut() {
        signOutBtn.click();
    }
}
