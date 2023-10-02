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


    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            setDateOfBirthDate = $("#dateOfBirthInput"),
            genterWrapperInput = $("#genterWrapper"),
            userPhone = $("#userNumber"),
            subjects = $("#subjectsInput"),
            currentAddress = $("#currentAddress"),
            userHobbies = $("label[for='hobbies-checkbox-2']"),
            pictureLoad = $("#uploadPicture"),
            state = $("#state"),
            stateInput = $("#react-select-3-input"),
            city = $("#city"),
            cityInput = $("#react-select-4-input"),
            titleText = $("#example-modal-sizes-title-lg");


    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage closeBan() {
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
        genterWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhone.setValue(value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        setDateOfBirthDate.click();
        calendar.setDate(day, month, year);

        return this;
    }


    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage clickButton() {
        registrationResultModal.buttonSubmit();
        return this;

    }

    public RegistrationPage titleText(String value) {
        titleText.shouldHave(text(value));
        return this;
    }

    public RegistrationPage setHobbies() {
        userHobbies.click();

        return this;
    }

    public RegistrationPage uploadFile(String value) {
        pictureLoad.uploadFile(new File(value));
        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        cityInput.setValue(value).pressEnter();
        return this;
    }
}
