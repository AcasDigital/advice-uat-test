package org.uk.acas.advice;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class AdviceTest {

//    private static Capabilities chromeCapabilities;

    private static Capabilities firefoxCapabilities;

//    private static RemoteWebDriver chrome;

    private static RemoteWebDriver firefox;

    @BeforeClass
    public static void startup() throws MalformedURLException {
//        chromeCapabilities = DesiredCapabilities.chrome();
        firefoxCapabilities = DesiredCapabilities.firefox();
//        chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
        firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);
    }

    @AfterClass
    public static void shutdown() {
//        chrome.quit();
        firefox.quit();
    }

    @Test
    public void checkSiteIsUp() {
        String baseUrl = "https://beta.acas.org.uk";
//        chrome.get(baseUrl);
        firefox.get(baseUrl);
        assertThat(firefox.getTitle(), is("Help and advice for employers and employees"));
    }
}
