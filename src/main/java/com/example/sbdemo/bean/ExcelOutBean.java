package com.example.sbdemo.bean;

import java.util.List;

/**
 * @author Virgo
 * @version 1.0
 * @data 2022/5/26 15:08
 * @usage
 */
public class ExcelOutBean extends BaseBean {
    private String name;//导出文件名
    private int num;//sheet 数
    private List<Sheets> sheets;//

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Sheets> getSheets() {
        return sheets;
    }

    public void setSheets(List<Sheets> sheets) {
        this.sheets = sheets;
    }
}
