import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class BookingTest {

    private BookingSearchPage bookingSearchPage = new BookingSearchPage();
    private HotelPage hotelPage = new HotelPage();

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
        Configuration.browser = "chrome"; // Убедитесь, что у вас установлен драйвер Chrome
    }

    @Test
    @Description("Тест на поиск отелей на Booking.com")
    public void testBooking() {
        bookingSearchPage.open();
        
        // Вводим город
        bookingSearchPage.searchForCity("Paris");
        
        // Выбираем случайные даты
        bookingSearchPage.selectRandomDates();
        
        // Нажимаем на кнопку "Найти"
        bookingSearchPage.clickSearchButton();

        // Нажимаем на кнопку "Показать на карте"
        bookingSearchPage.clickMapButton();

        // Наводим курсор на первый отель и сохраняем информацию
        String hotelName = hotelPage.getHotelName();
        String starRating = hotelPage.getStarRating();
        String reviewScore = hotelPage.getReviewScore();
        String reviewCount = hotelPage.getReviewCount();
        String price = hotelPage.getPrice();

        // Проверяем информацию на странице отеля
        System.out.println("Название отеля: " + hotelName);
        System.out.println("Количество звезд: " + starRating);
        System.out.println("Средняя оценка: " + reviewScore);
        System.out.println("Количество отзывов: " + reviewCount);
        System.out.println("Стоимость: " + price);

        // Дополнительные проверки могут быть добавлены здесь
    }
}
