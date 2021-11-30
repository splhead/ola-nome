package com.splhead.olanome;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MainActivityTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "0027461287");
        desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
        desiredCapabilities.setCapability("appium:appPackage", "com.splhead.olanome");
        desiredCapabilities.setCapability("appium:appActivity", "com.splhead.olanome.MainActivity");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 0);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
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
        driver.quit();
    }
}

