package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignUp {
	public static void main(String[] v) throws InterruptedException {
	Logger logger = Logger.getLogger("");
	logger.setLevel(Level.OFF);
	String driverPath = "./src/main/resourcies/geckodriver";
	System.setProperty("webdriver.gecko.driver", driverPath);
	String url = "https://www.facebook.com/";
	String expected_result = "555";
	Properties properties = new Properties();
	try {
		properties.load(new FileInputStream("./src/main/resourcies/input.properties"));

	} catch (IOException e) {
		e.printStackTrace();
	}

	WebDriver d = new FirefoxDriver();
	// d.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(d, 15);
	d.get(url);
	try {
		WebElement email = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(properties.getProperty("emailField"))));
		email.sendKeys("");

		WebElement password = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(properties.getProperty("passField"))));
		password.sendKeys("");

		WebElement login = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(properties.getProperty("login"))));
		login.click();

		// WebElement copyRight =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("copyRight"))));
		// copyRight.click();

		WebElement timeLine = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("Timeline"))));
		timeLine.click();

		WebElement numberF = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("nfriends"))));
		numberF.getText();

		WebElement settings = wait
				.until(ExpectedConditions.elementToBeClickable(By.id(properties.getProperty("dDown"))));
		settings.click();

		WebElement logOut = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(properties.getProperty("logOut"))));
		logOut.click();
		if (expected_result.equals(numberF)) {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Result:\t" + "PASS");
		} else {
			System.out.println("Test Case ID:\t\tTC-01.01.01");
			System.out.println("Test Case Result:\t" + "FAILED");
		}
	} catch (NoSuchElementException ignored) {
		System.out.println("element not found");
	}
	d.quit();

}
}
