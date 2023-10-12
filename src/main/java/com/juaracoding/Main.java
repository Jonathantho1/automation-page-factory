package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    private static WebDriver driver;

    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);

        LoginPage loginPage = new LoginPage();
        loginPage.login("thoyerjoy@gmail.com","123456");

        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        AddProductPage addProductPage = new AddProductPage();
        addProductPage.setAddproductButton();

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}