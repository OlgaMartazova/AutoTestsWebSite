package com.example.fanfics.tests;

import com.example.fanfics.base.AuthBase;
import org.junit.Assert;
import org.junit.Test;

public class DeletePostTest extends AuthBase {
    //    @DataPoints
//    public static List<Integer> deletePost() {
//        int sizeOfList = 10;
//        System.out.println(sizeOfList);
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < sizeOfList; i++) {
//            list.add(0);
//        }
//        return list;
//    }

    @Test
    public void deletePostTestCase() throws Exception {
        int numberOfPost = applicationManager.getPostHelper().getNumberOfPost();
        applicationManager.getPostHelper().deleteNewPost();
        Thread.sleep(2000);
        int numberOfPostUpd = applicationManager.getPostHelper().getNumberOfPost();
        Assert.assertTrue(numberOfPost > numberOfPostUpd);
    }
}
