package com.example.fanfics.helpers;

import com.example.fanfics.models.users.AccountData;
import com.example.fanfics.ApplicationManager;
import com.example.fanfics.base.HelperBase;
import com.example.fanfics.settings.Settings;
import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {
    public void login(AccountData user) {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getLogin())) {
                return;
            }
            logout();
        }
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(user.getLogin());
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).click();
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys(user.getPassword());
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
    }

    public LoginHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Boolean isLoggedIn() {
        return isElementPresent(By.xpath("//td[@id='private_menu_name']/b"));
    }

    public Boolean isLoggedIn(String username) {
        if (!isLoggedIn()) return false;
        String login = driver.findElement(By.xpath("//td[@id='private_menu_name']/b")).getText();
        return username.equals(login);
    }

    private void logout() {
        driver.get(Settings.getBaseUrl());
        driver.findElement(By.id("private_menu_name")).click();
        driver.findElement(By.linkText("Выход")).click();
    }

    public boolean isErrorLogin() {
        return isElementPresent(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Чужой компьютер'])[2]/following::div[1]"));
    }
}
