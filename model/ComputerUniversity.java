package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by nclwin on 10/30/16.
 */

public class ComputerUniversity {
    String CUname;
    int CUImage;
    public ComputerUniversity() {
    }

    public ComputerUniversity(String CUname, int CUImage) {
        this.CUImage = CUImage;
        this.CUname = CUname;
    }

    public ComputerUniversity(String CUname) {
        this.CUname = CUname;
    }

    public String getCUname() {
        return CUname;
    }

    public void setCUname(String CUname) {
        this.CUname = CUname;
    }

    public int getCUImage() {
        return CUImage;
    }

    public void setCUImage(int CUImage) {
        this.CUImage = CUImage;
    }
}
