package ot.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Request {
    public String addr;
    public String tel;
    public String typereq;
    public String comment;
    public String date;
    public String podezd;
    public String floor;
    public String apartment;
    public String code;
    public String phoneAdditional;
    public String fio;
    public String descriptionProblem;





    public Request setAddr(String addr) {
        this.addr = addr;
        return this;
    }

    public Request setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public Request setTypereq(String typereq) {
        this.typereq = typereq;
        return this;
    }

    public Request setComment(String comment) {
        this.comment = comment;
        return this;
    }


    public Request setDate(String date) {
        this.date = date;
        return this;
    }

    public Request setPodezd(String podezd) {
        this.podezd = podezd;
        return this;
    }

    public Request setFloor(String floor) {
        this.floor = floor;
        return this;
    }

    public Request setApartment(String apartment) {
        this.apartment = apartment;
        return this;
    }

    public Request setCode(String code) {
        this.code = code;
        return this;
    }

    public Request setPhoneAdditional(String phoneAdditional) {
        this.phoneAdditional = phoneAdditional;
        return this;
    }

    public Request setFio(String fio) {
        this.fio = fio;
        return this;
    }

    public Request setDescriptionProblem(String descriptionProblem) {
        this.descriptionProblem = descriptionProblem;
        return this;
    }




}