package com.example.fanfics.models.users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "user-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {

    @XmlElement(name = "account-data")
    private List<AccountData> userList;

    public List<AccountData> getUserList() {
        return userList;
    }

    public void setUserList(List<AccountData> userList) {
        this.userList = userList;
    }
}
