package com.example.fanfics.base;

import com.example.fanfics.ApplicationManager;
import org.junit.AfterClass;
import org.junit.Before;

import java.util.Random;

public class TestBase {

    protected static ApplicationManager applicationManager;

    @Before
    public void setUp() throws Exception {
        applicationManager = ApplicationManager.getInstance();
        applicationManager.getNavigationHelper().openHomePage();
    }

    @AfterClass
    public static void tearDown() {
        applicationManager.stop();
    }

    public static String generateText() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int numberOfWords = random.nextInt(5) + 1;
        int numberOfLetters = random.nextInt(10) + 3;
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < numberOfWords; i++) {
            for (int j = 0; j < numberOfLetters; j++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            if (i != numberOfWords - 1)
                buffer.append(" ");
        }
        return buffer.toString();
    }

    public static String generateWord() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        int numberOfLetters = random.nextInt(10) + 3;
        StringBuilder buffer = new StringBuilder();
        for (int j = 0; j < numberOfLetters; j++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
