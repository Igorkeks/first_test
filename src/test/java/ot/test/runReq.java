package ot.test;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




import ot.test.func.*;


public class runReq {

    @BeforeSuite
    public void doBeforeSuite() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
    }


    @Test
    public void firstTest1(){
        new func().first_test_login();
        new func().newReqButton();
        new request().new_req("улица Новый Арбат, дом 25","1234567890","Неисправность системы вентиляции");
        new func().saveReqButton();
       String num= new func().reqNumber();
        new func().closeFormButton();
        System.out.println(num);
    }



}
