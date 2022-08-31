package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {

    SelenideElement selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input");

    public StateAndCityComponent setStateAndCity(String state, String city) {
        selectState.setValue(state).pressEnter();
        selectCity.setValue(city).pressEnter();

        return this;
    }
}
