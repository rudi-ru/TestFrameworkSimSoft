package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.test_page.HomePage;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest { // создаем тестовый базовый класс
    protected WebDriver driver = CommonActions.createDriver(); // создаем драйвер обращаясь к классу CommonActions
    protected BasePage basePage = new BasePage(driver); // создаем новый объект класса BasePage
    protected HomePage homePage = new HomePage(driver); // создаем новый объект нашей тестируемой страницы
    // это делаем,чтобы наши вышесозданные наследники могли работать с методами указанных классов

    // для тестировки создадим ниже метод очистки "куки" и "локал стораж" перед запуском тестового браузера
    @AfterTest // ставим аннотацию для того, чтобы компилятор понял,что это надо делать после каждого теста
    public void clearCookiesAndLocalStorage(){
        //т.к. не всегда это надо очищать сделаем очистку через условие if
        if(CLEAR_COOKIES_AND_STORAGE) { // параметр CLEAR_COOKIES_AND_STORAGE создадим в Config (см. там)
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;// создаем объект javascriptExecutor, чтобы
            //драйвер мог с ним работать
            driver.manage().deleteAllCookies(); // очищаем все куки
            javascriptExecutor.executeScript("window.sessionStorage.clear()"); //используем JavascriptExecutor
            // для очистки локал стораж. Для этого в метод executeScript передаем window.sessionStorage.clear()
        }
    }
    // после выполнения теста необходимо закрыть браузер
    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        if(HOLD_BROWSER_OPEN) {
            driver.quit();
        }
    }
}
