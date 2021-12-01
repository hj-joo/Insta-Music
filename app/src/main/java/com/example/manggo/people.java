package com.example.manggo;

public class people {
    private String name;
    private String heart;
    private String num;

    public people(String name, String heart, String num) {
        this.name = name;
        this.heart = heart;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", heart='" + heart + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}
