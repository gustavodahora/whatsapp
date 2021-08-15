package dev.gustavodahora.whatsapp;

public class MainItem {
    private int id;
    private int imageId;
    private int nameId;
    private int lastChatId;
    private boolean isMuted;
    private int time;

    public MainItem(int id, int imageId, int nameId, int lastChatId, boolean isMuted, int time) {
        this.id = id;
        this.imageId = imageId;
        this.nameId = nameId;
        this.lastChatId = lastChatId;
        this.isMuted = isMuted;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public int getLastChatId() {
        return lastChatId;
    }

    public void setLastChatId(int lastChatId) {
        this.lastChatId = lastChatId;
    }

    public boolean isMuted() {
        return isMuted;
    }

    public void setMuted(boolean muted) {
        isMuted = muted;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
