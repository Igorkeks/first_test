package ot.test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class RequestHelper {


    public void fillInRequest(Request request) {

        $(By.xpath("//div[@id='set-address-focus']//input[@class='ant-input ant-select-search__field']")).isDisplayed();
        if (request.addr != null) {
            if (!request.addr.equals("")) {
                $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).setValue(request.addr);
                $(By.xpath("//li[contains(@class,'ant-select-dropdown-menu-item-active ant-select-dropdown-menu-item')]")).click();
            } else {
                $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).click();
                $(By.xpath("//div[@id='set-address-focus']//div//span[contains(@class,'ant-select-selection__clear')]")).click();
            }
        }

        if (request.typereq != null) {
            $(By.xpath("//span[@class='ant-select-selection__rendered']")).click();
            $(By.xpath("//div[@class='tree-content-height-limiter']//input[@class='ant-select-search__field' and @role='textbox']")).setValue(request.typereq);
            $(By.xpath("//span[@class='ant-select-tree-node-content-wrapper ant-select-tree-node-content-wrapper-normal']")).click();
        }

        $(By.id("address-comment")).setValue(request.comment);
        $(By.id("podezd")).setValue(request.podezd); //?><!@#12F
        $(By.id("floor")).setValue(request.floor); //#@!?><12345
        $(By.id("apartment")).setValue(request.apartment); //)(*&^%$##@!3F210FGH
        $(By.xpath("//span[contains(text(),'другой')]")).click();

        $(By.xpath("//div[@class='right']/div[@class='row']/span[@class='ant-input-affix-wrapper']/input[@class='ant-input']")).setValue(request.code);//123
        $(By.id("phone-main")).setValue(request.tel);
        $(By.id("phone-additional")).setValue(request.phoneAdditional);//0987654321
        $(By.xpath("//div[@class='right']//div[6]//input[@class='ant-input']")).setValue(request.fio); //!№;12Ф,И,О
//                    div.right span.ant-input-affix-wrapper[css*='8']
        $(By.xpath("//span[text()='завтра']")).click();
        $(By.xpath("//span[text()='первая половина']")).click();
