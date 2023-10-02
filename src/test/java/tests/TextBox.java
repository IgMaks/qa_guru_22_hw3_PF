package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TextBox extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void SuccessTextBox() {
        String fullName = "Ivan Ivanov",
                userEmail = "Ivanovich@ya.ru",
                currentAddress = "Мордовия",
                permanentAddress = "Саранск";

        textBoxPage.openPage()
                .closeBan()
                .setFullName(fullName)
                .setPermanentAddress(permanentAddress);
        registrationPage.setEmail(userEmail)
                .setCurrentAddress(permanentAddress)
                .setCurrentAddress(currentAddress)
                .clickButton();

        textBoxPage.verifyResult("Name:", fullName)
                .verifyResult("Email:", userEmail)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }


}
