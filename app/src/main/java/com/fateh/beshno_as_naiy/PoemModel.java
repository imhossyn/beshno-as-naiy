package com.fateh.beshno_as_naiy;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import java.io.Serializable;

public class PoemModel implements Serializable {
    private int db_id;
    private int level;
    private String poem_title;
    private String poem_txt;
    private String voice_url;

    public PoemModel(int db_id, int class_number, String title, String voice_url, String poem_txt) {
        this.db_id = db_id;
        this.level = class_number;
        this.poem_title = title;
        this.poem_txt = poem_txt;
        this.voice_url = voice_url;
    }

    protected PoemModel(Parcel in) {
        db_id = in.readInt();
        level = in.readInt();
        poem_title = in.readString();
        poem_txt = in.readString();
        voice_url = in.readString();
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

    public int getLevel() {
        return level;
    }

    public String getPoem_title() {
        return poem_title;
    }

    public String getVoice_url() {
        return voice_url;
    }

    public String getPoem_header(){
        String[] title_split = this.poem_title.split("\\(");
        return title_split[0];
    }

    public String getPoem_subject(){
        String[] title_split = this.poem_title.split("\\(");
        return "(" + title_split[1];
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPoem_title(String poem_title) {
        this.poem_title = poem_title;
    }

    public void setVoice_url(String voice_url) {
        this.voice_url = voice_url;
    }

    @Override
    public String toString() {
        return "PoemModel{" + "db_id=" + db_id + ", class_number=" + level + ", poem_title='" + poem_title + '\'' + ", poem_txt='" + poem_txt + '\'' + ", voice_url='" + voice_url + '\'' + '}';
    }

}