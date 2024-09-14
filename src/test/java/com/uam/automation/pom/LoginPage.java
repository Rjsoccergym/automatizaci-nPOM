package com.uam.automation.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public By loginOption = By.linkText("Log in");
    public By nameofuser = By.id("nameofuser");
    public By username = By.id("loginusername");
    public By logout2 = By.id("logout2");
    public By password = By.id("loginpassword");
    public By loginButton = By.xpath("//button[text()='Log in']");
    public By phoneSelected = By.xpath("//a[normalize-space()='Samsung galaxy s6']");
    public By phoneLink = By.xpath("//a[@class='btn btn-success btn-lg']");
    public By cartLink = By.id("cartur");
    public By placeOrderLink = By.xpath("//button[normalize-space()='Place Order']");
    public By nameField = By.id("name");
    public By countryField = By.id("country");
    public By cityField = By.id("city");
    public By creditCardField = By.id("card");
    public By monthField = By.id("month");
    public By yearField = By.id("year");
    public By purchaseLink = By.xpath("//button[text()='Purchase']");
    public By purchaseMessage = By.xpath("//h2[text()='Thank you for your purchase!']");
    public By closeButton = By.xpath("//button[text()='OK']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password)
            throws InterruptedException {
        click(loginOption);
        Thread.sleep(2000);
        type(username, this.username);
        type(password, this.password);
        click(loginButton);
    }
    public String loginSuccessfulText() {
        return getText(nameofuser);
    }
    public String logoutSuccessfulText() {
        return getText(logout2);
    }
    public void selectPhone() {
        click(phoneSelected);
    }

    public void addPhone() {
        click(phoneLink);
    }

    public void checkAdd(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void goToCart() {
        click(cartLink);
    }

    public void goToPlaceOrder() {
        click(placeOrderLink);
    }

    public void fillForm(){
        type("Mateo", this.nameField);
        type("Colombia", this.countryField);
        type("Manizales", this.cityField);
        type("1234 0000 4321", this.creditCardField);
        type("September", this.monthField);
        type("2024", this.yearField);
        click(purchaseLink);
    }

    public String checkPurchaseMessage() {
        return getText(purchaseMessage);
    }

    public void closeWindow(){
        click(closeButton);
    }
}