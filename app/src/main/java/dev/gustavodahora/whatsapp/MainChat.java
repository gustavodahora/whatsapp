package dev.gustavodahora.whatsapp;

public class MainChat {
    private int id;
    private int chatContent;
    private int time;

    public MainChat(int id, int chatContent, int time, boolean isLeft) {
        this.id = id;
        this.chatContent = chatContent;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatContent() {
        return chatContent;
    }

    public void setChatContent(int chatContent) {
        this.chatContent = chatContent;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
