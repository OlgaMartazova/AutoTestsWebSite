package com.example.fanfics.models.users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account-data")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountData {
    @XmlElement(name = "login", required = true)
    private String login;
    @XmlElement(name = "password", required = true)
    private String password;

    public AccountData() {}

    public AccountData(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
