package com.example.fanfics.tests;

import com.example.fanfics.base.AuthBase;
import com.example.fanfics.generators.PostDataGenerator;
import com.example.fanfics.models.post.Post;
import com.example.fanfics.models.post.PostList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@RunWith(Theories.class)
public class CreatePostTest extends AuthBase {

    @DataPoints
    public static List<Post> postListFromXml() {
        try {
            JAXBContext context = JAXBContext.newInstance(PostList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            PostList posts = (PostList) unmarshaller.unmarshal(new File(PostDataGenerator.OUTPUT_DIR + "/postList.xml"));
            //System.out.println(posts.getPostList().size());
            return posts.getPostList();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Theory
    public void createPostTestCase(Post post) throws Exception {
        applicationManager.getPostHelper().createPost(post);
        Thread.sleep(5000);
        Post newPost = applicationManager.getPostHelper().getNewPost();
        Assert.assertEquals(post.getText(), newPost.getText());
    }

    @Test
    public void deletePostTestCase() throws Exception {
        int numberOfPost = applicationManager.getPostHelper().getNumberOfPost();
        applicationManager.getPostHelper().deleteNewPost();
        Thread.sleep(2000);
        int numberOfPostUpd = applicationManager.getPostHelper().getNumberOfPost();
        Assert.assertTrue(numberOfPost > numberOfPostUpd);
    }
}