//        $(By.xpath("//div[text()='телефон']")).click();
//        $(By.xpath("//div[text()='телефон']")).getValue();
//        $(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']//li[@title='личное обращение (окно)']")).click();

        $(By.xpath("//div[@class='left']//textarea[@class='ant-input']")).setValue(request.descriptionProblem);//Описание проблемы
    }
















    public void fillInRequest(String addr, String tel, String typereq) {


        $(By.xpath("//div[@id='set-address-focus']//input[@class='ant-input ant-select-search__field']")).isDisplayed();
        $(By.xpath("//div[@class='right']//input[@class='ant-input ant-select-search__field']")).setValue(addr);
        $(By.xpath("//li[contains(@class,'ant-select-dropdown-menu-item-active ant-select-dropdown-menu-item')]")).click();

        $(By.xpath("//span[@class='ant-select-selection__rendered']")).click();
        $(By.xpath("//div[@class='tree-content-height-limiter']//input[@class='ant-select-search__field' and @role='textbox']")).setValue(typereq);
        $(By.xpath("//span[@class='ant-select-tree-node-content-wrapper ant-select-tree-node-content-wrapper-normal']")).click();

        $(By.id("address-comment")).setValue("Комментарий");
        $(By.id("podezd")).setValue("?><!@#12F");
        $(By.id("floor")).setValue("#@!?><12345");
        $(By.id("apartment")).setValue(")(*&^%$##@!3F210FGH");
        $(By.xpath("//span[contains(text(),'другой')]")).click();

        $(By.xpath("//div[@class='right']/div[@class='row']/span[@class='ant-input-affix-wrapper']/input[@class='ant-input']")).setValue("123");
        $(By.id("phone-main")).setValue(tel);
        $(By.id("phone-additional")).setValue("0987654321");
        $(By.xpath("//div[@class='right']//div[6]//input[@class='ant-input']")).setValue("!№;12Ф,И,О");
//                    div.right span.ant-input-affix-wrapper[css*='8']
        $(By.xpath("//span[text()='завтра']")).click();
        $(By.xpath("//span[text()='первая половина']")).click();
//        $(By.xpath("//div[text()='телефон']")).click();
//        $(By.xpath("//div[text()='телефон']")).getValue();
//        $(By.xpath("//div[@class='ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft']//li[@title='личное обращение (окно)']")).click();

        $(By.xpath("//div[@class='left']//textarea[@class='ant-input']")).setValue("Описание проблемы");



    }

    public void reqRightMin(Request request) {
        $(By.xpath("//td[contains(text(),'Тип заявки (категория)')]/following::td[1]")).shouldHave(text("Вентиляция"));
        $(By.xpath("//td[contains(text(),'Тип дефекта')]/following::td[1]")).shouldHave(text(request.typereq));
        $(By.xpath("//td[@class='name'][contains(text(),'ОДС')]/following::td[1]")).shouldHave(text("ОДС № 1"));
        $(By.xpath("//td[contains(text(),'Управляющая компания')]/following::td[1]")).shouldHave(text("ГБУ «ЖИЛИЩНИК РАЙОНА АРБАТ»"));
        $(By.xpath("//td[contains(text(),'Приоритет')]/following::td[1]")).shouldHave(text("Обычная"));
        $(By.xpath("//td[text()='Статус']/following::td[1]")).shouldHave(text("Новая"));
        $(By.xpath("//td[text()='Адрес ']/following::td[1]//input")).shouldHave(value(request.addr));
        $(By.xpath("//td[contains(text(),'Основной телефон')]/following::td[1]")).shouldHave(text(request.tel));
        $(By.xpath("//td[contains(text(),'Платность')]/following::td[1]")).shouldHave(text("бесплатная / платная"));
        $(By.xpath("//td[text()='Дата составления']/following::td[1]")).shouldHave(text(request.date));
        $(By.xpath("//td[contains(text(),'Источник')]/following::td[1]")).shouldHave(text("телефон"));
    }




    public void reqRightMax(Request request) {
        $(By.xpath("//td[contains(text(),'Тип заявки (категория)')]/following::td[1]")).shouldHave(text("Вентиляция"));
        $(By.xpath("//td[contains(text(),'Тип дефекта')]/following::td[1]")).shouldHave(text(request.typereq));
        $(By.xpath("//td[@class='name'][contains(text(),'ОДС')]/following::td[1]")).shouldHave(text("ОДС № 1"));
        $(By.xpath("//td[contains(text(),'Управляющая компания')]/following::td[1]")).shouldHave(text("ГБУ «ЖИЛИЩНИК РАЙОНА АРБАТ»"));
        $(By.xpath("//td[contains(text(),'Описание')]/following::td[1]")).shouldHave(text(request.descriptionProblem));
        $(By.xpath("//td[contains(text(),'Приоритет')]/following::td[1]")).shouldHave(text("Обычная"));
        $(By.xpath("//td[text()='Статус']/following::td[1]")).shouldHave(text("Новая"));
        $(By.xpath("//td[text()='Адрес ']/following::td[1]//input")).shouldHave(value(request.addr));
        $(By.xpath("//td[contains(text(),'Комментарий к адресу')]/following::td[1]")).shouldHave(text(request.comment));
        $(By.xpath("//td[contains(text(),'Подъезд')]/following::td[1]//input")).shouldHave(value(request.podezd));
        $(By.xpath("//span[contains(text(),'Этаж')]/following::span[1]//input")).shouldHave(value(request.floor));
        $(By.xpath("//span[contains(text(),'Квартира')]/following::span[1]//input")).shouldHave(value(request.apartment));
        $(By.xpath("//td[contains(text(),'Код домофона')]/following::td[1]//input")).shouldHave(value(request.code));
        $(By.xpath("//td[contains(text(),'Контактное лицо')]/following::td[1]//input")).shouldHave(value(request.fio));
        $(By.xpath("//td[contains(text(),'Основной телефон')]/following::td[1]")).shouldHave(text(request.tel));
        $(By.xpath("//td[contains(text(),'Дополнительный телефон')]/following::td[1]//input")).shouldHave(value(request.phoneAdditional));
        $(By.xpath("//td[contains(text(),'Платность')]/following::td[1]")).shouldHave(text("бесплатная / платная"));
        $(By.xpath("//td[text()='Дата составления']/following::td[1]")).shouldHave(text(request.date));
        $(By.xpath("//td[contains(text(),'Источник')]/following::td[1]")).shouldHave(text("телефон"));
    }



    public void reqRight(String date) {

        $(By.xpath("//td[contains(text(),'Тип заявки (категория)')]/following::td[1]")).shouldHave(text("Вентиляция"));
        $(By.xpath("//td[contains(text(),'Тип дефекта')]/following::td[1]")).shouldHave(text("Неисправность системы вентиляции"));
        $(By.xpath("//td[@class='name'][contains(text(),'ОДС')]/following::td[1]")).shouldHave(text("ОДС № 1"));
        $(By.xpath("//td[contains(text(),'Управляющая компания')]/following::td[1]")).shouldHave(text("ГБУ «ЖИЛИЩНИК РАЙОНА АРБАТ»"));
        $(By.xpath("//td[contains(text(),'Описание')]/following::td[1]")).shouldHave(text("Описание проблемы"));
        $(By.xpath("//td[contains(text(),'Приоритет')]/following::td[1]")).shouldHave(text("Обычная"));
        $(By.xpath("//td[text()='Статус']/following::td[1]")).shouldHave(text("Новая"));
        $(By.xpath("//td[text()='Адрес ']/following::td[1]//input")).shouldHave(value("улица Новый Арбат, дом 25"));
        $(By.xpath("//td[contains(text(),'Комментарий к адресу')]/following::td[1]")).shouldHave(text("Комментарий"));
        $(By.xpath("//td[contains(text(),'Подъезд')]/following::td[1]//input")).shouldHave(value("12F"));
        $(By.xpath("//span[contains(text(),'Этаж')]/following::span[1]//input")).shouldHave(value("123"));
        $(By.xpath("//span[contains(text(),'Квартира')]/following::span[1]//input")).shouldHave(value("3F21"));
        $(By.xpath("//td[contains(text(),'Код домофона')]/following::td[1]//input")).shouldHave(value("123"));
        $(By.xpath("//td[contains(text(),'Контактное лицо')]/following::td[1]//input")).shouldHave(value("ФИО"));
        $(By.xpath("//td[contains(text(),'Основной телефон')]/following::td[1]")).shouldHave(text("+7 (111) 111-11-11"));
        $(By.xpath("//td[contains(text(),'Дополнительный телефон')]/following::td[1]//input")).shouldHave(value("+7 (098) 765-43-21"));
        $(By.xpath("//td[contains(text(),'Платность')]/following::td[1]")).shouldHave(text("бесплатная / платная"));
        $(By.xpath("//td[text()='Дата составления']/following::td[1]")).shouldHave(text(date));
        $(By.xpath("//td[contains(text(),'Источник')]/following::td[1]")).shouldHave(text("телефон"));




    }
}
