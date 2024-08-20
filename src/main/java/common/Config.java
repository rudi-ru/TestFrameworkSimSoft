package common;
// Здесь мы прописываем конфиг в котором определяем платформу и браузер
// сохраняем в стринговую переменную PLATFORM_AND_BROWSER, которую
// используем в классе CommonActions
public class Config {
    public static final String PLATFORM_AND_BROWSER = "win_chrome"; // изменяя данную переменную
    // мы можем в классе CommonActions выбирать в switch-е разные ОС и браузеры
    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true; //создаем параметр для проверки и очистки куки
    // в файле BaseTest. при каждом прогоне тестов если куки не пустые - стереть (нужно для чистоты тестов)
    public static final Boolean HOLD_BROWSER_OPEN = true; // //создаем параметр для проверки открыт браузер или нет
    // в файле BaseTest. при каждом прогоне тестов если браузер не закрылся (true) - закрыть
}
