package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.TestContext;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceLabsCartPage {

    private final Page page;
    private static final String SHOPPING_CART=".shopping_cart_link";
    private static final String PAGE_TITLE =".title";
    private static final String PRODUCTS = ".inventory_item_name";

    public SauceLabsCartPage(Page page) {
        this.page = page;
    }


    public void cart(){

        page.locator(SHOPPING_CART).click();
    }

    public String pageTitle()
    {
        Locator pageTitle= page.locator(PAGE_TITLE);
        assertThat(pageTitle).hasText("Your Cart");
        return pageTitle.innerText();
    }
    public int countItems() {
            return page.locator(PRODUCTS).count();

    }
    public void removeItems(String productname){
        page.locator(".cart_item").filter(new Locator.FilterOptions().setHasText(productname)).locator("button").click();
    }
    public void checkout(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Checkout")).click();
    }
    public void continueShopping(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Continue Shopping")).click();
    }


}
