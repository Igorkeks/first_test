package ot.test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import ot.test.func.*;


public class FirstTest {
    @BeforeSuite
    public void doBeforeSuite() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }


    @BeforeTest
    public void first_test_login() {

//                Configuration.timeout = 8000;
        open("http://213.79.88.85");
        $(By.xpath("//input[@placeholder = 'Логин']")).setValue("support");
        $(By.xpath("//input[@placeholder = 'Пароль']")).setValue("1234");
        $(By.xpath("//button[text()='Войти']")).click();
//    String a=$(By.xpath("//a[@class='app__name-text']")).getText();
//    System.out.println(a);
//    String b="Единый Диспетчерский Центр";
//                System.out.println(b);
//    if (a!=b){
//        throw new IllegalArgumentException();
//    }


    }






    @Parameters

            public void new_req(String addr, String tel, String typereq) {


        new func().newReqButton();
        //$(By.xpath("//button[@id='createNew']")).click();
                $(By.xpath("//div[@id='set-address-focus']//input[@class='ant-input ant-select-search__field']")).isDisplayed();
                $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).setValue(addr);


                $(By.xpath("//li[contains(@class,'ant-select-dropdown-menu-item-active ant-select-dropdown-menu-item')]")).click();
                $(By.id("address-comment")).setValue("Комментарий");
                $(By.id("podezd")).setValue("2");
                $(By.id("floor")).setValue("3");
                $(By.id("apartment")).setValue("10");
                $(By.xpath("//span[contains(text(),'другой')]")).click();

                $(By.xpath("//div[@class='right']/div[@class='row']/span[@class='ant-input-affix-wrapper']/input[@class='ant-input']")).setValue("123");
                $(By.id("phone-main")).setValue(tel);
                $(By.id("phone-additional")).setValue("0987654321");
                $(By.xpath("//div[@class='right']//div[6]//input[@class='ant-input']")).setValue("ФИО");
                $(By.xpath("//span[text()='завтра']")).click();
                $(By.xpath("//span[text()='первая половина']")).click();
                $(By.xpath("//div[text()='телефон']")).click();
                $(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']//li[@title='личное обращение (окно)']")).click();


                $(By.xpath("//span[@class='ant-select-selection__rendered']")).click();
                $(By.xpath("//div[@class='tree-content-height-limiter']//input[@class='ant-select-search__field' and @role='textbox']")).setValue(typereq);
                $(By.xpath("//span[@class='ant-select-tree-node-content-wrapper ant-select-tree-node-content-wrapper-normal']")).click();
                $(By.xpath("//div[@class='left']//textarea[@class='ant-input']")).setValue("Описание проблемы");

                //кнопка сохранить-нажать
             //   $(By.xpath("//button[@title='Сохранить']")).click();
                //берем номер созданной заявки
           //     $(By.xpath("//div[@id='request_created']"));

new func().closeFormButton();
new func().exit();


//                String text1=$(By.xpath("//div[@id='request_created']")).getText();
//                //удаляем лишнее из номера заявки
//                String s = text1;
//                s = s.replaceAll("Была создана заявка |✖", "");




                //System.out.println(new saveReq());



            }





    @Test
    @Description("Успешная заявка")
    public void firstTest1(){
        new_req("улица Новый Арбат, дом 25","1234567890","Неисправность системы вентиляции");
    }

//    @Test
//    @Description("Успешная заявка")
//    public void firstTest2(){
//        new_req("улица Новый Арбат, дом 25","1234567890","Неисправность системы вентиляции");
//    }


}
