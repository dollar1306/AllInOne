package Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertAndVerification {
    WebDriver driver;

    @BeforeClass
    public void RunBefore() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/bmi/");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        WebElement weight = driver.findElement(By.id("weight"));
        weight.sendKeys("100");
        WebElement hight = driver.findElement(By.id("hight"));
        hight.sendKeys("190");
        driver.findElement(By.id("calculate_data")).click();

        String bmi_means = driver.findElement(By.id("bmi_means")).getAttribute("value");
        System.out.println("That:" + bmi_means);
        Assert.assertEquals(bmi_means, "That you have overweight.");

        System.out.println("The value of bmi: " + driver.findElement(By.id("bmi_result")).getAttribute("value"));


    }

}
