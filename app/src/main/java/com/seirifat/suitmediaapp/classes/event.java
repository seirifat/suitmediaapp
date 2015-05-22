package com.seirifat.suitmediaapp.classes;

/**
 * Created by ORION on 5/22/2015.
 */
public class event {

    private int drawableId;
    private String name;
    private String date;

    public event(int drawableId, String name, String date) {
        this.drawableId = drawableId;
        this.name = name;
        this.date = date;
    }

    //getter setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
