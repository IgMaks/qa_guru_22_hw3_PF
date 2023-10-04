package tests;

import org.junit.jupiter.api.Assertions;
import utils.Utils;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class PracticeFormWithObject extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Utils utils = new Utils();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .closeBan()
                .setFirstName(utils.userName)
                .setLastName(utils.lastName)
                .setEmail(utils.userEmail)
                .setGender(utils.userGender)
                .setPhoneNumber(utils.userNumber)
                .setBirthDate(utils.day, utils.month, utils.year)
                .setSubjects(utils.subject)
                .setHobbies(utils.hobbies)
                .uploadFile(utils.file)
                .setCurrentAddress(utils.currentAddress)
                .setState(utils.state)
                .setCity(utils.city)
                .clickButton()
                .titleText()
                .verifyResult("Student Name", utils.userName + " " + utils.lastName)
                .verifyResult("Student Email", utils.userEmail)
                .verifyResult("Gender", utils.userGender)
                .verifyResult("Mobile", utils.userNumber)
                .verifyResult("Date of Birth", utils.day + " " + utils.month + "," + utils.year)
                .verifyResult("Subjects", utils.subject)
                .verifyResult("Hobbies", utils.hobbies)
                .verifyResult("Picture", utils.file.replaceAll("src/test/resources/", ""))
                .verifyResult("Address", utils.currentAddress)
                .verifyResult("State and City", utils.state + " " + utils.city);
    }
}