package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;

public class PracticeFormWithPageObjectsTest extends TestBase {
    RegistrationFormPage registrationForm = new RegistrationFormPage();

    String firstName = "Ivan",
            lastName = "Ivanov",
            email = "qwe123@gmail.com",
            gender = "Male",
            mobile = "1234567890",
            monthOfBirth = "January",
            yearOfBirth = "2000",
            dayOfBirth = "10",
            subject1 = "Maths",
            subject2 = "Chemistry",
            hobby1 = "Sports",
            hobby2 = "Music",
            picturePath = "src/test/resources/mem.jpeg",
            picture = "mem.jpeg",
            currentAddress = "100, Lenina street",
            state = "Haryana",
            city = "Panipat",
            stateAndCity = String.format("%s %s", state, city);

    @Test
    void successfulSubmit() {

        //Arrange
        registrationForm.openPage();

        //Act
        registrationForm
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(mobile)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject1)
                .setSubject(subject2)
                .setHobby(hobby1)
                .setHobby(hobby2)
                .uploadPicture(picturePath)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .pressSubmit();

        //Assertion
        registrationForm
                .checkResultModalVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject1 + ", " + subject2)
                .checkResult("Hobbies", hobby1 + ", " + hobby2)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity);
    }
}
