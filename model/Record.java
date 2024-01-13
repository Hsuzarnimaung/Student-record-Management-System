package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/27/2016.
 */

public class Record {

    String date;
    int totalPre;
    int totalAb;
    int totalStu;
    String preList;
    String abList;

    public Record(){}
    public Record(String date,int totalPre,int totalAb,int totalStu,String preList,String abList) {
        this.date = date;
        this.totalStu = totalStu;
        this.totalAb = totalAb;
        this.totalPre = totalPre;
        this.preList=preList;
        this.abList=abList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotalPre() {
        return totalPre;
    }

    public void setTotalPre(int totalPre) {
        this.totalPre = totalPre;
    }

    public int getTotalAb() {
        return totalAb;
    }

    public void setTotalAb(int totalAb) {
        this.totalAb = totalAb;
    }

    public int getTotalStu() {
        return totalStu;
    }

    public void setTotalStu(int totalStu) {
        this.totalStu = totalStu;
    }

    public String getPreList(){return preList;}

    public void setPreList(String preList){this.preList=preList;}

    public String getAbList(){return abList;}

    public void setAbList(String abList){this.abList=abList;}
}
