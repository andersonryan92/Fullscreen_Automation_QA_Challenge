package NewPackage;



/*
Web page has elements:
Google logo (or whatever custom image above the search bar)
Search entry field
Sign in button
I'm Feeling Lucky button
User can't sign in with invalid credentials (please use non-existing google username)
Search is functional:
Trigger search using fullscreen direct keywords
Verify results page displays more than five results
Verify that first search result has URL: https://www.fullscreendirect.com/
Verify that clicking first search result does redirect to Fullscreen Direct website


 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.classes.GoogleHomePage;
import page.classes.SignInPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestClass {

    public WebDriver driver;
    public String baseURL;

    @Test
    @DisplayName("Are the elements displayed test")
    void testCase1() throws Exception{

        // creating new webdriver object. setting baseURL to google.com
        // maximizing window. Navigates to google.com


        System.setProperty("webdriver.chrome.driver", "/Users/ryananderson/Downloads/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://www.google.com";
        driver.manage().window().maximize();
        driver.get(baseURL);

        // stalls webdriver execution for 2 seconds to wait for page to fully load
        // Side note: could also use WebDriverWait object to wait until a specific element is displayed

        Thread.sleep(2000);

        //Asserts that the specified elements are displayed on the page

        Assertions.assertTrue(GoogleHomePage.logo(driver).isDisplayed());
        Assertions.assertTrue(GoogleHomePage.searchBox(driver).isDisplayed());
        Assertions.assertTrue(GoogleHomePage.signInButton(driver).isDisplayed());
        Assertions.assertTrue(GoogleHomePage.feelingLuckyButton(driver).isDisplayed());

        //closes browser and quits webdriver

        driver.close();
        driver.quit();
    }

    @Test
    @DisplayName("Invalid Credential Sign In")
    void testCase2() throws Exception{

        // creating new webdriver object. setting baseURL to google.com
        // maximizing window. Navigates to google.com


        System.setProperty("webdriver.chrome.driver", "/Users/ryananderson/Downloads/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://www.google.com";
        driver.manage().window().maximize();

        // I use a webdriverWait object here for synchronization

        WebDriverWait wait = new WebDriverWait(driver, 10);


        // goes to google homepage
        driver.get(baseURL);

        //waits for sign in button to be displayed & then clicks it.

        wait.until(ExpectedConditions.elementToBeClickable(GoogleHomePage.signInButton(driver))).isDisplayed();
        GoogleHomePage.clickSignInButton(driver);

        //enters in invalid username & clicks continue
        wait.until(ExpectedConditions.elementToBeClickable(SignInPage.emailField(driver))).isDisplayed();
        SignInPage.enterEmailAddress(driver, "non-existing-username@gmail.com");

        //waits 2 seconds & then asserts that error text is displayed on the page
        Thread.sleep(2000);
        Assertions.assertTrue(SignInPage.invalidUsernameText(driver).isDisplayed());

        //closes browser and quits webdriver

        driver.close();
        driver.quit();

    }


    @Test
    @DisplayName("Search Functionality")
    void testCase3() throws Exception {


        // creating new webdriver object. setting baseURL to google.com
        // maximizing window. Navigates to google.com


        System.setProperty("webdriver.chrome.driver", "/Users/ryananderson/Downloads/chromedriver");
        driver = new ChromeDriver();
        baseURL = "https://www.google.com";
        driver.manage().window().maximize();


        // goes to google homepage
        driver.get(baseURL);

        // enters text in searchbox
        // clicks search button

        GoogleHomePage.enterTextInSearch(driver,"Fullscreen Direct");
        GoogleHomePage.clickOnSearchButton(driver);

        // stalls webdriver execution for 2 seconds to wait for page to fully load

        Thread.sleep(2000);

        // finds all of the individual search results on the page.
        // stores that in a List<> Object called resultEntries

        List<WebElement> resultEntries = driver.findElements(By.cssSelector("div.rc > h3.r > a"));

        int totalResults = 0;

        // for loop to find the total amount of search results on the page

        for (WebElement result : resultEntries) {
            totalResults++;
        }

        //printing out total amount of search results

        System.out.println("The total amount of search results is: " + totalResults);

        // asserting that total amount of search results is greater than 5

        Assertions.assertTrue(totalResults > 5);

        // Verifies that first search result has URL: https://www.fullscreendirect.com/

        Assertions.assertEquals("https://www.fullscreendirect.com/", resultEntries.get(0).getAttribute("href"));

        // clicks on the first search result

        resultEntries.get(0).click();

        // waits 2 seconds for page to load

        Thread.sleep(2000);

        // Verifies that clicking first search result does redirect to Fullscreen Direct website

        Assertions.assertEquals("https://www.fullscreendirect.com/", driver.getCurrentUrl());

        //closes browser and quits webdriver


        driver.close();
        driver.quit();


    }






}
