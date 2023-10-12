package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProductPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddProductTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private AddProductPage addProductPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        loginPage = new LoginPage();
        addProductPage = new AddProductPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test
    public void addProductTest(){
        loginPage.login("thoyerjoy@gmail.com","123456");
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        addProductPage.setAddproductButton();
        DriverSingleton.delay(5);
        Assert.assertEquals(addProductPage.getitemsInCart(),"1");
        System.out.println("Add item Test Case is successful");
    }
}
