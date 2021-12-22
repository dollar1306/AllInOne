package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DemoCommerce {

    WebDriver driver;

    @BeforeClass
    public void RunBefore() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){
        WebElement electric = driver.findElements(By.linkText("Electronics")).get(0);
        electric.click();

        WebElement camera = driver.findElement(By.cssSelector("div.category-grid.sub-category-grid > div > div:nth-child(1) > div > div > a > img"));
        camera.click();

        Select sort = new Select(driver.findElement(By.id("products-orderby")));
        sort.selectByIndex(3);


        assertTrue(driver.findElements(By.className("item-box")).size() == 3);
    }

    @Test
    public void test2()
    {
        String[] expectedItems = {"Nikon D5500 DSLR","Leica T Mirrorless Digital Camera", "Apple iCam" };

        List<WebElement> product = driver.findElements(By.className("product-title"));
        for(int i = 0;i<product.size();i++){
            System.out.println(product.get(i).findElement(By.tagName("a")).getText());
            assertEquals(product.get(i).findElement(By.tagName("a")).getText(),expectedItems[i]);
        }
    }

    @Test
    public void test3(){
        String value;
        List<WebElement> stars = driver.findElements(By.xpath("//div[@class='rating']/div"));
        for (int i = 0;i<stars.size();i++){
            //System.out.println(stars.get(i).getAttribute("style"));
            value = stars.get(i).getAttribute("style").split(": ")[1].split("%")[0];
            System.out.println(value);
            assertTrue("We do not have stars",Integer.parseInt(value) >= 60);
        }
    }

    @AfterClass
    public void closeSession(){
        //driver.quit();
    }
}
