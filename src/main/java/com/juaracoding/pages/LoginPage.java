package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    //login using Page Factory
    @FindBy(xpath = "//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")
    private WebElement popUp;

    @FindBy(xpath = "//span[normalize-space()='Account']")
    private WebElement accButton;
    @FindBy(xpath = "//button[@id='navbarLoginButton']")
    private WebElement navbarLogin;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='loginButton']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//span[normalize-space()='Your Basket']")
    private WebElement txtBasket;

    //logout using Page Factory

    public void login(String username,String password){
        popUp.click();
        accButton.click();
        navbarLogin.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        buttonLogin.click();
    }

    public String getTxtBasket(){
        return txtBasket.getText();
    }
}
