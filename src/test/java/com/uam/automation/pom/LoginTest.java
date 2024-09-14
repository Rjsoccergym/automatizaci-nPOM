package com.uam.automation.pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest {
    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws Exception{
        loginPage = new LoginPage(driver);

        driver = loginPage.chromeDriverConnection();
        driver.manage().window().maximize();

        loginPage.visit("https://www.demoblaze.com/");

        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void tearDown() throws Exception{
        driver.quit();
    }

//    @Test
//    public void loginUser() throws InterruptedException {
//        loginPage.login("username", "password");
//        Thread.sleep(3000);
//
//        assertEquals(loginPage.loginSuccessfulText(),"Welcome username");
//    }

//    @Test
//    public void logoutUser() throws InterruptedException {
//        loginPage.login("username", "password");
//        Thread.sleep(3000);
//
//        assertEquals(loginPage.logoutSuccessfulText(), "Log out");
//    }

    @Test
    public void buyPhones() throws InterruptedException {
        loginPage.login("username", "password");
        Thread.sleep(5000);
        loginPage.selectPhone();
        Thread.sleep(3000);
        loginPage.addPhone();
        Thread.sleep(2000);
        loginPage.checkAdd(driver);
        loginPage.goToCart();
        Thread.sleep(3000);
        loginPage.goToPlaceOrder();
        Thread.sleep(1000);
        loginPage.fillForm();
        Thread.sleep(3000);
        assertEquals(loginPage.checkPurchaseMessage(),"Thank you for your purchase!");
        loginPage.closeWindow();
    }
}