package com.example.sbdemo.bean;

/**
 * @author Virgo
 * @version 1.0
 * @data 2022/5/26 15:39
 * @usage
 */
public class Schedule extends BaseBean {
    private int id;
    private String start;
    private String duration;
    private String end;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
