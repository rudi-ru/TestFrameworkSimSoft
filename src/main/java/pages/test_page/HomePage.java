package pages.test_page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;


public class HomePage extends BasePage { //наследуемся от класса BasePage
    public HomePage(WebDriver driver) {
        super(driver);
    }
// частино использую поля для определения xpath, selector-ов, а частино указываю их напрямую в методах
    private final By firstName = By.xpath("//*[@id=\"firstName\"]");

    private final By lastName = By.xpath("//*[@id=\"lastName\"]");

    private final By userEmail = By.cssSelector("#userEmail");

    private final By gender = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]");

    private final By userNumber = By.xpath("//*[@id=\"userNumber\"]");

    private final By subject = By.xpath("//*[@id=\"subjectsInput\"]");

    private final By currentAddress = By.xpath("//*[@id=\"currentAddress\"]");

    private final By state = By.xpath("//*[@id=\"state\"]");

    private final By city = By.xpath("//*[@id=\"city\"]");

    private final By submitBtn = By.xpath("//*[@id=\"submit\"]");


    public HomePage enterForm() throws InterruptedException { //в этом методе проверяем как заполняются
        // поля на сайте

        // Вводим имя
        driver.findElement(firstName).sendKeys("Dart");

        // Вводим фамилию
        driver.findElement(lastName).sendKeys("Vaider");

        // Вводим адрес электронной почты
        driver.findElement(userEmail).sendKeys("dark@force.com");

        // Выбираем пол
        driver.findElement(gender).click();

        // Заполняем поле номер телефона
        driver.findElement(userNumber).sendKeys("0123456789");

        // выбираем дату рождения
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dateOfBirthInput")));
        date.click();
        driver.findElement(By.className("react-datepicker__year-select")).sendKeys("2000");
        Thread.sleep(2000);
        driver.findElement(By.className("react-datepicker__month-select")).sendKeys("November");
        Thread.sleep(2000);
        driver.findElement(By.className("react-datepicker__day--020")).click();

        // Выбираем элементы поля Subject
        driver.findElement(subject).sendKeys("co");
        Thread.sleep(2000);
        driver.findElement(subject).sendKeys(Keys.TAB);
        driver.findElement(subject).sendKeys("math");
        Thread.sleep(2000);
        driver.findElement(subject).sendKeys(Keys.TAB);

        // Выбираем чекбоксы Hobbies
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-1")));
        executor.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-2")));
        executor.executeScript("arguments[0].click();",driver.findElement(By.id("hobbies-checkbox-3")));

        // Загружаем файл на сайт
        By fileInput = By.cssSelector("#uploadPicture");
        String filePath = "C:\\GitHub\\TestFrameworkSimSoft\\src\\main\\resources\\2.jpg";
        driver.findElement(fileInput).sendKeys(filePath);

        // Заполняем поле Current address
        driver.findElement(currentAddress).sendKeys("Earth, 1111, !_+");

        // Выбираем элемент из State
        driver.findElement(state).click();
        waitElementIsVisible(driver.findElement(By.className("css-26l3qy-menu")));
        driver.findElement(By.xpath("//*[@id=\"react-select-3-option-1\"]")).click(); //className("css-11unzgr"));

        // выбираем элемент из City
        driver.findElement(city).click();
        waitElementIsVisible(driver.findElement(By.className("css-26l3qy-menu")));
        driver.findElement((By.xpath("//*[@id=\"react-select-4-option-0\"]"))).click();

        return this; // возвращаем текущий результат
    }

    // далее пишем метод для кнопки "Submit"
    public HomePage clickToSubmit() {
        WebElement btnFind = driver.findElement(submitBtn);
        waitElementIsVisible(btnFind).click();
        return this;
    }

    // Метод проверки появления окна результата заполения формы
    public void checkTitle() {
        waitElementIsVisible(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]")));
        String check = driver.findElement(By.id("example-modal-sizes-title-lg")).getText();
        System.out.println(check);
        Assert.assertEquals(check, "Thanks for submitting the form");
    }
    //выше описали (в т.ч. в отдельных переменных) и применяли локаторы для элементов и действия для них
}
