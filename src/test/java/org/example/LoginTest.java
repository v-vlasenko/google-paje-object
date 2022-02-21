package org.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

public class LoginTest {
        @BeforeClass
        public static void setup () {

            //определение пути до драйвера и его настройка
            System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
            //создание экземпляра драйвера
            driver = new ChromeDriver();
            //окно разворачивается на полный экран
            driver.manage().window().maximize();
            //задержка на выполнение теста = 10 сек.
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //получение ссылки на страницу входа из файла настроек
            driver.get(ConfProperties.getProperty("loginpage"));
            loginPage = new LoginPage(driver);
            protectAccountPage = new ProtectAccountPage(driver);
            profilePage = new ProfilePage(driver);
        }
    public static LoginPage loginPage;
    public static ProtectAccountPage protectAccountPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @Test
    public void loginTest() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        loginPage.clickSignInButton();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickEmailNextButton();
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickPasswordNextButton();

        profilePage.clickUserMenu();

        driver.switchTo().frame(0);

        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("login"), user);

        profilePage.clickSignOut();
    }
}
