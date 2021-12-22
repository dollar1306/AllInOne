package Locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AdvanceLocators {

    WebDriver driver;

    @BeforeClass
    public void RunBefore(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_locators.html");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){

        WebElement locator1 = driver.findElement(By.id("locator_id"));
        WebElement locator2 = driver.findElement(By.name("locator_name"));
        WebElement locator3 = driver.findElement(By.id("locator_id"));
        WebElement locator4 = driver.findElement(By.tagName("p"));
        WebElement locator5 = driver.findElement(By.linkText("myLocator(5)"));
        WebElement locator6 = driver.findElement(By.partialLinkText("Find my locator (6)"));
        WebElement locator7 = driver.findElement(By.cssSelector("input[myname='selenium']"));
        WebElement locator8 = driver.findElement(By.xpath("//*[@id=\"contact_info_left\"]/button"));


        List<WebElement> locators = new ArrayList<>();
        locators.add(locator1);
        locators.add(locator2);
        locators.add(locator3);
        locators.add(locator4);
        locators.add(locator5);
        locators.add(locator6);
        locators.add(locator7);
        locators.add(locator8);

        for(int i =0;i<locators.size();i++){
            System.out.println(locators.get(i).getText());
        }
    }
}
