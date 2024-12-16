import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class HotelPage {
    private SelenideElement hotelName = $("h2[data-testid='hotel-name']");
    private SelenideElement starRating = $("span[data-testid='property-rating']");
    private SelenideElement reviewScore = $("div[data-testid='review-score']");
    private SelenideElement reviewCount = $("span[data-testid='review-count']");
    private SelenideElement price = $("div[data-testid='price-and-discounted-price']");

    public String getHotelName() {
        return hotelName.getText();
    }

    public String getStarRating() {
        return starRating.getText();
    }

    public String getReviewScore() {
        return reviewScore.getText();
    }

    public String getReviewCount() {
        return reviewCount.getText();
    }

    public String getPrice() {
        return price.getText();
    }
}
