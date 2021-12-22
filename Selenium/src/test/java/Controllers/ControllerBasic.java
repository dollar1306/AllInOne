package Controllers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ControllerBasic {
    WebDriver driver;
    @BeforeClass
    public void RunBefore(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
        driver.manage().window().maximize();
    }
    @Test
    public void test01(){

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Alex");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Kuzmin");

        Select Continent = new Select(driver.findElement(By.id("continents")));
        Continent.selectByValue("asia");

        driver.findElement(By.id("submit")).click();

        String curUrl = driver.getCurrentUrl();

        if(curUrl.contains("Alex") && curUrl.contains("Kuzmin")){
            System.out.println("Test Passed");
        }
        else{
            System.out.println("Test Fail");
        }

    }

    @Test
    public void test2(){
        driver.navigate().refresh();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Alex");
        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Kuzmin");

        Select Continent = new Select(driver.findElement(By.id("continents")));
        Continent.selectByValue("asia");

        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-0")).click();
        WebElement birthDay = driver.findElement(By.name("datepicker"));
        birthDay.sendKeys("13/06/1985");

        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-1")).click();
        driver.findElement(By.id("submit")).click();

        Select mySelection2 = new Select(driver.findElement(By.id("selenium_commands")));
        mySelection2.selectByIndex(2);

        //Issuing a date from string
        //הוצאת תאריך לידה מתוך string
        String[] arr = driver.getCurrentUrl().split("%");
        String day = arr[0].substring(arr[0].length() - 2);
        String month = arr[1].substring(arr[1].length() - 2);
        String year = arr[2].substring(2,6);
        System.out.println(year + "-" + month + "-" + day);
    }

    @AfterClass
    public void closeSession(){
        //driver.quit();
    }
}
