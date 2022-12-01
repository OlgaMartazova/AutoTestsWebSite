package com.example.fanfics.tests;

import com.example.fanfics.base.TestBase;
import com.example.fanfics.generators.AccountDataGenerator;
import com.example.fanfics.models.users.AccountData;
import com.example.fanfics.models.users.Users;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class LoginTests extends TestBase {
    @DataPoints("valid")
    public static List<AccountData> validDataFromXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(AccountDataGenerator.OUTPUT_DIR + "/validAuthData.xml"));
            return users.getUserList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Theory
    public void loginWithValidData(@FromDataPoints("valid") AccountData user) throws Exception {
        AccountData accountData = new AccountData(user.getLogin(), user.getPassword());
        applicationManager.getLoginHelper().login(accountData);
        Thread.sleep(3);
        Assert.assertTrue(applicationManager.getLoginHelper().isLoggedIn(user.getLogin()));
    }

    @DataPoints("invalid")
    public static List<AccountData> invalidDataFromXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(AccountDataGenerator.OUTPUT_DIR + "/invalidAuthData.xml"));
            return users.getUserList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Theory
    public void loginWithInvalidData(@FromDataPoints("invalid") AccountData user) throws Exception {
        AccountData accountData = new AccountData(user.getLogin(), user.getPassword());
        applicationManager.getLoginHelper().login(accountData);
        Thread.sleep(3);
        Assert.assertTrue(applicationManager.getLoginHelper().isErrorLogin());
    }
}
