package Controllers;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Controllers {
    private WebDriver driver;
    private final String myFirstName = "yoni";
    private final String myLastName = "flenner";

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://atidcollege.co.il/Xamples/ex_controllers.html");
    }
    @Test
    public void test01() {
        driver.findElement(By.name("firstname")).sendKeys(myFirstName);
        driver.findElement(By.name("lastname")).sendKeys(myLastName);
        Select continent = new Select(driver.findElement(By.id("continents")));
        continent.selectByVisibleText("Europe");
        driver.findElement(By.id("submit")).click();
        String sURL = driver.getCurrentUrl();
        if(sURL.contains(myFirstName) && sURL.contains(myLastName))
            System.out.println("Test Passed !");
        else
            System.out.println("Test Failed !");
    }

    // Bonus Question
    @Test
    public void test02() {
        driver.navigate().refresh();
        driver.findElement(By.name("firstname")).sendKeys(myFirstName);
        driver.findElement(By.name("lastname")).sendKeys(myLastName);
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-3")).click();
        // ------------------- Date picker -----------------
        driver.findElement(By.id("datepicker")).click();
        driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/a[2]/span")).click(); // go to next month
        WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
        List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
        for (WebElement cell: columns) {
            if (cell.getText().equals("13")) {
                cell.click();
                break;
            }
        }
        // ------------------------------------------------------

        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();
        Select mySelection = new Select(driver.findElement(By.id("continents")));
        mySelection.selectByVisibleText("Europe");
        Select mySelection2 = new Select(driver.findElement(By.id("selenium_commands")));
        mySelection2.selectByIndex(2);
        driver.findElement(By.id("photo")).sendKeys("C:/Windows/win.ini"); // upload file
        driver.findElement(By.id("submit")).click();

        String[] arr = driver.getCurrentUrl().split("%");
        String day = arr[0].substring(arr[0].length() - 2);
        String month = arr[1].substring(arr[1].length() - 2);
        String year = arr[2].substring(2,6);
        System.out.println(year + "-" + month + "-" + day);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
