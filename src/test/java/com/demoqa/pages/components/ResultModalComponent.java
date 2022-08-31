package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {

    private final static String TITLE_TEXT = "Thanks for submitting the form";
    SelenideElement resultModal = $(".modal-content"),
            titleModal = $("#example-modal-sizes-title-lg"),
            labelModal = $(".table-responsive");


    public ResultModalComponent checkVisible() {
        resultModal.should(appear);
        titleModal.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public ResultModalComponent checkResult(String key, String value) {
        labelModal.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }
}
