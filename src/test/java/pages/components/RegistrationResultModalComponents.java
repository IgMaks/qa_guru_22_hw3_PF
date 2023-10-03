package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModalComponents {
    public void buttonSubmit(){
        $("#submit").click();

    }
    public void closeModal(){
        $("#closeLargeModal").click();

    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }

}
