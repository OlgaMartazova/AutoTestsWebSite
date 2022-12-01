package com.example.fanfics.generators;

import com.example.fanfics.base.TestBase;
import com.example.fanfics.models.users.AccountData;
import com.example.fanfics.models.users.Users;
import com.example.fanfics.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AccountDataGenerator {
    public static final String OUTPUT_DIR = "src/test/java/com/example/fanfics/data";

    public static void main(String[] args) {
        generateValidData();
        generateInvalidData(2);
    }

    private static void generateInvalidData(int amount) {
        List<AccountData> accountDataList = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            accountDataList.add(new AccountData(TestBase.generateWord(), TestBase.generateWord()));
        }
        try (FileWriter fileWriter = new FileWriter(OUTPUT_DIR + "/invalidAuthData.xml")) {
            userListToXml(accountDataList, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void generateValidData() {
        List<AccountData> accountDataList = new LinkedList<>();
        accountDataList.add(new AccountData(Settings.getLogin(), Settings.getPassword()));
        accountDataList.add(new AccountData("super user", "123456"));
        try (FileWriter fileWriter = new FileWriter(OUTPUT_DIR + "/validAuthData.xml")) {
            userListToXml(accountDataList, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private static void userListToXml(List<AccountData> accountDataList, FileWriter fileWriter) {
        try {
            Users users = new Users();
            users.setUserList(accountDataList);
            JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(users, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
