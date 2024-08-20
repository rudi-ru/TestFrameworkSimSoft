package tests.searchform;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static constants.Constant.Urls.HOME_PAGE;

// сценарий заполения форм на сайте
public class SearchFormToTest extends BaseTest {

    @Test
    public void checkIsRedirectToListing() throws InterruptedException {
        basePage.open(HOME_PAGE); // открываем страницу, используя метов basePage и адрес нашего тестируемого сайта
        // (переменная определена в классе Constants)

        homePage               //из этого класса вызываем два метода:
                .enterForm()  // - заполнение форм
                .clickToSubmit() // - нажать кнопку Submit
                .checkTitle(); // проверяем заголовок окна окончания заполнения формы
    }
}

