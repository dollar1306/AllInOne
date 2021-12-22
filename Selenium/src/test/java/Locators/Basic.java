package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Basic {
    WebDriver driver;
    @BeforeClass
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
    }

    @Test
    public void test01(){


        System.out.println(driver.findElement(By.className("navbar-brand")));
        System.out.println(driver.findElement(By.className("navbar-logo")));
        System.out.println(driver.findElement(By.id("selenium_logo")));
        System.out.println(driver.findElement(By.tagName("svg")));
        System.out.println(driver.findElements(By.tagName("svg")).get(0));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of links " +links.size());

        List<WebElement> SeleniumLinks = driver.findElements(By.partialLinkText("Selenium"));
        System.out.println("Number of links in page with word: Selenium is: " + SeleniumLinks.size());

        List<WebElement> seleniumLinks = driver.findElements(By.partialLinkText("selenium"));
        System.out.println("Number of links in page with word: selenium is: " + seleniumLinks.size());

    }

    @AfterClass
    public void closeSession(){
        driver.quit();
    }
}
