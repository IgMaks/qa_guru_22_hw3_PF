package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;

public class TextBoxTest {
    TextBoxPage textBoxPage = new TextBoxPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
    }
    @Test
    void SuccessTestTextBox(){
        String fullName = "Ivan Ivanov",
               userEmail = "Ivanovich@ya.ru",
               currentAddress = "Мордовия",
               permanentAddress = "Саранск";

        textBoxPage.openPage()
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
