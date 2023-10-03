package Utils;

import com.github.javafaker.Faker;


import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    public static Faker faker = new Faker(new Locale("en"));
    Random random = new Random();



    public String userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = getRandomGender(),
            userNumber = getPhoneNumber(),
            day = String.format("%02d", faker.number().numberBetween(1, 28)),
            month = getMonth(),
            year = String.valueOf(faker.number().numberBetween(1950, 2010)),
            subject = getSubjects(),
            hobbies = getHobby(),
            file = getFileName(),
            currentAddress = faker.address().streetAddress(),
            city = getCityRandom(),
            state = getStateByCity(city);

    public String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getItemFromArray(genders);
    }

    public static String getItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String getPhoneNumber() {
        return ("7" + faker.number().randomNumber(9, true));
    }

    public String getHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return getItemFromArray(hobby);
    }

    public String getSubjects() {
        String[] subjects = {"English", "Physics", "Arts"};
        return getItemFromArray(subjects);
    }

    public String getCityRandom() {
        String[] state = {"Delhi", "Agra", "Karnal", "Gurgaon",
                "Lucknow", "Panipat", "Jaipur", "Jaiselmer"};
        int i = random.nextInt(state.length);
        return state[i];
    }

    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }

    public String getFileName() {
        return "src/test/resources/1.jpg";
    }

    public String getMonth() {
        String[] month = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        int index = random.nextInt(month.length);
        return month[index];
    }

}

