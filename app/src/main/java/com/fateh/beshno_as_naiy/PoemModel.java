package com.fateh.beshno_as_naiy;

public class PoemModel {
    private int db_id;
    private int class_number;
    private String poem_title;

    private String poem_txt;
    private String voice_url;

    public PoemModel() {
    }

    public PoemModel(String title){
        this.poem_title = title;
    }

    public PoemModel(int db_id, int class_number, String title, String voice_url, String poem_txt) {
        this.db_id = db_id;
        this.class_number = class_number;
        this.poem_title = title;
        this.poem_txt = poem_txt;
        this.voice_url = voice_url;
    }

    public String getPoem_txt() {
        return poem_txt;
    }

    public int getDb_id() {
        return db_id;
    }

    public void setPoem_txt(String poem_txt) {
        this.poem_txt = poem_txt;
    }

    public int getClass_number() {
        return class_number;
    }

    public String getPoem_title() {
        return poem_title;
    }

    public String getVoice_url() {
        return voice_url;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public void setClass_number(int class_number) {
        this.class_number = class_number;
    }

    public void setPoem_title(String poem_title) {
        this.poem_title = poem_title;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    @Override
    public String toString() {
        return "PoemModel{" + "db_id=" + db_id + ", class_number=" + class_number + ", poem_title='" + poem_title + '\'' + ", poem_txt='" + poem_txt + '\'' + ", voice_url='" + voice_url + '\'' + '}';
    }
}