package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    SelenideElement dateOfBirth = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select");

    private String datePicker = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    public CalendarComponent setDate(String day, String month, String year) {
        dateOfBirth.click();
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption(year);
        $(String.format(datePicker, day)).click();

        return this;
    }
}
