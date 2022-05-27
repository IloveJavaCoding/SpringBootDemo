package com.example.sbdemo.bean;

/**
 * @author Virgo
 * @version 1.0
 * @data 2022/5/26 15:17
 * @usage
 */
public class Sheets extends BaseBean{
    private String name;//sheet 名
    private String type;//
    private int[] width;//表格宽度
    private String[] header;//表头
    private Object data;//数据列表

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int[] getWidth() {
        return width;
    }

    public void setWidth(int[] width) {
        this.width = width;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
