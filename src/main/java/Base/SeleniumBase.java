package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class SeleniumBase {

        public WebDriver driver;
        private String baseUrl = "http://automationpractice.com/index.php";

        @BeforeClass
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\OneDrive\\Documents\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }

//        @AfterClass
//       public void tearDown() {
//
//           driver.quit();
//       }
    }






