package com.example.fanfics.generators;

import com.example.fanfics.models.post.Post;
import com.example.fanfics.models.post.PostList;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PostDataGenerator {
    public static final String OUTPUT_DIR = "src/test/java/com/example/fanfics/data";

    public static void main(String[] args) {
        generatePostCollection(3);
    }

    private static void generatePostCollection(int amount) {
        List<Post> postList = new LinkedList<>();
        for (int i = 0; i < amount; i++) {
            //postList.add(new Post(TestBase.generateText()));
            postList.add(new Post(String.format("New post number new new %d", i + 1)));
        }
        try (FileWriter fileWriter = new FileWriter(OUTPUT_DIR + "/postList.xml")) {
            postListToXml(postList, fileWriter);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    static void postListToXml(List<Post> postList, FileWriter fileWriter) {
        try {
            PostList posts = new PostList();
            posts.setPostList(postList);
            JAXBContext jaxbContext = JAXBContext.newInstance(PostList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(posts, fileWriter);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
