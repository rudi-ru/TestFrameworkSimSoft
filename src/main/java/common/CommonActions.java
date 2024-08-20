package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static common.Config.PLATFORM_AND_BROWSER;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class CommonActions {
    public static WebDriver createDriver() { //инициализируем драйвер как null
        WebDriver driver = null;

        switch (PLATFORM_AND_BROWSER) { // в этом свитче можно прописать несколько пар ОС и браузеров для разных систем
            case "win_chrome":          // и менять только переменную PLATFORM_AND_BROWSER в классе Config
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver(); // тут же создаем новый драйвер
                break;
            default:
                Assert.fail("Incorrect platform or browser name: " + PLATFORM_AND_BROWSER);
        }
        driver.manage().window().maximize(); //делаем окно максимально большим
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS); //ждем пока страница прогрузится до конца
    return driver;
    }
}
