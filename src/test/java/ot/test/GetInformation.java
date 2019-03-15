package ot.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GetInformation {

    public String ODS;

    public GetInformation getODS() {
        this.ODS= $(By.cssSelector("div:nth-child(3) div:nth-child(2) div.content div.additional:nth-child(2) > div:nth-child(3)")).getText();
        return this;
    }
}
