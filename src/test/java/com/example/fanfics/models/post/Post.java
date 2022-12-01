package com.example.fanfics.models.post;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class Post {
    @XmlElement(name = "text", required = true)
    private String text;

    public String getText() {
        return text;
    }

    public Post() {
    }

    public Post(String text) {
        this.text = text;
    }
}
