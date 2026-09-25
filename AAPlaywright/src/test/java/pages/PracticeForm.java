package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import java.nio.file.Paths;



public class PracticeForm {
    private final Page page;

    public PracticeForm(Page page) {
        this.page = page;
    }

    public void firstName(String firstname) {
       page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("First Name")).fill(firstname);
    }
    public void lastName(String lastname) {
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Last Name")).fill(lastname);
    }
    public void enterMobileNumber(String mobilenumber){
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Mobile Number")).fill(mobilenumber);
    }
    public void gender() {
        page.getByRole(AriaRole.RADIO,new Page.GetByRoleOptions().setName("Female")).click();
    }
    public void enterEmail(String email){
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("name@example.com")).fill(email);
    }
    public void subjects(String[] subjects) {
        for (String subject : subjects) {
            page.locator("#subjectsInput").fill(subject);
            page.getByText(subject, new Page.GetByTextOptions().setExact(true)).click();
        }
        page.keyboard().press("Enter");
    }
    public void dob() {
        page.locator("#dateOfBirthInput").click();
    }
    public void hobbies() {
        Locator hobbies = page.getByRole(AriaRole.CHECKBOX);
        for (int i = 0; i < hobbies.count(); i++) {
            hobbies.nth(i).check();
        }
    }
    public void state(String state) {

        Locator stateInput = page.locator("#react-select-3-input");

        stateInput.click();
        stateInput.fill(state);

        page.getByText(
                state,
                new Page.GetByTextOptions().setExact(true)
        ).click();
    }
    public void city(String city) {

        Locator cityInput = page.locator("#react-select-4-input");

        cityInput.click();
        cityInput.fill(city);

        page.getByText(
                city,
                new Page.GetByTextOptions().setExact(true)
        ).click();
    }
    public void currentAddress(String currentaddress){
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Current Address")).fill(currentaddress);
    }
    public void uploadPicture(String filepath){
        page.locator("#uploadPicture")
                .setInputFiles(Paths.get(filepath));
    }
    public void clickSubmit() {
        Locator submitButton = page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Submit")
        );


        submitButton.click();
    }

}
