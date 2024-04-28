package com.fateh.beshno_as_naiy;

public class PoemModel {
    private int db_id;
    private int class_number;
    private String name;
    private String voice_url;

    public PoemModel() {
    }

    public PoemModel(int db_id, int class_number, String name, String voice_url){
        this.db_id = db_id;
        this.class_number = class_number;
        this.name = name;
        this.voice_url = voice_url;
    }

    public int getDb_id() {
        return db_id;
    }

    public int getClass_number() {
        return class_number;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    @Override
    public String toString() {
        return "PoemModel{" +
                "db_id=" + db_id +
                ", class_number=" + class_number +
                ", name='" + name + '\'' +
                ", voice_url='" + voice_url + '\'' +
                '}';
    }
}