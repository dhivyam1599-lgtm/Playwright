package pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class SnapHomePage {

    private final Page page;

    private static final String SEARCH_BOX = "#search-box-input";

    public SnapHomePage(Page page) {
        this.page = page;
    }

    public void navigateToSnapdeal() {

        page.navigate("https://www.snapdeal.com");

        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    public void searchProduct(String product) {

        page.locator(SEARCH_BOX).click();
        page.locator(SEARCH_BOX).fill(product);
        page.keyboard().press("Enter");
    }
}

