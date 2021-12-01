package com.example.manggo;

public class Chart {
    private String num;
    private String cover;
    private String title;
    private String singer;
    private String time;
    public Chart(String num, String cover, String title, String singer, String time){
            this.num = num;
            this.cover = cover;
            this.title = title;
            this.singer = singer;
            this.time = time;

    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Chart{" +
                "num='" + num + '\'' +
                "cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
