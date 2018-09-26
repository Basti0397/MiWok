package com.example.android.miwok;

import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.ArrayList;

public class Word {

    private String miwokTranslation;
    private String defaultTranslation;
    private Integer image_Id;
    private Integer sound_Id;

    public Word(String defaultTranslation, String miwokTranslation, Integer sound_Id){
        this.miwokTranslation=miwokTranslation;
        this.defaultTranslation=defaultTranslation;
        this.sound_Id=sound_Id;
    }

    public Word(String defaultTranslation, String miwokTranslation, Integer image_Id, Integer sound_Id) {
        this.miwokTranslation=miwokTranslation;
        this.defaultTranslation=defaultTranslation;
        this.image_Id=image_Id;
        this.sound_Id=sound_Id;
    }

    public String getDefaultTranslation(){
        return defaultTranslation;
    }

    public String getMiwokTranslation(){
        return miwokTranslation;
    }

    public Integer getImageResourceId(){ return image_Id; }

    public Integer getSound_Id() {
        return sound_Id;
    }
}
