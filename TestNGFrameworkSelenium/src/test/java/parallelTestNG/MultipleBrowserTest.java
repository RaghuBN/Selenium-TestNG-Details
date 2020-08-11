package parallelTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserTest {
	WebDriver driver;
	String baseUrl = "https://www.nopcommerce.com/en";

	@Parameters("browserName")
	@BeforeTest
	public void setUp(String browserName) {
		System.out.println("Browser name is.." + browserName);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Selenium\\Selenium Browsers Jars\\Chrome\\Chrome 84\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\Selenium\\Selenium Browsers Jars\\FireFox\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\Selenium\\Selenium Browsers Jars\\IE\\IE 64\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	@Test
	public void BrowserTest() throws Exception {
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
