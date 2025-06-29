package com.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonBot {
    public static void main(String[] args) throws InterruptedException {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\satye\\Dropbox\\PC\\Downloads\\chromedriver_win32.zip");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //Go to Amazon
        driver.get("https://www.amazon.in");

        // Sign-In
        driver.findElement(By.id("nav-link-accountList")).click();

        // Login
        driver.findElement(By.id("ap_email")).sendKeys("satyen.d2021btcseai@srisriuniversity.edu.in");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Test@4321");
        driver.findElement(By.id("signInSubmit")).click();

        //  Search for product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
        driver.findElement(By.id("nav-search-submit-button")).click();

        //Click first product
        Thread.sleep(2000);
        driver.findElements(By.cssSelector(".s-title-instructions-style")).get(0).click();

        // Switch to new tab
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }

        // Add to Cart
        try {
            WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
            addToCart.click();
        } catch (Exception e) {
            System.out.println("Add to Cart not available.");
        }

        //Close browser
        driver.quit();
    }
}
