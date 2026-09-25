package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceLabCheckOutPage {

    private final Page page;

    public SauceLabCheckOutPage(Page page) {
        this.page = page;
    }

    private static final String PAGE_TITLE = ".title";
    private static final String ERROR_MESSAGE    = "[data-test='error']";

    public String getPageTile() {
        Locator pagetitle = page.locator(PAGE_TITLE);
        assertThat(pagetitle).hasText("Checkout: Your information");
        return pagetitle.innerText();
    }

    public void enterFirstName(String userfirstname) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name")).fill(userfirstname);
    }

    public void enterLastName(String userlastname) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name")).fill(userlastname);
    }

    public void enterPostalCode(String postalcode) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Zip/Postal Code")).fill(postalcode);
    }

    public void clickContinue()
    {
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Continue")).click();
    }
    public void clickCancel()
    {
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Cancel")).click();
    }
    public void clickFinish()
    {
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Finish")).click();
    }
    public String getErrorMessage() {
        if (page.isVisible(ERROR_MESSAGE)) {
            return page.locator(ERROR_MESSAGE).textContent().trim();
        }
        return "";
    }

}
