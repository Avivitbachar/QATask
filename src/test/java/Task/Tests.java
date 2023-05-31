package Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;


import static org.testng.Assert.assertEquals;

public class Tests {
    WebDriver driver;
    String ExpectedResult = "Swag Labs";
    String ExpectedError = "Epic sadface: Sorry, this user has been locked out.";
    String BackpackCheck = "Sauce Labs Backpack";
    String checkoutTitle = "Checkout: Overview";
    LoginPage login;
    Products products;
    CheckOut chartFlow;
    @BeforeClass
    public void StartSession(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
        login = PageFactory.initElements(driver ,LoginPage.class);
        products = PageFactory.initElements(driver ,Products.class);
        chartFlow = PageFactory.initElements(driver, CheckOut.class);


    }

    @Test
    public void Test01_login(){

                login.positiveUser("standard_user","secret_sauce");
                if (ExpectedResult.equals(driver.getTitle()))
                    System.out.println("Title is presented like expected ");
                else System.out.println("Test failed , title is:" + driver.getTitle());
                products.Logout();
        try {
            // Pause the execution for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }



    @Test
    public void Test04_addToCartAndCheckout(){
        login.positiveUser("standard_user","secret_sauce");
            if (products.productAddBackPack.getText().equals(BackpackCheck))
            System.out.println("Product Sauce Labs Backpack visible ");
            else System.out.println("Product Sauce Labs Backpack  is not visible ");
            products.AddToTheChartProduct();
            chartFlow.CheckoutFlow("Avivit","Bachar chasid","47000");
        try {
            // Pause the execution for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

    @Test
    public void Test03_RemoveFromTheCart (){
        login.positiveUser("standard_user","secret_sauce");
        assertEquals(products.productBike.getText(),"Sauce Labs Bike Light");
        products.AddAndRemove();
        try {
            // Pause the execution for 5 seconds
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void Test02_Asc_And_desc() {
        login.positiveUser("standard_user","secret_sauce");
        products.asc();
        assertEquals(products.productBackPack.getText(), "Sauce Labs Backpack");
        products.desc();
        assertEquals(products.productTShirt.getText(), "Test.allTheThings() T-Shirt (Red)");
        try {
            // Pause the execution for 5 seconds
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



    @Test
    public void Test05_comparisonScreenshotOfListItems() throws IOException {
        login.positiveUser("standard_user","secret_sauce");
        products.listOfItems();
        // Capture a screenshot of the list item
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,new File("list_item_screenshot.png"));
        // Capture another screenshot of the list item
        File screenshot2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot2, new File("list_item_screenshot2.png"));

// Use AShot for image comparison
        ImageDiff diff = new ImageDiffer().makeDiff(
                ImageIO.read(new File("list_item_screenshot.png")),
                ImageIO.read(new File("list_item_screenshot2.png"))
        );

// Check if there are any visual differences
        if (diff.hasDiff()) {
            // Differences found
            BufferedImage diffImage = diff.getMarkedImage();
            ImageIO.write(diffImage, "PNG", new File("list_item_diff.png"));
        } else {
            // No differences found
        }

        try {
            // Pause the execution for 5 seconds
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }

    @Test
    public void Test06_NegativeLogin(){
        login.NegativeUser("locked_out_user","secret_sauce");
        if (ExpectedError.equals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"))))
            System.out.println("User locked test passed  ");
        else System.out.println("Test failed");
        try {
            // Pause the execution for 5 seconds
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @AfterClass
    public void CloseSession(){
        driver.quit();
    }

}



