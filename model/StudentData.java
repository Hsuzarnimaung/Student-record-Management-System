package com.example.ucsm.studentrecordmanagement.model;

/**
 * Created by UCSM on 10/21/2016.
 */

public class StudentData {
    int databaseId;

    String studentId;
    String studentRollNo;
    String studentName;
    String studentGender;
    String studentDateofbirth;
    String studentFatherName;
    String studentClass;
    String studentMajor;
    String studentSection;
    String studentAcademic;
    String studentPhoneno;
    String studentEmail;
    String studentAddress;


    public StudentData() {
    }

    public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }

    public StudentData(String studentId,
                       String studentName, String studentRollNo, String studentGender,
                       String studentDateofbirth, String studentFatherName,
                       String studentClass, String studentMajor,
                       String studentAcademic, String studentSection,
                       String studentPhoneno, String studentEmail, String studentAddress) {

        this.studentId = studentId;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDateofbirth=studentDateofbirth;
        this.studentFatherName = studentFatherName;
        this.studentClass = studentClass;
        this.studentMajor = studentMajor;
        this.studentSection = studentSection;
        this.studentAcademic = studentAcademic;
        this.studentPhoneno = studentPhoneno;
        this.studentEmail=studentEmail;
        this.studentAddress = studentAddress;
    }


    public void setStudentMajor(String studentMajor){this.studentMajor=studentMajor;}
    public String getStudentMajor(){return studentMajor;}

    public void setStudentAcademic(String studentAcademic){this.studentAcademic=studentAcademic;}
    public String getStudentAcademic(){return studentAcademic;}

    /*public StudentData(int res, String studentName) {
        this.studentName=studentName;
    }*/

   /* public StudentData(int databaseId, String studentId,
                       String studentRollNo, String studentName,
                       String studentGender, String studentDateofbirth,
                       String studentFatherName, String studentSection,
                       String studentClass, String studentPhoneno,
                       String studentEmail, String studentAddress) {
        this.databaseId = databaseId;
        this.studentId = studentId;
        this.studentRollNo = studentRollNo;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDateofbirth = studentDateofbirth;
        this.studentFatherName = studentFatherName;
        this.studentSection = studentSection;
        this.studentClass = studentClass;
        this.studentPhoneno = studentPhoneno;
        this.studentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }*/

   /* public int getRes(){return res;}

    public void setRes(int res){this.res=res;}
*/
    /*public int getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(int databaseId) {
        this.databaseId = databaseId;
    }
*/
    public String getStudentDateofbirth() {
        return studentDateofbirth;
    }

    public void setStudentDateofbirth(String studentDateofbirth) {
        this.studentDateofbirth = studentDateofbirth;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
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

    public String getStudentFatherName() {
        return studentFatherName;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
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

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
}
