package pages.companents;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    private final String titleText = "Student Registration Form";
    public void buttonSubmit(){
        $("#submit").click();

    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }

}
