package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormWithObject {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy="eager";
    }
    @Test
    void successfulRegistrationTest() {
        String userName = "Ivan ",
               userLastName = "Ivanov",
               userEmail = "Ivanovich@ya.ru",
               userPhone = "9712345674",
               currentAddress = "Пронск",
               subjects = "Physics",
               file = "1.jpg",
               state = "NCR",
               city = "Delhi",
               gender = "Other",
               day  = "23",
               month = "May",
               year = "1985",
               hobbies = "Reading";

        registrationPage.openPage()
                .setFirstName(userName)
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setPhoneNumber(userPhone)
                .setBirthDate(day, month,year)
                .setSubjects(subjects)
                .setHobbies()
                .uploadFile("src/test/resources/" + file)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickButton();

        registrationPage.verifyResultModalAppeals()
                .verifyResult("Student Name", userName + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", day + " "+ month+","+ year )
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", file)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}