package ot.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class func {

    private String number;

    public String newReq() {
        this.number = $(By.xpath("//div[@class='contacts-info']")).getText();
        //удаляем лишнее из номера заявки
//        String s = text1;
//        text1 = text1.replaceAll("Была создана заявка |✖", "");

        return this.number;
    }

    public void newReqButton(){
        $(By.xpath("//button[@id='createNew']")).click();

    }

    public void saveReqButton(){
        $(By.xpath("//button[@title='Сохранить']")).click();
    }

    public void closeFormButton(){
        $(By.xpath("//div[@id='new-request']//div[@class='close-button']")).click();
    }

    public void exit(){
        $(By.xpath("//div[@id='profile-menu-icon']")).click();
        $(By.xpath("//a[@title='Выйти из системы']")).click();
    }


    }



