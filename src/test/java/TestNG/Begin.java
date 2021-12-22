package TestNG;

import org.testng.annotations.*;

public class Begin {

    @BeforeClass//run before all tests
    public void beforeTest(){
        System.out.println("one time Run initializing");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Run before each test method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Will be run after each test method");
    }
    @Test(priority = 2)
    public void test01(){
        System.out.println("This is test 1");
    }
    @Test(priority = 1)
    public void test03(){
        System.out.println("This is test 3");
    }
    @Test(priority = 3)
    public void test02(){
        System.out.println("This is test 2");
    }
    @AfterClass
    public void CloseAll(){
        System.out.println("Close all sessions");
    }
}
