package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleHomePage {

    public static WebElement element = null;


    public static WebElement searchBox(WebDriver driver){
        element = driver.findElement(By.id("lst-ib"));
        return element;
    }

    public static void enterTextInSearch(WebDriver driver, String text){
        element = searchBox(driver);
        element.sendKeys(text);

    }

    public static WebElement searchButton(WebDriver driver){
        element = driver.findElement(By.name("btnK"));
        return element;
    }

    public static void clickOnSearchButton(WebDriver driver){
        searchBox(driver).sendKeys(Keys.RETURN);


    }

    public static WebElement logo(WebDriver driver){
        element = driver.findElement(By.id("hplogo"));
        return element;
    }

    public static boolean isLogoDisplayed(WebDriver driver){
        boolean isDisplayed = false;
        if(logo(driver).isDisplayed()){
            isDisplayed = true;
        }
        return isDisplayed;

    }

    public static WebElement signInButton(WebDriver driver){
        element = driver.findElement(By.id("gb_70"));
        return element;
    }


    public static void clickSignInButton(WebDriver driver){
        element = signInButton(driver);
        element.click();
    }

    public static WebElement feelingLuckyButton(WebDriver driver){
        element = driver.findElement(By.id("gbqfbb"));
        return element;
    }

    public static void clickFeelingLuckyButton(WebDriver driver){
        element = feelingLuckyButton(driver);
        element.click();
    }



    }
