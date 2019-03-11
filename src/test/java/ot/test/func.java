package ot.test;

import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class func {

    public String number;



    public void first_test_login() {


//                Configuration.timeout = 8000;
        open("http://213.79.88.85");
        $(By.xpath("//input[@placeholder = 'Логин']")).setValue("testovyioo");
        $(By.xpath("//input[@placeholder = 'Пароль']")).setValue("1234");
        $(By.xpath("//button[text()='Войти']")).click();
    }


    public String reqNumber() {
       $(By.xpath("//div[@id='request_created']"));
       String text1=$(By.xpath("//div[@id='request_created']")).getText();
        //удаляем лишнее из номера заявки
       String s = text1;
       this.number = s.replaceAll("Была создана заявка |✖", "");

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



    public String Date(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        Date date = new Date();
        String dateCreate = dateFormat.format(date);
        return dateCreate;

    }


    }



