package com.aamjantamedia.ajm;

public class Article {
    private String Title ;
    private String Content ;

    public Article() {
        this.Title = "";
        this.Content = "";
    }
    public Article(String title, String content) {
        this.Title = title;
        this.Content = content;
    }

    public String getContent() {
        return Content;
    }

    public String getTitle() {
        return Title;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
