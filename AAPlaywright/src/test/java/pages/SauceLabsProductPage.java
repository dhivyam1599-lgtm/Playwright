package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.WaitForSelectorState;
import utils.TestContext;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceLabsProductPage {
    private static final String PRODUCTS = ".inventory_item_name ";
    private static final String TITLE = ".title";
    private static final String FILTER_DROPDOWN = ".product_sort_container";


    private final Page page;

    public SauceLabsProductPage(Page page) {
        this.page = page;
    }


    public void selectProducts(){
        page.locator(PRODUCTS);
    }

    public String verifyProductsTitle() {
        Locator pageTitle = page.locator(TITLE);
        assertThat(pageTitle).hasText("Products");
        return pageTitle.innerText();
    }
    public void filterDropdown(String optionLabel){
        page.locator(".product_sort_container").selectOption(new com.microsoft.playwright.options.SelectOption().setLabel(optionLabel));
    }
//    public void filterDropdown(String optionLabel){
//        page.getByRole(AriaRole.COMBOBOX,new Page.GetByRoleOptions().setName("Name (A to Z)")).selectOption(new com.microsoft.playwright.options.SelectOption().setLabel(optionLabel));
//    }
    public void orderProducts(){
        page.locator(PRODUCTS);
    }



    public void addToCart(String productName) {
        page.locator(".inventory_item")
                .filter(new Locator.FilterOptions().setHasText(productName))
                .locator("button")
                .click();
    }
    public void selectFirstProduct() {
        Locator firstProduct = page.locator(PRODUCTS).first();

        firstProduct.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );

        firstProduct.click();
    }
    public void selectLastProduct() {
        Locator lastproduct = page.locator(PRODUCTS).last();

        lastproduct.waitFor(
                new Locator.WaitForOptions()
                        .setState(WaitForSelectorState.VISIBLE)
        );

        lastproduct.click();
    }
    public void clickAddToCart(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Add to cart")).click();
    }
    public void backToProducts(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Back to products")).click();
    }
    public void removeProducts(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Remove")).click();
    }
}
