package com.example.manggo;

public class Playlist {

    private String cover;
    private String title;
    private String singer;
    public Playlist(String cover, String title, String singer){

        this.cover = cover;
        this.title = title;
        this.singer = singer;


    }



    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }



    @Override
    public String toString() {
        return "Chart{" +
                "cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                '}';
    }
}