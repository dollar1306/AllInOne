package Assertion;
import static org.testng.Assert.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;


public class AssertsVerifications {
    private WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/bmi");
    }

    @Test
    public void test01_BMItest() {
        driver.findElement(By.id("weight")).sendKeys("147");
        driver.findElement(By.name("height")).sendKeys("216");
        driver.findElement(By.id("calculate_data")).click();
        String ExpectedResult = "32";
        String ActualResult = driver.findElement(By.id("bmi_result")).getAttribute("value");
        assertEquals(ActualResult,ExpectedResult);
    }

    @Test
    public void test02_ButtonCalc() {
        int width = driver.findElement(By.id("calculate_data")).getSize().getWidth();
        int height = driver.findElement(By.id("calculate_data")).getSize().getHeight();
        int XCoordinate = driver.findElement(By.id("calculate_data")).getLocation().x;
        int YCoordinate = driver.findElement(By.id("calculate_data")).getLocation().y;

        System.out.println("Button Width: " + width);
        System.out.println("Button Hieght: " + height);
        System.out.println("Button X Coordinate: " + XCoordinate);
        System.out.println("Button Y Coordinate: " + YCoordinate);

        assertEquals(width,133);
        assertEquals(height,35);
        assertEquals(XCoordinate,716);
        assertEquals(YCoordinate,265);

        assertTrue(driver.findElement(By.id("calculate_data")).isDisplayed());
        assertTrue(driver.findElement(By.id("calculate_data")).isEnabled());
        assertFalse(driver.findElement(By.id("calculate_data")).isSelected());

        assertEquals(driver.findElement(By.id("calculate_data")).getTagName(),"input");
        assertEquals(driver.findElement(By.id("calculate_data")).getAttribute("value"),"Calculate BMI");

        assertFalse(driver.findElement(By.id("new_input")).isDisplayed(),"Checking Element (new_input) is Displayed");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
