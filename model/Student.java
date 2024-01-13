package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/24/2016.
 */

public class Student {
    int databaseId;
    String studentId;
    String studentRollNo;
    String studentName;
    String studentGender;
    String studentDob;
    String studentFather;
    String studentClass;
    String studentMajor;
    String studentSection;
    String studentAcademic;
    String studentPhoneno;
    String studentEmail;
    String studentAddress;

    public Student() {
    }


    public Student( int databaseId,String studentId, String studentRollNo, String studentName, String studentGender, String studentDob,
                   String studentFather, String studentClass, String studentMajor,
                   String studentAcademic, String studentSection, String studentPhoneno,
                   String studentEmail, String studentAddress) {

        this.studentId = studentId;
        this.databaseId = databaseId;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDob = studentDob;
        this.studentFather = studentFather;
        this.studentClass = studentClass;
        this.studentMajor = studentMajor;
        this.studentAcademic = studentAcademic;
        this.studentSection = studentSection;
        this.studentPhoneno = studentPhoneno;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

    public Student(String studentId, String studentRollNo, String studentName, String studentGender, String studentDob,
                   String studentFather, String studentClass, String studentMajor,
                   String studentSection, String studentAcademic, String studentPhoneno,
                   String studentEmail, String studentAddress) {
        this.studentId = studentId;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDob = studentDob;
        this.studentFather = studentFather;
        this.studentClass = studentClass;
        this.studentMajor = studentMajor;
        this.studentSection = studentSection;
        this.studentAcademic = studentAcademic;
        this.studentPhoneno = studentPhoneno;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }


    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    public String getStudentAcademic() {
        return studentAcademic;
    }

    public void setStudentAcademic(String studentAcademic) {
        this.studentAcademic = studentAcademic;
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentRollNo() {
        return studentRollNo;
    }

    public void setStudentRollNo(String studentRollNo) {
        this.studentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentFather() {
        return studentFather;
    }

    public void setStudentFather(String studentFather) {
        this.studentFather = studentFather;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentSection() {
        return studentSection;
    }

    public void setStudentSection(String studentSection) {
        this.studentSection = studentSection;
    }

    public String getStudentPhoneno() {
        return studentPhoneno;
    }

    public void setStudentPhoneno(String studentPhoneno) {
        this.studentPhoneno = studentPhoneno;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
