package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class BasePage { // создаем базовый класс, чтобы от него наследоваться
    protected WebDriver driver; //в классах на тестовых страницах

    public BasePage(WebDriver driver) { //коструктор класса для определения драйвера
        this.driver = driver;
    }
    public void open(String url) { // метод для открытия вебстраницы с определенным урл
        driver.get(url);
    }
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element; // метод получает на входе данные о требуемом элементе, ждет несколько секунд
        // (переменная EXPLICIT_WAIT) пока элемент полностью не загрузится и станет видимым, потом возвращает данный элемент
    }
}
