package com.splhead.olanome;

import com.splhead.olanome.util.DriverFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainActivityTest {

    private AndroidDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @Test
    public void shouldWelcomeMessageToMale() {
        MobileElement el1 = (MobileElement) driver.findElementById("com.splhead.olanome:id/etPersonName");
        el1.sendKeys("Silas");
        MobileElement bOk = (MobileElement) driver.findElementById("com.splhead.olanome:id/bOk");
        bOk.click();
        MobileElement tvOut = (MobileElement) driver.findElementById("com.splhead.olanome:id/tvOut");
        Assert.assertEquals("Olá, bem vindo Silas", tvOut.getText());
    }

    @Test
    public void shouldWelcomeMessageToFemale() {
        MobileElement etPersonName = (MobileElement) driver.findElementById("com.splhead.olanome:id/etPersonName");
        etPersonName.sendKeys("Thaissa");
        MobileElement spGender = (MobileElement) driver.findElementById("com.splhead.olanome:id/spGender");
        spGender.click();
        MobileElement optionFemale = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
        optionFemale.click();
        MobileElement bOk = (MobileElement) driver.findElementById("com.splhead.olanome:id/bOk");
        bOk.click();
        MobileElement tvOut = (MobileElement) driver.findElementById("com.splhead.olanome:id/tvOut");
        Assert.assertEquals("Olá, bem vinda Thaissa", tvOut.getText());
    }

    @After
    public void tearDown() {
        DriverFactory.destroyDriver();
    }
}

