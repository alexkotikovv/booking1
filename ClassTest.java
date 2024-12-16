import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookingTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true; // Максимизировать окно браузера
        Configuration.browser = "chrome"; // Используйте нужный вам браузер
    }

    @Test
    @Description("Тестирование поиска отелей на Booking.com")
    void testBooking() {
        MainPage mainPage = new MainPage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        HotelPage hotelPage = new HotelPage();

        // Шаги сценария
        mainPage.open();
        mainPage.searchForCity("Paris"); // Введите любой заграничный город

        searchResultsPage.clickShowOnMap();
        searchResultsPage.hoverOverFirstHotel();

        HotelInfo hotelInfo = searchResultsPage.getFirstHotelInfo();
        searchResultsPage.clickOnFirstHotelMarker(); // Логика для нажатия на маркер

        hotelPage.verifyHotelInfo(hotelInfo);
    }
}
