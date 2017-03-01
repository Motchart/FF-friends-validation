package core;

import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeatherApp {
	public static void main(String[] v) throws InterruptedException {

	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.OFF);
	String driverPath = "./src/main/resourcies/geckodriver";
	System.setProperty("webdriver.gecko.driver", driverPath);
	String url = "https://www.facebook.com/";
	String expected_result = "555";
	WebDriver d = new FirefoxDriver();
	// d.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(d, 15);
	d.get(url);
	if (expected_result.equals(actual_resolt)) {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "PASS");
	} else {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "FAILED");
	}
	{
	WebElement firstN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_fname")));
	firstN.sendKeys("");

	WebElement lastN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_lname")));
	lastN.sendKeys("");
	
	WebElement email = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_email")));
	email.sendKeys("");
	
	WebElement phoneN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_phone")));
	phoneN.sendKeys("");
	
	WebElement genderB = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_g_radio_01")));
	lastN.click();
	

	Select dropdown = new Select(d.findElement(By.xpath("id_state")));
	dropdown.selectByIndex(9);
	
	WebElement terms = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_checkbox")));
	terms.click();
	
	WebElement submitB = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_submit-button")));
	submitB.click();
	
	if (expected_result.equals(numberF)) {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "PASS");
	} else {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "FAILED");
	}
	}
	{
	WebElement firstN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_fname")));
	firstN.sendKeys("");

	WebElement lastN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_lname")));
	lastN.sendKeys("");
	
	WebElement email = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_email")));
	email.sendKeys("");
	
	WebElement phoneN = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_phone")));
	phoneN.sendKeys("");
	
	WebElement genderB = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_g_radio_01")));
	lastN.click();
	

	Select dropdown = new Select(d.findElement(By.xpath("id_state")));
	dropdown.selectByIndex(9);
	
	WebElement terms = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_checkbox")));
	terms.click();
	
	WebElement submitB = wait
			.until(ExpectedConditions.elementToBeClickable(By.id("id_submit-button")));
	submitB.click();
	String actual_resolt = d.getTitle();
	if (expected_result.equals(actual_resolt)) {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "PASS");
	} else {
		System.out.println("Test Case ID:\t\tTC-01.01.01");
		System.out.println("Test Case Result:\t" + "FAILED");
	}
	}
d.quit();
	
}
}