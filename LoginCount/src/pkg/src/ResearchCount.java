package pkg.src;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResearchCount extends CommonProperties {

	public static WebDriver driver;
	static String URL = "https://www.realtor.com";
	private static String IEBROWSER = null;
	private static String IEBROWSER64 = null;
	private static String CBROWSER = null;
	private static String FFBROWSER = null;

	protected static TestProperties _properties = new TestProperties();

	@BeforeClass
	public static void setUp() {

		try {
			String browser = _properties.getProperty(TestProperties.BROWSERTYPE);
			IEBROWSER = _properties.getProperty(TestProperties.IEBOWSERDRIVER);
			CBROWSER = _properties.getProperty(TestProperties.CHROMEDRIVER);
			FFBROWSER = _properties.getProperty(TestProperties.FFBOWSERDRIVER);
			IEBROWSER64 = _properties.getProperty(TestProperties.IEBOWSERDRIVER64);

			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", CBROWSER);

				driver = new ChromeDriver();
			}

			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", FFBROWSER);

				driver = new FirefoxDriver();
			}

			if (browser.equalsIgnoreCase("IE")) {
				if (System.getProperty("sun.arch.data.model").equals("64")) {
					System.setProperty("webdriver.ie.driver", IEBROWSER64);
				} else {
					System.setProperty("webdriver.ie.driver", IEBROWSER);
				}
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void searchTest() throws Exception {

		try {
			PageLocators PL = PageFactory.initElements(driver, PageLocators.class);

			driver.get(URL);
			Thread.sleep(2000);
			type(PL.searchText, "Morgantown, WV");
			click(PL.clickBtn);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String resultCount = getText(PL.textElement);
			String[] SplittedString = resultCount.split(" ");
			int result = Integer.parseInt(SplittedString[0]);
			Assert.assertTrue(result > 0);
			System.out.println("Count is greater than  0. Count is: " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
