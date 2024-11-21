package com.di;

class Zoom{
    private String URL;
    private String Time;
    public Zoom(String URL, String Time){
        this.Time = Time;
        this.URL = URL;
    }

    public String getURL(){
        return URL;
    }
    public String getTime(){
        return Time;
    }
    public void setURL(String newURL){
        this.URL = newURL;
    }
    public void setTime(String newTime){
        this.Time = newTime;
    }
} 