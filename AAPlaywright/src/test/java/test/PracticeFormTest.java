package test;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.Homepage;
import pages.PracticeForm;
import utils.ExcelReader;
import utils.PracticeFormData;

import java.io.IOException;

public class PracticeFormTest extends BaseTest {
    ExcelReader excel = new ExcelReader(
            "src/test/resources/testdata/PracticeForm.xlsx",
            "PracticeForm"
    );

    public PracticeFormTest() throws IOException {
    }

    @Test
    public void validPracticeFormSubmissionTest() throws IOException {


        PracticeFormData data =
                excel.getPracticeFormData(1);

        Homepage pages = new Homepage(page);

        pages.navigate();
        pages.forms();
        pages.practiceForm();

        PracticeForm form = new PracticeForm(page);

        form.firstName(data.getFirstName());
        form.lastName(data.getLastName());
        form.enterEmail(data.getEmail());
        form.enterMobileNumber(data.getMobile());

        form.gender();
        form.dob();
        form.hobbies();

        form.state(data.getState());
        form.city(data.getCity());

        form.currentAddress(data.getAddress());

        form.subjects(
                new String[]{
                        "English",
                        "Maths",
                        "Computer Science"
                }
        );

        form.uploadPicture(
                "src/test/resources/testdata/03d1a304-1893-4f10-858d-fbc8001324b1.jpeg"
        );


        form.clickSubmit();
        excel.close();
    }
    @Test
    public void invalidMobileNumberTest() throws IOException {

        PracticeFormData data =
                excel.getPracticeFormData(3);

        Homepage pages = new Homepage(page);

        pages.navigate();
        pages.forms();
        pages.practiceForm();

        PracticeForm form = new PracticeForm(page);

        form.firstName(data.getFirstName());
        form.lastName(data.getLastName());
        form.enterEmail(data.getEmail());
        form.enterMobileNumber(data.getMobile());

        form.gender();
        form.dob();
        form.hobbies();

        form.state(data.getState());
        form.city(data.getCity());

        form.currentAddress(data.getAddress());

        form.subjects(
                new String[]{
                        "English",
                        "Maths",
                        "Computer Science"
                }
        );

        form.uploadPicture(
                "src/test/resources/testdata/03d1a304-1893-4f10-858d-fbc8001324b1.jpeg"
        );

        form.clickSubmit();
        excel.close();
    }
    @Test
    public void invalidNameTest() throws IOException {

        PracticeFormData data =
                excel.getPracticeFormData(2);

        Homepage pages = new Homepage(page);

        pages.navigate();
        pages.forms();
        pages.practiceForm();

        PracticeForm form = new PracticeForm(page);

        form.firstName(data.getFirstName());
        form.lastName(data.getLastName());
        form.enterEmail(data.getEmail());
        form.enterMobileNumber(data.getMobile());

        form.gender();
        form.dob();
        form.hobbies();

        form.state(data.getState());
        form.city(data.getCity());

        form.currentAddress(data.getAddress());

        form.subjects(
                new String[]{
                        "English",
                        "Maths",
                        "Computer Science"
                }
        );

        form.uploadPicture(
                "src/test/resources/testdata/03d1a304-1893-4f10-858d-fbc8001324b1.jpeg"
        );

        form.clickSubmit();
        excel.close();
    }

}

