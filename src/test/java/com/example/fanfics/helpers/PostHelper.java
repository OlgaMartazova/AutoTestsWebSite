package com.example.fanfics.helpers;

import com.example.fanfics.ApplicationManager;
import com.example.fanfics.base.HelperBase;
import com.example.fanfics.models.post.Post;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class PostHelper extends HelperBase {
    public void createPost(Post post) {
        WebElement newMessage = driver.findElement(By.xpath("//div[@id='MessageNewInput']/div"));
        new Actions(driver).moveToElement(newMessage).perform();
        newMessage.click();
        driver.findElement(By.id("MessageNew")).clear();
        driver.findElement(By.id("MessageNew")).sendKeys(post.getText());
        driver.findElement(By.xpath("//input[@value='Отправить']")).click();
    }

    public PostHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public Post getNewPost() {
        String postText = driver.findElement(By.className("MessageText")).getText();
        return new Post(postText);
    }

    public Integer getNumberOfPost() {
        List<String> posts = driver.findElements(By.className("MessageText"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return posts.size();
    }

    public void deleteNewPost() {
        WebElement deleteButton = driver.findElement(By.xpath("//*[@class=\"MessageButtons small_light\"]/div[2]/div[1]"));
        //new Actions(driver).moveToElement(deleteButton).perform();
        deleteButton.click();
        driver.findElement(By.linkText("Удалить")).click();
        driver.findElement(By.xpath("//input[@value='Да, удалить']")).click();
    }
}
