package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProductPage {

    private final Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void selectProduct(String productName) {

        Locator product = page.locator("div.product-tuple-listing")
                .filter(new Locator.FilterOptions()
                        .setHasText(productName))
                .first();

        product.waitFor();
        product.scrollIntoViewIfNeeded();
        product.click();
    }
}

