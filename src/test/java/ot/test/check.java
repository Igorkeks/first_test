package ot.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class check {


    @BeforeSuite
    public void doBeforeSuite() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }

    @Test
    public void Test1(){
        new AppHelper().appLogin();

     $(By.xpath("//span[@class='search ant-input-affix-wrapper']//input[@id='search']")).setValue("0900-0906-003526/19").pressEnter();

        ElementsCollection ec = $$(By.xpath("//div[@class='selectable-row even']")).findBy(text("0900-0906-003526/19")).findAll(By.xpath("//div[@tabindex='-1']"));

//        ec.get(0).shouldHave(text(convertODCName(ODC)));

//        ec.get(1).shouldHave(text(appCreationDate));
       ec.get(8).shouldHave(text("Обычная"));
       ec.get(9).shouldHave(text("Новая"));
////        ec.get(4).shouldHave(text(randomStreet + " Подъезд 6а Этаж 333 кв. 25п"));
//        ec.get(5).shouldHave(text("Привет1!%+-"));
//        ec.get(6).shouldHave(text("Тестовое контактное лицо\nосн.тел.:\n+7 (111) 111-11-11"));
//        ec.get(7).scrollIntoView(true).shouldHave(text("Ржавая вода"));
//        ec.get(8).scrollIntoView(true).shouldHave(text("Сантехника"));
//        ec.get(9).scrollIntoView(true).shouldHave(text("бесплатная"));
//        ec.get(10).scrollIntoView(true).shouldBe(empty);
////        ec.get(11).scrollIntoView(true).shouldHave(text(desiredDate));
////        ec.get(12).scrollIntoView(true)
////                .shouldHave(text(desiredDate + " с " + rhf + ":" + rmf + " по " + rht + ":" + rmt));
//        ec.get(13).scrollIntoView(true).shouldBe(empty);
//        ec.get(14).scrollIntoView(true).shouldBe(empty);
//        ec.get(15).scrollIntoView(true).shouldBe(empty);
//        ec.get(16).scrollIntoView(true).shouldBe(empty);
//        ec.get(17).scrollIntoView(true).shouldBe(empty);
////        ec.get(18).scrollIntoView(true).shouldHave(text("ЦАО"));
////        ec.get(19).scrollIntoView(true).shouldHave(text("Арбат"));
////        ec.get(20).scrollIntoView(true).shouldHave(text(getUserName()));
//        ec.get(21).scrollIntoView(true).shouldBe(empty);
//        ec.get(22).scrollIntoView(true).shouldBe(empty);
//        ec.get(23).scrollIntoView(true).shouldHave(text("Тестовое контактное лицо"));
//        ec.get(24).scrollIntoView(true).shouldHave(text("+7 (111) 111-11-11"));
//        ec.get(25).scrollIntoView(true).shouldHave(text("+7 (495) 123-54-99"));
//        ec.get(26).scrollIntoView(true).shouldHave(text("25п"));
//        ec.get(27).scrollIntoView(true).shouldHave(text("6а"));
//        ec.get(28).scrollIntoView(true).shouldHave(text("333"));
////        ec.get(29).scrollIntoView(true).shouldHave(text(randomStreet));
//        ec.get(30).scrollIntoView(true).shouldHave(text("переговорное устройство"));
////        ec.get(31).scrollIntoView(true).shouldHave(text(appNumber));

        System.out.println(ec);





//        // Проверка значений полей на форме "Заявка"
//        $(byText(appNumber)).shouldBe(exist).click();
//        $(By.xpath("//td[text()='Тип заявки (категория)']/following-sibling::td[1]")).shouldHave(text("Сантехника"));
//        $(By.xpath("//td[text()='Тип дефекта']/following-sibling::td[1]")).shouldHave(text("Ржавая вода"));
//        $(By.xpath("//td[text()='Исполнитель']/following-sibling::td[1]")).shouldHave(text(""));
//        //        $(By.xpath("//td[text()='ОДС']/following-sibling::td[1]")).shouldHave(text(ODC.substring(0, ODC.indexOf('\n'))));
////        $(By.xpath("//td[text()='Управляющая компания']/following-sibling::td[1]")).shouldHave(text(houseService));
//        $(By.xpath("//td[text()='Описание']/following-sibling::td[1]")).shouldHave(text("Привет1!%+-"));
//        $(By.xpath("//td[text()='Приоритет']/following-sibling::td[1]")).shouldHave(text("Обычная"));
//        $(By.xpath("//td[text()='Статус']/following-sibling::td[1]")).shouldHave(text("Новая"));
//        $(By.xpath("//td[text()='Адрес ']/following-sibling::td[1]//input")).shouldHave(value(randomStreet));
//        $(By.xpath("//td[text()='Подъезд']/following-sibling::td[1]//input")).shouldHave(value("6а"));
//        $(By.xpath("//span[text()='Этаж']/following-sibling::span[1]//input")).shouldHave(value("333"));
//        $(By.xpath("//span[text()='Квартира']/following-sibling::span[1]//input")).shouldHave(value("25п"));
//        $(By.xpath("//td[text()='Код домофона']/following-sibling::td[1]//input")).shouldHave(value("25п"));
//        $(By.xpath("//td[text()='Контактное лицо']/following-sibling::td[1]//input")).shouldHave(value("Тестовое контактное  лицо "));
//        $(By.xpath("//td[text()='Основной телефон']/following-sibling::td[1]")).shouldHave(text("+7 (111) 111-11-11"));
//        $(By.xpath("//td[text()='Дополнительный телефон']/following-sibling::td[1]//input")).shouldHave(value("+7 (495) 123-54-99"));
//        $x("//td[text()='Желаемое время']/following-sibling::td[1]")
//                .shouldHave(text(desiredDate + " с " + rhf + ":" + rmf + " по " + rht + ":" + rmt));
//        $(By.xpath("//td[text()='Платность']/following-sibling::td[1]")).shouldHave(text("бесплатная"));
//        $(By.xpath("//td[text()='Дата составления']/following-sibling::td[1]")).shouldHave(text(appCreationDate));
//        $(By.xpath("//td[text()='Принял заявку']/following-sibling::td[1]")).shouldHave(text(getUserName()));
//        $(By.xpath("//td[text()='Источник']/following-sibling::td[1]")).shouldHave(text("переговорное устройство"));
//        $(By.xpath("//td[text()='Причина отмены']/following-sibling::td[1]")).shouldHave(text(""));
//        $(By.xpath("//td[text()='Причина отклонения']/following-sibling::td[1]")).shouldHave(text(""));


    }

}
