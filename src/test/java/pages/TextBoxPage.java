package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {

    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();


    private final String titleText = "Text Box";
    private SelenideElement
            fullNameInput = $("#userName");


    public TextBoxPage openPage() {
        open("/text-box");
        $(".main-header").shouldHave(text(titleText));


        return this;
    }

    public TextBoxPage closeBan() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }


    public TextBoxPage setFullName(String value) {
        fullNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAddress(String value) {
        $("#permanentAddress").setValue(value);

        return this;

    }

    public TextBoxPage clickButton() {
        registrationResultModal.buttonSubmit();

        return this;
    }

    public TextBoxPage verifyResult(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}


