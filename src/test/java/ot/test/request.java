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

import org.openqa.selenium.By;

public class request {


    public void new_req(String addr, String tel, String typereq) {
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
    }
}
