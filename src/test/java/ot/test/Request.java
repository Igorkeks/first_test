package ot.test;

public class Request {
    public String addr;
    public String tel;
    public String typereq;
    public String comment;
    public String date;

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
}
