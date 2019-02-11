package ot.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import ot.test.func.*;

public class testcheck {



    @Test
    public void first_test_login() {

//                Configuration.timeout = 8000;
        open("http://213.79.88.85");
        $(By.xpath("//input[@placeholder = 'Логин']")).setValue("support");
        $(By.xpath("//input[@placeholder = 'Пароль']")).setValue("1234");
        $(By.xpath("//button[text()='Войти']")).click();

        System.out.println(new func().newReq());
    }

//    public String newReq(){
//        this.number=$(By.xpath("//div[@class='contacts-info']")).getText();
//        //удаляем лишнее из номера заявки
////        String s = text1;
////        text1 = text1.replaceAll("Была создана заявка |✖", "");
//
//        return this.number;
//    }



}

