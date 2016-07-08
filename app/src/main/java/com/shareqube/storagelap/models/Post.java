package com.shareqube.storagelap.models;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by judeebene on 7/7/16.
 */
public class Post {

    private String authorid;
    private String full_url;
    private String thumb_storage_uri;
    private String thumb_url;
    private String text;
    private Object timestamp;
    private String full_storage_uri;

    public Post() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    public Post(String authorid, String full_url, String full_storage_uri, String thumb_url, String thumb_storage_uri, String text, Object timestamp) {
        this.authorid = authorid;
        this.full_url = full_url;
        this.text = text;
        this.timestamp = timestamp;
        this.thumb_storage_uri = thumb_storage_uri;
        this.thumb_url = thumb_url;
        this.full_storage_uri = full_storage_uri;
    }


    public String getAuthorid() {
        return authorid;
    }

    public String getFull_url() {
        return full_url;
    }

    public String getText() {
        return text;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public String getThumb_storage_uri() {
        return thumb_storage_uri;
    }


    public String getThumb_url() {
        return thumb_url;
    }

    public String getFull_storage_uri() {
        return full_storage_uri;
    }

    @Exclude
    public Map<String,Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("author" , getAuthorid());
        result.put("full_url" , getFull_url());
        result.put("thumb_storage_uri" , getThumb_storage_uri());
        result.put("thumb_url" , getThumb_url());
        result.put("text" , getText());
        result.put("timestamp" , getTimestamp());
        result.put("full_storage_uri" , getFull_storage_uri());


        return  result ;
    }
}
