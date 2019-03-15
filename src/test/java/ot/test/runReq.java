package ot.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$;


public class runReq {
    AppHelper appHelper;
    RequestHelper requestHelper;

    @BeforeSuite
    public void doBeforeSuite() {
        appHelper = new AppHelper();
        requestHelper = new RequestHelper();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KuzakovIO\\Desktop\\chromedriver.exe");
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        appHelper.appLogin();
    }


    @Test
    public void createRequestSuccessMinRequiredFieldsTest(){
        appHelper.clickNewReqButton();

        Request request =
                new Request()
                        .setAddr("улица Новый Арбат, дом 25")
                        .setTypereq("Неисправность системы вентиляции")
                        .setTel("1111111111");

        requestHelper.fillInRequest(request);
        GetInformation information=new GetInformation()
                .getODS();
        System.out.println(information.ODS);
//        appHelper.saveReqButton();
        String num = appHelper.reqNumber();
        String dat = appHelper.date();
        appHelper.closeFormButton();
        $(By.xpath("//span[@class='search ant-input-affix-wrapper']//input[@id='search']")).setValue(num).pressEnter();
        $(By.xpath("//div[@class='selectable-row even']")).click();
        requestHelper.reqRightMin(request);
        System.out.println(dat);
        System.out.println(num);
    }

    @Test
    public void createRequestSuccessAllFieldsTest(){

        //requestHelper.reqRight(request);
    }

    @Test
    public void createRequestSuccessTest(){
        appHelper.clickNewReqButton();

        Request request =
                new Request()
                        .setTypereq("Неисправность системы вентиляции")
                        .setAddr("улица Новый Арбат, дом 25")
                        .setComment("Комментарий")
                        .setTel("1111111111")
                        // .setDate("")
                        .setPodezd("?><!@#12F")
                        .setFloor("#@!?><12345")
                        .setApartment(")(*&^%$##@!3F210FGH")
                        .setCode("123")
                        .setPhoneAdditional("0987654321")
                        .setFio("!№;12Ф,И,О")
                        .setDescriptionProblem("Описание проблемы");
        requestHelper.fillInRequest(request);

//        requestHelper.fillInRequest("улица Новый Арбат, дом 25","1111111111","Неисправность системы вентиляции");
        appHelper.saveReqButton();
        String num = appHelper.reqNumber();
        String dat = appHelper.date();
        appHelper.closeFormButton();
        $(By.xpath("//span[@class='search ant-input-affix-wrapper']//input[@id='search']")).setValue(num).pressEnter();
        $(By.xpath("//div[@class='selectable-row even']")).click();
        requestHelper.reqRightMax(request);
        System.out.println(dat);
        System.out.println(num);

    }


//проверка на недоступность выпадающего поля выбора ТИПА ЗАЯВКИ и вывод сообщения в доп меню, что дом не подключен к ЕДЦ
    @Test
        public void createRequestBlockedTest() {

//        new AppHelper().appLogin();
        appHelper.clickNewReqButton();
        try {
            new RequestHelper().fillInRequest("улица Новый Арбат, дом 26", "", "");
        } catch (ElementNotFound a) {
            System.out.println("Ошибка " + a);
        } finally {
            System.out.println('\n'+"Текст 'Дом не подключен к ЕДЦ'   "+$(By.xpath("//span[contains(text(),'Дом не подключен к ЕДЦ. Обращайтесь в свою диспетч')]")).isDisplayed());
            System.out.println("Недоступность выпадающего списока Тип заявки   "+$(By.cssSelector("div.left span.ant-select.ant-select-disabled.ant-select-allow-clear")).isDisplayed());
            System.out.println("Недоступность кнопки Сохранить   "+$(By.cssSelector("div.inner button.button.disabled")).isDisplayed());
        }
        appHelper.closeFormButton();
    }

    @Test
    public void checkRequestFieldsRestrictionTest() {
//        new AppHelper().appLogin();
      refresh();
        appHelper.clickNewReqButton();
        new RequestHelper().fillInRequest("улица Молодцова, дом 17, корпус 1","!@#?","Неисправность системы вентиляции");

//        System.out.println($(By.cssSelector("div.left>span[style*='color']")).getText());
        //проверка на символы в поле Описание
        if (!$(By.cssSelector("div.left>span[style*='color']")).getText().equals("Осталось: 1983 символов")){
            System.out.println("Значение поля Описание не совпадает") ;
            return;
        }
        //проверка поля подъезд
        if (!$(By.id("podezd")).getValue().equals("12F")){
            System.out.println("Значение поля Подъезд не совпадает") ;
          return;
        }
        //проверка поля этаж
        if (!$(By.id("floor")).getValue().equals("123")){
            System.out.println("Значение поля Этаж не совпадает") ;
            return;
        }
        //проверка поля квартира
        if (!$(By.id("apartment")).getValue().equals("3F21")){
            System.out.println("Значение поля Квартира не совпадает") ;
            return;
        }
        //проверка поля контактное лицо
        if (!$(By.xpath("//div[@class='right']//div[6]//input[@class='ant-input']")).getValue().equals("ФИО")){
            System.out.println("Значение поля Контактное лицо не совпадают") ;
            return;
        }
//        new AppHelper().saveReqButton();
//        System.out.println($(By.xpath("//div[@class='closeable-timed-notification']")).isDisplayed());
        appHelper.closeFormButton();
    }

    @Test
//кнопка сохранить и поле тип заявки недоступны+аварийная заявка
    public void Test4() {

        refresh();
//        new AppHelper().appLogin();
        appHelper.clickNewReqButton();
        new RequestHelper().fillInRequest("улица Молодцова, дом 17, корпус 1","","Пар в подвале");
        $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).click();
        $(By.xpath("//div[@id='set-address-focus']//div//span[contains(@class,'ant-select-selection__clear')]")).click();
        System.out.println($(By.xpath("//div[@id='set-address-focus']//input[@class='ant-input ant-select-search__field' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//span[@class='ant-select ant-select-disabled ant-select-allow-clear']")).isDisplayed());
        System.out.println($(By.xpath("//input[@id='podezd' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//input[@id='floor' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//input[@id='apartment' and @value='']")).isDisplayed());
        System.out.println($(By.xpath("//button[@class='button disabled' and @title='Сохранить']")).isDisplayed());
        System.out.println($(By.cssSelector("div[title*='Аварийная']")).isDisplayed());
        appHelper.closeFormButton();
    }



}
