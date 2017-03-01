package core;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.annotations.*;

public class ElementsValidationTest implements ITest {
	static WebDriver d;
	static final String baseUrl = "http://alex.academy/exercises/signup/v1/";
	String csvFile = "./src/resources/test_data/csv/bat/elements_validation.csv";
	private String test_name = "";

	public String getTestName() {
		return test_name;
	}

	private void setTestName(String a) {
		test_name = a;
	}

	@BeforeMethod(alwaysRun = true)
	public void bm(Method method, Object[] parameters) {
		setTestName(method.getName());
		Override a = method.getAnnotation(Override.class);
		String testCaseId = (String) parameters[a.id()];
		setTestName(testCaseId);
	}

	@DataProvider(name = "dp")
	public Iterator<String[]> a2d() throws IOException {
		String csvLine = "";
		String[] a = null;
		ArrayList<String[]> al = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(csvFile));
		while ((csvLine = br.readLine()) != null) {
			a = csvLine.split(";");
			al.add(a);
		}
		br.close();
		return al.iterator();
	}
@Override
	@Test(dataProvider = "dp")
	public void test(String tc_id, String url, String element_id, String element_size, String element_location) {
		getDriver("chrome", url);
		assertThat(isPresent(element_id, d), equalTo(true));
		assertThat(size(element_id, d), equalTo(element_size));
		assertThat(location(element_id, d), equalTo(element_location));

	}

	@AfterMethod
	public void afterMethod() {
		d.close();

	}
	public static void getDriver(String browser, String url){
		if(browser.equalsIgnoreCase("chrome")){
			Logger logger = Logger.getLogger("");
			logger.setLevel(Level.OFF);
			System.setProperty( "webdriver.chrome.driver", "./src/main/resourcies/chromedriver");
			System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("-start-fullscreen");
		d = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(d, 10);}
		else{
			d = new HtmlUnitDriver();
			((HtmlUnitDriver) d).setJavascriptEnabled(true);
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		d.get(baseUrl + url);
	}

	public static boolean isPresent(String element_id, WebDriver wd) {
		d = wd;
		if (d.findElements(By.id(element_id)).size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	public static String size(String element_id, WebDriver wd) {
		d = wd;
		String n = null;
		if (!d.findElements(By.id(element_id)).isEmpty()) {
			String s = d.findElement(By.id(element_id)).getSize().toString();
			return s;
		} else {
			return n;
		}
	}

	public static String location(String element_id, WebDriver wd) {
		d = wd;
		String n = null;
		if (!d.findElements(By.id(element_id)).isEmpty()) {
			String l = d.findElement(By.id(element_id)).getLocation().toString();
			return l;
		} else {
			return n;
		}

	}
}
