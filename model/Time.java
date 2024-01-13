package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/25/2016.
 */

public class Time {
    int timeId;
    String academicyear;
    String timeclass;
    String timemajor;
    String timeselect;
    String timeday;

    String time1;
    String time2;
    String time3;
    String time4;
    String time5;
    String time6;
    String time7;

    public Time() {
    }

    public Time(String academicyear, String timeclass, String timemajor, String timeselect, String timeday) {
        this.academicyear = academicyear;
        this.timeclass = timeclass;
        this.timemajor = timemajor;
        this.timeselect = timeselect;
        this.timeday = timeday;
    }

    public Time(int timeId, String academicyear
            , String timeclass, String timemajor
            , String timeselect , String timeday
            , String time1, String time2
            , String time3, String time4
            , String time5, String time6, String time7) {
        this.timeId = timeId;
        this.academicyear = academicyear;
        this.timeclass = timeclass;
        this.timemajor = timemajor;
        this.timeday = timeday;
        this.timeselect = timeselect;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.time5 = time5;
        this.time6 = time6;
        this.time7 = time7;
    }

    public Time(String academicyear,
                String timeclass, String timemajor
            , String timeselect , String timeday
            , String time1, String time2
            , String time3, String time4
            , String time5, String time6, String time7) {
        this.academicyear = academicyear;
        this.timeclass = timeclass;
        this.timemajor = timemajor;
        this.timeday = timeday;
        this.timeselect = timeselect;
        this.time1 = time1;
        this.time2 = time2;
        this.time3 = time3;
        this.time4 = time4;
        this.time5 = time5;
        this.time6 = time6;
        this.time7 = time7;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public String getAcademicyear() {
        return academicyear;
    }

    public void setAcademicyear(String academicyear) {
        this.academicyear = academicyear;
    }

    public String getTimeclass() {
        return timeclass;
    }

    public void setTimeclass(String timeclass) {
        this.timeclass = timeclass;
    }

    public String getTimemajor() {
        return timemajor;
    }

    public void setTimemajor(String timemajor) {
        this.timemajor = timemajor;
    }

    public String getTimeselect() {
        return timeselect;
    }

    public void setTimeselect(String timeselect) {
        this.timeselect = timeselect;
    }

    public String getTimeday() {
        return timeday;
    }

    public void setTimeday(String timeday) {
        this.timeday = timeday;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getTime4() {
        return time4;
    }

    public void setTime4(String time4) {
        this.time4 = time4;
    }

    public String getTime5() {
        return time5;
    }

    public void setTime5(String time5) {
        this.time5 = time5;
    }

    public String getTime7() {
        return time7;
    }

    public void setTime7(String time7) {
        this.time7 = time7;
    }

    public String getTime6() {
        return time6;
    }

    public void setTime6(String time6) {
        this.time6 = time6;
    }
}
