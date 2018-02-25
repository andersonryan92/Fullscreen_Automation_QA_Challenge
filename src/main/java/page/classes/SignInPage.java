package page.classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {


    public static WebElement element = null;


    public static WebElement emailField(WebDriver driver){
        element = driver.findElement(By.id("identifierId"));
        return element;
    }

    public static void enterEmailAddress(WebDriver driver, String text){
        element = emailField(driver);
        element.sendKeys(text);
        element.sendKeys(Keys.RETURN);
    }

    public static WebElement invalidUsernameText(WebDriver driver){

        element = driver.findElement(By.xpath("//div[@jsname=\"B34EJ\"]"));
        return element;
    }






}
