package pages;

import com.codeborne.selenide.SelenideElement;
import pages.companents.Calendar;
import pages.companents.RegistrationResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private Calendar calendar = new Calendar();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private final String titleText = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            setDateOfBirthDate = $("#dateOfBirthInput");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        setDateOfBirthDate.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationPage verifyResultModalAppeals() {
        registrationResultModal.verifyModalAppeals();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }
    public RegistrationPage clickButton(){
        registrationResultModal.buttonSubmit();
        return this;

    }

    public RegistrationPage setHobbies() {
        $("label[for='hobbies-checkbox-2']").click();

        return this;
    }

    public RegistrationPage uploadFile(String value) {
        $("#uploadPicture").uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setState(String value) {
        $("#state").click();
        $("#react-select-3-input").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        $("#city").click();
        $("#react-select-4-input").setValue(value).pressEnter();
        return this;
    }

}
