package core;


import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A {
	static WebDriver d;
	static WebDriverWait wait;
	static final String url = "http://alex.academy/exercise/signup/v1/index.php";
	static String browser = "chrome";
	public static void main(String[] v) throws InterruptedException {
		Logger logger = Logger.getLogger("");
		logger.setLevel(Level.OFF);
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty( "./src/main/resourcies/chromedriver", "webdriver.chrome.driver");
			System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-start-fullscreen");
		d = new ChromeDriver(option);
		wait = new WebDriverWait(d, 10);}
		else{d = new HtmlUnitDriver();((HtmlUnitDriver) d).setJavascriptEnabled(true);}
		d.get(url);
		wait = new WebDriverWait(d, 10);
		boolean quotesisPresent = d.findElements(By.id("id_quotes")).size() > 0;
		System.out.println("quotes isPresent?" + quotesisPresent);
		Dimension quotesSize = d.findElement(By.id("id_quotes")).getSize();
		System.out.println("quotes Size Width" + quotesSize.getWidth());
		System.out.println("quotes size Height" + quotesSize.getHeight());
		System.out.println("quotes Size:" + quotesSize.toString());
		Point quoteLocation = d.findElement(By.id("id_quotes")).getLocation();
		System.out.println("quotes Location X:" + quoteLocation.getX());
		System.out.println("quotes Location Y:" + quoteLocation.getY());
		System.out.println("quotes Location :" + quoteLocation.toString());

		
	
d.close();
}
}
