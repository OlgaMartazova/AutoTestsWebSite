package com.example.fanfics.models.post;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "post-list")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostList {

    @XmlElement(name = "post")
    private List<Post> postList;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> posts) {
        this.postList = posts;
    }
}
