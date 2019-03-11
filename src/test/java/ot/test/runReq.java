package ot.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;



import ot.test.func.*;

import static com.codeborne.selenide.Selenide.$;


public class runReq {

    @BeforeSuite
    public void doBeforeSuite() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }


    @Test
    public void Test1(){
        new func().first_test_login();
        new func().newReqButton();
        new request().new_req("улица Новый Арбат, дом 25","1111111111","Неисправность системы вентиляции");
        new func().saveReqButton();
       String num= new func().reqNumber();
       String dat=new func().Date();
        new func().closeFormButton();
        System.out.println(dat);
        $(By.xpath("//span[@class='search ant-input-affix-wrapper']//input[@id='search']")).setValue(num).pressEnter();
        $(By.xpath("//div[@class='selectable-row even']")).click();
        new request().reqRight(dat);
        System.out.println(num);

    }


//проверка на недоступность выпадающего поля выбора ТИПА ЗАЯВКИ и вывод сообщения в доп меню, что дом не подключен к ЕДЦ
    @Test
        public void Test2() {
//        new func().first_test_login();
        new func().newReqButton();
        try {
            new request().new_req("улица Новый Арбат, дом 26", "", "");

        } catch (ElementNotFound a) {
            System.out.println("Ошибка " + a);
        } finally {
            System.out.println('\n'+"Текст 'Дом не подключен к ЕДЦ'   "+$(By.xpath("//span[contains(text(),'Дом не подключен к ЕДЦ. Обращайтесь в свою диспетч')]")).isDisplayed());
            System.out.println("Недоступность выпадающего списока Тип заявки   "+$(By.cssSelector("div.left span.ant-select.ant-select-disabled.ant-select-allow-clear")).isDisplayed());
            System.out.println("Недоступность кнопки Сохранить   "+$(By.cssSelector("div.inner button.button.disabled")).isDisplayed());
        }
        new func().closeFormButton();
    }

    @Test
    public void Test3() {
//        new func().first_test_login();
        new func().newReqButton();
        new request().new_req("улица Молодцова, дом 17, корпус 1","","Неисправность системы вентиляции");
        new func().saveReqButton();
        System.out.println($(By.xpath("//div[@class='closeable-timed-notification']")).isDisplayed());
        new func().closeFormButton();
    }

    @Test
    public void Test4() {
//        new func().first_test_login();
        new func().newReqButton();
        new request().new_req("улица Молодцова, дом 17, корпус 1","","Неисправность системы вентиляции");
        $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).click();
        $(By.xpath("//div[@id='set-address-focus']//div//span[contains(@class,'ant-select-selection__clear')]")).click();
        System.out.println($(By.xpath("//div[@id='set-address-focus']//input[@class='ant-input ant-select-search__field' and @value='']")).isDisplayed());

//        ant-select ant-select-enabled ant-select-allow-clear
//        ant-select ant-select-disabled ant-select-allow-clear

        System.out.println($(By.xpath("//span[@class='ant-select ant-select-disabled ant-select-allow-clear']")).isDisplayed());;

        System.out.println($(By.xpath("//input[@id='podezd' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//input[@id='floor' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//input[@id='apartment' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//button[@class='button disabled' and @title='Сохранить']")).isDisplayed());
        new func().closeFormButton();
    }



}
