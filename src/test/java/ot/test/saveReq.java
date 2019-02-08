package ot.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class saveReq {

    private String number;

    public String newReq() {
        this.number = $(By.xpath("//div[@class='contacts-info']")).getText();
        //удаляем лишнее из номера заявки
//        String s = text1;
//        text1 = text1.replaceAll("Была создана заявка |✖", "");

        return this.number;
    }
}

